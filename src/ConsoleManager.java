import java.util.*;

public class ConsoleManager {
    public List<String> readSymbolList() { //Заполнение происходит в прямом порядке
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        String[] symbolArray = inputString.split(" , | ,|, |,");

        return Arrays.asList(symbolArray);
    }
}
