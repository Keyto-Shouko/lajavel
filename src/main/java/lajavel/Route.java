package lajavel;

import controller.Controller;
import enums.HttpVerbs;
import facade.Log;
import facade.Response;
import io.javalin.http.Context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Route {
    public static void register(HttpVerbs httpVerbs, String routeName, Class<?> controllerClass, String methodName) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Application app = Application.getInstance();
        switch (httpVerbs){
            case GET :
                app.server.get(routeName, ctx -> invokeController(ctx,controllerClass,methodName));
                break;
            case POST :
                app.server.get(routeName, ctx -> ctx.redirect("https://www.youtube.com/watch?v=xqAhc2yVcbs"));
                break;
            case PUT :
                app.server.get(routeName, ctx -> ctx.html(View.make("show")));
                break;

        }
    }

    public static void invokeController(Context context, Class<?> controllerClass, String methodName) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Response response = new Response(context);
        Controller controller = (Controller)controllerClass.getDeclaredConstructor().newInstance();
        Method controllerMethod = controllerClass.getDeclaredMethod(methodName,Response.class);
        controllerMethod.setAccessible(true);
        controllerMethod.invoke(controller,response);

    }
}
