package product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.LogControlTime;

public class car {
    public static void listccar(String args) {
        final Logger Logger = LogManager.getLogger();
        final LogControlTime LOGCT = new LogControlTime();
        String LOGCTSequence = "";
        long LogControlTimeInit = System.currentTimeMillis();
        System.out.println(Logger.getName());
//        int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
//        System.out.println("The Current Line Number is " + LOGCT.getLineNumber());
//        String MethodName = new Exception().getStackTrace()[0].getMethodName();
//        System.out.println("The method name is: " + LOGCT.getMethodName());
        LOGCTSequence = "1";
//        LOGCTSequence = LOGCT.UpdateSequence();
        LogControlTimeInit = System.currentTimeMillis();
        LOGCT.PrintLogTime("Servicio de autorizacion", LOGCT.getMethodName(), LOGCT.getLineNumber(), LogControlTimeInit, LOGCTSequence);
//        MDC.clear();
    }
}
