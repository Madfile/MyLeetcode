import java.util.*;

public class Leetcode_937_Reorder_Data_in_Log_Files {
    class Log {
        String id;
        String content;
        boolean isNumberLog;
        public Log(String raw){
            int index = raw.indexOf(" ");
            id = raw.substring(0, index);
            content = raw.substring(index + 1, raw.length());
            isNumberLog = '0' <= content.charAt(0) && content.charAt(0) <= '9';
        }

        public String toString(){
            return id + " " + content;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        List<Log> list = new ArrayList<>();
        for (int i = 0; i < logs.length; i ++) list.add(new Log(logs[i]));
        list.sort((a,b)->(compare(a, b)));
        for (int i = 0 ; i < list.size(); i++) logs[i] = list.get(i).toString();
        return logs;
    }

    public int compare(Log a, Log b){
        if (!a.isNumberLog && b.isNumberLog) return -1;
        if (a.isNumberLog && !b.isNumberLog) return 1;
        if (a.isNumberLog && b.isNumberLog) return 0;
        int r = a.content.compareTo(b.content);
        return r != 0 ? r : a.id.compareTo(b.id);
    }
}