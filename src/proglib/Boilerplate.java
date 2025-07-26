package proglib;

import java.io.*;

public class Boilerplate {

    public static void main(String[] args) {
        BufferedReader reader = getReader();
        String input = read(reader);
        close(reader);

        String output = input + " ";

        BufferedWriter writer = getWriter();
        write(writer, output);
        close(writer);
    }

    public static BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    public static String read(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedWriter getWriter() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void write(BufferedWriter writer, String value) {
        try {
            writer.write(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(BufferedWriter writer) {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
