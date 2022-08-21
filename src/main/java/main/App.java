package main;

import org.slf4j.MDC;
import product.car;

@Component
public class App {


    public static void main(String[] args) {
        MDC.put("idacquirer", "16416554131");
        MDC.put("idcommerce", "435141");
        MDC.put("numberOperation", "543458");
        MDC.put("level", "INFO");
        MDC.put("canal", "REST");
        MDC.put("logType", "CONTROL_TAG");
        MDC.put("secuencia", "0");
        LoggerChild.log();
//        logger.trace("We've just greeted the user!");
//        logger.debug("We've just greeted the user!");
//        logger.info("We've just greeted the user!");
//        logger.warn("We've just greeted the user!");
//        logger.error("We've just greeted the user!");
//        logger.fatal("We've just greeted the user!");
    }

    private static class LoggerChild {
//        private static final Logger childLogger = LogManager.getLogger(LoggerChild.class);

        static void log() {
            car.listccar("Hiunday");
//            System.out.println(childLogger.getName());
        }
    }
}