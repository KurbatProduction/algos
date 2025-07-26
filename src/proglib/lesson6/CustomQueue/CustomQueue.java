package proglib.lesson6.CustomQueue;

import java.io.*;

public class CustomQueue {

    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        boolean output = true;
        for (int i = 0; i < count && output; i++) {
            String input = reader.readLine();
            int spaceIndex = input.indexOf(' ');
            int command = parseInt(input, 0, spaceIndex);
            int value = parseInt(input, spaceIndex + 1, input.length());
            output = command == 3 ? queue.offer(value) : queue.poll() == value;
        }
        reader.close();
        writer.write(output ? YES : NO);
        writer.close();
    }

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final Queue queue = new Queue();

    private static class Queue {
        private int[] buffer;
        private int capacity;
        private int head;
        private int tail;
        private int size;

        public Queue() {
            this.tail = 0;
            this.head = 0;
            this.size = 0;
            this.capacity = 50;
            this.buffer = new int[capacity];
        }

        public boolean offer(int value) {
            if (size == capacity) resize();

            buffer[tail] = value;
            tail = (tail + 1) % capacity;
            size++;
            return true;
        }

        private void resize() {
            int newCapacity = capacity * 2;
            int[] newBuffer = new int[newCapacity];

            if (head < tail) System.arraycopy(buffer, head, newBuffer, 0, size);
            else {
                System.arraycopy(buffer, head, newBuffer, 0, capacity - head);
                System.arraycopy(buffer, 0, newBuffer, capacity - head, tail);
            }

            buffer = newBuffer;
            capacity = newCapacity;
            head = 0;
            tail = size;
        }

        public int poll() {
            if (size == 0) return -1;
            int value = buffer[head];
            head = (head + 1) % capacity;
            size--;
            return value;
        }
    }

    public static int parseInt(CharSequence s, int begin, int end) {
        int result = 0;
        boolean negative = false;

        if (s.charAt(begin) == '-') {
            negative = true;
            begin++;
        }

        for (int i = begin; i < end; i++) {
            char c = s.charAt(i);
            result = result * 10 + (c - '0');
        }

        return negative ? -result : result;
    }
}
