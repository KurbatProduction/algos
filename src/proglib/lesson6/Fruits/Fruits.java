package proglib.lesson6.Fruits;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

public class Fruits {

    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = reader.readLine();
        reader.close();

        fillQueue(input);
        processQueue();
        for (Integer i : list)  writer.write(i + " ");

        writer.close();
    }

    private static final Queue<Integer> queue = new ArrayDeque<>();
    private static final List<Integer> list = new ArrayList<>();

    public static void fillQueue(String fruits) {
        for (String fruit : fruits.split(" ")) queue.offer(Integer.parseInt(fruit));
    }

    public static void processQueue() {
        int lastEaten = 0;
        int skipped = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current >= lastEaten || skipped == 2) {
                lastEaten = current;
                skipped = 0;
                list.add(current);
            } else {
                queue.offer(current);
                skipped++;
            }
        }
    }
}
