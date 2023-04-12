import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class QueueHandler<T> {
    public boolean isPalindrome(Queue<T> inputQueue) {
        //Создадим параллельный стек, в котором будем хранить значения первой половины для сравнения со второй
        Stack<T> buffer = new Stack<>();
        return recursionStep(inputQueue, buffer, inputQueue.size(), 1);
    }

    private boolean recursionStep(Queue<T> inputQueue, Stack<T> buffer, int startQueueSize, int currDepth) {
        if (inputQueue.size() == 0 && buffer.size() == 0) {
            //Базис рекурсии
            return true;
        } else if (currDepth <= startQueueSize / 2) {
            //До середины очереди
            buffer.push(inputQueue.poll());
            boolean value = recursionStep(inputQueue, buffer, startQueueSize, currDepth + 1);
            inputQueue.add(buffer.pop());

            return value;
        } else if (startQueueSize % 2 == 1 && currDepth == startQueueSize / 2 + 1) {
            //Ровно середина очереди (Только для очередей с нечетным количеством символов вначале)

            T median = inputQueue.poll();
            boolean value = recursionStep(inputQueue, buffer, startQueueSize, currDepth + 1);
            inputQueue.add(median);
            return value;
        } else {
            //После середины
            T val1 = inputQueue.poll();
            T val2 = buffer.pop();
            boolean value = (Objects.equals(val1, val2)) && recursionStep(inputQueue, buffer, startQueueSize, currDepth + 1);
            inputQueue.add(val1);
            buffer.add(val2);

            return value;
        }
    }
}
