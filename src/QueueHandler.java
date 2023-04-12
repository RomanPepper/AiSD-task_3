import java.util.Queue;
import java.util.Stack;

public class QueueHandler <T> {
    public boolean isPalindrome(Queue<T> inputQueue) {
        //Создадим параллельный стек, в котором будем хранить значения первой половины для сравнения со второй
        Stack<T> buffer = new Stack();
        if (inputQueue.size() % 2 == 0) {
            return recursionStepForEvenQueue(inputQueue, buffer, inputQueue.size(), 1);
        } else {
            return recursionStepForOddQueue(inputQueue, buffer, inputQueue.size(), 1);
        }
    }

    private boolean recursionStepForEvenQueue(Queue<T> inputQueue, Stack<T> buffer, int startQueueSize, int currDepth) {
        if (inputQueue.size() == 0 && buffer.size() == 0) {
            //Базис рекурсии
            return true;
        } else if (currDepth <= startQueueSize / 2) { //
            //До середины очереди
            buffer.push(inputQueue.poll());
            boolean value = recursionStepForOddQueue(inputQueue, buffer, startQueueSize, currDepth + 1);
            inputQueue.add(buffer.pop());

            return value;
        } else {
            //После середины
            T val1 = inputQueue.poll();
            T val2 = buffer.pop();
            boolean value = (val1.equals(val2)) && recursionStepForOddQueue(inputQueue, buffer, startQueueSize, currDepth + 1);
            inputQueue.add(val1);
            buffer.add(val2);

            return value;
        }
    }

    private boolean recursionStepForOddQueue(Queue<T> inputQueue, Stack<T> buffer, int startQueueSize, int currDepth) {
        if (inputQueue.size() == 0 && buffer.size() == 0) {
            //Базис рекурсии
            return true;
        } else if (currDepth <= startQueueSize / 2) { //
            //До середины очереди
            buffer.push(inputQueue.poll());
            boolean value = recursionStepForOddQueue(inputQueue, buffer, startQueueSize, currDepth + 1);
            inputQueue.add(buffer.pop());

            return value;
        } else if (currDepth == startQueueSize / 2 + 1) {
            //Ровно середина очереди
            buffer.push(inputQueue.peek());
            return recursionStepForOddQueue(inputQueue, buffer, startQueueSize, currDepth + 1);
        } else {
            //После середины
            T val1 = inputQueue.poll();
            T val2 = buffer.pop();
            boolean value = (val1.equals(val2)) && recursionStepForOddQueue(inputQueue, buffer, startQueueSize, currDepth + 1);
            inputQueue.add(val1);
            buffer.add(val2);

            return value;
        }
    }
}
