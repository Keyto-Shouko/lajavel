package facade;
import lajavel.Application;
import org.slf4j.Logger;
public final class Log {
    private static Log instance;
    private final Logger logger;

    private  enum Level{
        DEBUG(3),
        INFO(2),
        WARN(1),
        ERROR(0);

        public final int level;

        Level(int level){
            this.level = level;
        }
    }

    private Log(){
        this.logger = org.slf4j.LoggerFactory.getLogger("lajavel");
    }

    private static Log getInstance(){
        if (instance == null){
            instance = new Log();
        }
        return instance;
    }

    public static void info(String infoMessage){
        print(Level.INFO,infoMessage);
        //getInstance().logger.info(infoMessage);
    }

    public static void warn(String warnMessage){
        print(Level.WARN,warnMessage);
        //getInstance().logger.info(infoMessage);
    }
    public static void error(String warnMessage){
        print(Level.ERROR,warnMessage);
    }

    public static void print (Level level, String message){
        switch (level){
            case DEBUG:
                if (Application.getInstance().mode.level >= Level.DEBUG.level){
                    getInstance().logger.debug(message);
                }
                break;
            case INFO:
                if (Application.getInstance().mode.level >= Level.INFO.level){
                    getInstance().logger.info(message);
                }
                break;
            case ERROR:
                if (Application.getInstance().mode.level >= Level.ERROR.level){
                    getInstance().logger.error(message);
                }
                break;
            case WARN:
                if (Application.getInstance().mode.level >= Level.WARN.level){
                    getInstance().logger.warn(message);
                }
                break;
        }
    }
}
