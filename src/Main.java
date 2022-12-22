public class Main {

    public static void main(String[] args) {

        LogAnalyzer analyzer = new LogAnalyzer();

        System.out.println("Please provide input. Make sure you have entered command PROCEED as last line then hit enter.");

        analyzer.createLogsFromInput();
        analyzer.analyzeRequestLogs();


    }
}



