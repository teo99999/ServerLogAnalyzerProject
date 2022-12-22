import java.util.*;

public class LogAnalyzer {

    private List<RequestLog> logs;

    public LogAnalyzer() {
        this.logs = new ArrayList<>();
    }

    public void addLogs(RequestLog log) {
        this.logs.add(log);
    }

    public void analyzeRequestLogs() {

        System.out.println("The percentage of requests with status code different than 200 is: " + calculatePercentageByResponseType());

        System.out.println("Slowest requests are: ");
        findSlowestRequest();
    }

    private int calculatePercentageByResponseType() {

        int total = 0;
        int differentThan200 = 0;
        int calculatedPercentage;

        for (RequestLog log : this.logs) {
            total++;

            if (log.getResponse() != 200) {
                differentThan200++;
            }
        }

        calculatedPercentage = (differentThan200 * 100) / total;

        return calculatedPercentage;
    }

    private void findSlowestRequest() {

        List<RequestLog> slowestRequests = this.logs.stream().sorted(RequestLog::compareTo).sorted(Comparator.reverseOrder()).limit(3).toList();

        slowestRequests.forEach(System.out::println);
    }

    public void createLogsFromInput() {

        ArrayList<String> logAttributes = formatInput();

        validateInput(logAttributes);

        for (String attribute : logAttributes) {
            String[] arr = attribute.split(" ");
            RequestLog log = new RequestLog();

            log.setDate(arr[0]);
            log.setTime(arr[1]);
            log.setIpAddress(arr[2]);
            log.setHttpMethod(arr[3]);
            log.setPath(arr[4]);
            log.setResponse(Integer.parseInt(arr[5]));
            log.setTimeMs(Integer.parseInt(arr[7]));

            if (arr[6].equals("-")) {
                log.setSize(0);
            } else {
                log.setSize(Integer.parseInt(arr[6]));
            }

            this.addLogs(log);
        }
    }

    private ArrayList<String> formatInput() {

        ArrayList<String> logAttributes = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("proceed")) {
                break;
            } else if (line.isBlank()) {
                throw new IllegalArgumentException("Input cannot be empty or whitespace.");
            }

            logAttributes.add(line);
        }

        return logAttributes;
    }

    public void validateInput(ArrayList<String> logAttributes) {

        for (String attribute : logAttributes) {
            String[] arr = attribute.split(" ");

            if (arr.length != 8) {
                throw new IllegalArgumentException("Incomplete input. Please make sure you have entered: \nDate  Time  IP  Method  Path  Response  Size  Time(ms)");
            }

            if (!arr[0].matches("^\\d{4}\\/\\d{2}\\/\\d{2}")) {
                throw new IllegalArgumentException("Invalid input. Date should be in format yyyy-mm-dd");
            }

            if (!arr[1].matches("\\d{2}:\\d{2}:\\d{2}")) {
                throw new IllegalArgumentException("Invalid input. Time should be in format hh:mm:ss");
            }

            if (!arr[2].matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}")) {
                throw new IllegalArgumentException("Invalid ip address format.");
            }

            if (!arr[3].matches("(GET|PUT|POST|PATCH|DELETE)")) {
                throw new IllegalArgumentException("Invalid input. HTTP response should be one of the following: GET, PUT, POST, PATCH, DELETE");
            }

            if (!arr[4].matches("(([^\\s]+)|)")) {
                throw new IllegalArgumentException("Invalid input. Please make sure path doesn't contain whitespace");
            }

            if (!arr[5].matches("\\d{3}")) {
                throw new IllegalArgumentException("Invalid input. Please enter correct HTTP response status code");
            }

            if (!arr[6].matches("((?:[1-9][0-9]{0,5}(?:\\.\\d{1,2})?|100000|100000.00)|-)")) {
                throw new IllegalArgumentException("Invalid input. Please enter number or '-'");
            }

            if (!arr[7].matches("((?:[1-9][0-9]{0,5}(?:\\.\\d{1,2})?|100000|100000.00)|-)")) {
                throw new IllegalArgumentException("Invalid input. Please enter number");
            }

        }

    }


}


