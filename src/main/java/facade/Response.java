package facade;

import io.javalin.http.Context;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public final class Response {
    private final Context context;

    public HttpServletRequest request;

    public Response(Context context) {

        this.context = context;
        this.request = context.req;
    }

    public void status(int status ){
        this.context.status(status);
    }

    public void json(Object obj ){
        this.context.json(obj);
    }

    public void html(String html ){
        this.context.html(html);
    }

    public void render(String path){
        this.context.render(path);
    }

    public void redirect(String url){
        this.context.redirect(url);
    }
}
