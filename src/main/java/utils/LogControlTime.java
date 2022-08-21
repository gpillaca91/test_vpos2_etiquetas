package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import com.google.gson.Gson;

import java.util.*;


public class LogControlTime {
    private static final Logger LOG_TIME = LogManager.getLogger("VPOS2_TIME");
    private String idsession;
    private String idmetodo;
    private String idacquirer;
    private String idcommerce;
    private String idordernumber;
    private String channel;
    private String logType;
    private String level;
    private String sequence;
    private String description;
    private String originClassMethod;
    private String destinyClassMethod;
    private String lineControlClass;
    private String totalTime;
    private long fechaIni;
    private String operating_system;

    private List<LogControlTime> listLog;


    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }


    public LogControlTime(String description, String originClassMethod, String lineControlClass, long fechaIni, String sequence) {
        this.description = description;
        this.originClassMethod = originClassMethod;
        this.lineControlClass = lineControlClass;
        this.fechaIni = fechaIni;
        this.sequence = sequence;
    }

    public LogControlTime() {
    }

    public String getLineNumber() {
        String LineNumber = "";
        try {
            LineNumber = String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber());
        } catch (Exception e) {
            LOG_TIME.error(e.getMessage(), e);
        } finally {
            String list = new Gson().toJson(listLog);
            LOG_TIME.info(list);
//            this.listLog.clear();
        }
        return LineNumber;
    }

    public String getMethodName() {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return className + "." + methodName;
    }

    public void PrintLogTime(String description, String originClassMethod, String lineControlClass, long fechaIni, String sequence) {

        try {
            listLog = new ArrayList<LogControlTime>();
            LogControlTime objLog = new LogControlTime(description, originClassMethod, lineControlClass, fechaIni, sequence);
            objLog.setIdsession(MDC.get("idsession"));
            objLog.setIdmetodo(MDC.get("idmetodo"));
            objLog.setLevel(MDC.get("level"));
            objLog.setLogType(MDC.get("logType"));
            objLog.setIdacquirer(MDC.get("idacquirer"));
            objLog.setIdcommerce(MDC.get("idcommerce"));
            objLog.setIdordernumber(MDC.get("numberOperation"));
            if (objLog.getSequence().equals("1")) {
                objLog.setChannel("Total - " + MDC.get("canal"));
            } else {
                objLog.setChannel(MDC.get("canal"));
            }
            objLog.setTotalTime((System.currentTimeMillis() - objLog.getFechaIni()) + "");
            this.listLog.add(objLog);
        } catch (Exception e) {
            LOG_TIME.error(e.getMessage(), e);
        } finally {
            String list = new Gson().toJson(listLog);
            LOG_TIME.info(list);
            this.listLog.clear();
        }


    }

    public String UpdateSequence() {
        System.out.println("secuencia: " + MDC.get("secuencia"));
        Integer seq = Integer.parseInt(MDC.get("secuencia")) + 1;
        MDC.put("secuencia", seq + "");
        return seq + "";
    }

    public List<LogControlTime> getListLog() {
        return listLog;
    }

    public void setListLog(List<LogControlTime> listLog) {
        this.listLog = listLog;
    }

    public String getIdsession() {
        return idsession;
    }

    public void setIdsession(String idsession) {
        this.idsession = idsession;
    }

    public String getIdmetodo() {
        return idmetodo;
    }

    public void setIdmetodo(String idmetodo) {
        this.idmetodo = idmetodo;
    }

    public String getIdacquirer() {
        return idacquirer;
    }

    public void setIdacquirer(String idacquirer) {
        this.idacquirer = idacquirer;
    }

    public String getIdcommerce() {
        return idcommerce;
    }

    public void setIdcommerce(String idcommerce) {
        this.idcommerce = idcommerce;
    }

    public String getIdordernumber() {
        return idordernumber;
    }

    public void setIdordernumber(String idordernumber) {
        this.idordernumber = idordernumber;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginClassMethod() {
        return originClassMethod;
    }

    public void setOriginClassMethod(String originClassMethod) {
        this.originClassMethod = originClassMethod;
    }

    public String getDestinyClassMethod() {
        return destinyClassMethod;
    }

    public void setDestinyClassMethod(String destinyClassMethod) {
        this.destinyClassMethod = destinyClassMethod;
    }

    public String getLineControlClass() {
        return lineControlClass;
    }

    public void setLineControlClass(String lineControlClass) {
        this.lineControlClass = lineControlClass;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public long getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(long fechaIni) {
        this.fechaIni = fechaIni;
    }
}

