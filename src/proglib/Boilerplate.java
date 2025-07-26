package proglib;

import java.io.*;

public class Boilerplate {

    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = reader.readLine();
        reader.close();
        writer.write(input);
        writer.close();
    }
}
