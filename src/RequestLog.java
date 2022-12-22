
public class RequestLog implements Comparable<RequestLog> {

    private String date;

    private String time;

    private String ipAddress;

    private String httpMethod;

    private String path;

    private int response;

    private int size;

    private int timeMs;

    public RequestLog() {
    }

    public int getResponse() {
        return response;
    }

    public int getTimeMs() {
        return timeMs;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTimeMs(int timeMs) {
        this.timeMs = timeMs;
    }

    @Override
    public String toString() {
        return "RequestLog{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", path='" + path + '\'' +
                ", response=" + response +
                ", size=" + size +
                ", timeMs=" + timeMs +
                '}';
    }

    @Override
    public int compareTo(RequestLog log) {
        return Integer.compare(this.getTimeMs(), log.getTimeMs());
    }
}
