import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    //task 3.22
    public static void main(String[] args) {
        ConsoleManager consoleManager = new ConsoleManager();
        QueueHandler<String> queueHandler = new QueueHandler<>();

        Queue<String> queue = new LinkedList<>(consoleManager.readSymbolList());
        System.out.println(queueHandler.isPalindrome(queue));

        //OR
//
//        CustomQueue<String> customQueue = new CustomQueue<>(consoleManager.readSymbolList());
//        System.out.println(customQueue.isPalindrome());

    }
}