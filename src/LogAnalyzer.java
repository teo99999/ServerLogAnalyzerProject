import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzer {

    private List<RequestLog> logs;

    public LogAnalyzer() {
        this.logs = new ArrayList<>();
    }

    public List<RequestLog> getLogs() {
        return logs;
    }

    public void addLogs(RequestLog log){
        this.logs.add(log);
    }

    private int calculatePercentageByResponseType(){

        int total = 0;
        int differentThan200 = 0;
        int calculatedPercentage = 0;

       for(RequestLog log : this.logs){
           total++;

           if(log.getResponse() != 200){
               differentThan200++;
           }
       }

       calculatedPercentage = (differentThan200 * 100)/total;

       return calculatedPercentage;
    }

    private void findSlowestRequest(){

       List<RequestLog> slowestRequests = this.logs.stream().sorted(RequestLog::compareTo).sorted(Comparator.reverseOrder()).limit(3).toList();

        slowestRequests.forEach(System.out::println);
    }

    public void analyzeRequestLogs(){

        System.out.println("The percentage of requests with status code different than 200 is: " + calculatePercentageByResponseType());

        System.out.println("Slowest requests are: ");
        findSlowestRequest();
    }

    private ArrayList<String> formatInput() {

        ArrayList<String> input = new ArrayList<String>();
        Scanner s = new Scanner(System.in);

        while (s.hasNext()){
            String read = s.nextLine();

            if(read.equalsIgnoreCase("proceed")){
                break;
            }
            else if(read.isBlank()){
                throw new IllegalArgumentException("Input cannot be empty.");
            }

            input.add(read);
        }

        return input;
    }

    public void createLogsFromInput(){

        ArrayList<String> input = formatInput();

        for(String element : input){
            String[] arr = element.split(" ");
            RequestLog log = new RequestLog();

            if(!arr[0].matches("^\\d{4}\\/\\d{2}\\/\\d{2}")){
                throw new IllegalArgumentException("Invalid input");
            }

            if(!arr[1].matches("\\d{2}:\\d{2}:\\d{2}")){
                throw new IllegalArgumentException("Invalid input");
            }

            if(!arr[2].matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}")){
                throw new IllegalArgumentException("Invalid input");
            }

            if(!arr[3].matches("(GET|PUT|POST|PATCH|DELETE)")){
                throw new IllegalArgumentException("Invalid input");
            }

            if(!arr[4].matches("(([^\\s]+)|)")){
                throw new IllegalArgumentException("Invalid input");
            }

            if(!arr[5].matches("\\d{3}")){
                throw new IllegalArgumentException("Invalid input");
            }
            //works until here

          /*  if(!arr[6].matches("((?:[1-9][0-9]{0,4}(?:\\.\\d{1,2})?|100000|100000.00)|-)")){
                throw new IllegalArgumentException("Invalid input");
            }*/

            if(!arr[7].matches("")){
                throw new IllegalArgumentException("Invalid input");
            }


            if(arr.length != 8){
                throw new IllegalArgumentException("Incomplete input");
            }

            log.setDate(arr[0]);
            log.setTime(arr[1]);
            log.setIpAddress(arr[2]);
            log.setHttpMethod(arr[3]);
            log.setPath(arr[4]);
            log.setResponse(Integer.parseInt(arr[5]));
            log.setTimeMs(Integer.parseInt(arr[7]));

           if(arr[6].equals("-")) {
               log.setSize(0);
           }else {
               log.setSize(Integer.parseInt(arr[6]));
           }

           this.addLogs(log);
        }



    }

    public void validateInput(){
        ArrayList<String> input = formatInput();

        for(String element : input) {
            String[] arr = element.split(" ");

            if(arr[0].matches("^\\d{4}\\/\\d{2}\\/\\d{2}")){
                System.out.println("ok");
            }


        }
        System.out.println("no");
    }

    }


