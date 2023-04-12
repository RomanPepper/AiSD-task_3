import java.util.*;

public class CustomQueue<T> {
    LinkedList<T> elements;

    public CustomQueue(List<T> elements) {
        this.elements = new LinkedList<>(elements);
    }

    public boolean isPalindrome() {
        Stack<T> buffer = new Stack<>();
        return recursionStep(elements, buffer, elements.size(), 1);
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
            buffer.push(inputQueue.peek());
            return recursionStep(inputQueue, buffer, startQueueSize, currDepth + 1);
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

    public boolean offer(T element) {
        try {
            elements.addLast(element);
        } catch (NullPointerException exception) {
            return false;
        }
        return true;
    }

    public T peek() {
        return (elements.size() == 0) ? null : elements.peek();
    }

    public T poll() {
        return (elements.size() == 0) ? null : elements.poll();
    }

    public T remove() {
        if (elements.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return elements.remove();
        }
    }

    public T element() {
        if(elements.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return elements.element();
        }
    }

    public int size() {
        return elements.size();
    }
}
