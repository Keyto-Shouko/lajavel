package lajavel;

import facade.Log;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Application {
    public enum Mode{
        PRODUCTION(0),
        TEST(1),
        DEVELOPEMENT(3),
        INFO(2);

        public final int level;
        Mode(int level){
            this.level = level;
        }
    }
    private static Application instance;
    public Javalin server;
    public int port;
    public final Mode mode;

    private Application(int port, Mode mode){
        this.port = port;
        this.server = Javalin.create(config ->{
            config.addStaticFiles("/public", Location.CLASSPATH);
        } ).start(this.port);
        this.mode = mode;
    }

    public static void start(int port){
        start(port,Mode.PRODUCTION);
    }

    public static void start(int port, Mode mode){
        if(instance==null){
            instance = new Application(port,mode);
            Log.info("Application started");
        }else{
            throw new RuntimeException("Instance already exist");
        }
    }
    public static Application getInstance(){
        if(instance == null){
            throw new RuntimeException("Application not started");
        }
        return instance;
    }
}
