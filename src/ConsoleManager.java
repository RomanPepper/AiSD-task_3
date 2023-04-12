import java.util.*;

public class ConsoleManager {
    public Queue<String> readDeque() { //Заполнение происходит в прямом порядке
        Scanner scanner = new Scanner(System.in);
        Queue queue = new LinkedList();

        String inputString = scanner.nextLine();
        String[] symbolArray = inputString.split(" , | ,|, |,");

        for(String currSymbol: symbolArray) {
            queue.add(currSymbol);
        }

        return queue;
    }
}
