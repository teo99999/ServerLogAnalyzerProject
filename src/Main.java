public class Main {

    public static void main(String[] args) {

        LogAnalyzer analyzer = new LogAnalyzer();

        analyzer.createLogsFromInput();
        analyzer.analyzeRequestLogs();

        analyzer.validateInput();
    }
}



