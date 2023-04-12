import java.util.Queue;

public class Main {
    //task 3.22
    public static void main(String[] args) {
        ConsoleManager consoleManager = new ConsoleManager();
        QueueHandler queueHandler = new QueueHandler();
        Queue queue = consoleManager.readDeque();

        System.out.println(queueHandler.isPalindrome(queue));


//        int queueSize = queue.size();
//        for(int i = 0; i < queueSize; i++) {
//            System.out.println(queue.poll());
//        }
    }
}