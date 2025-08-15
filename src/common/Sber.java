package common;

public class Sber {

    private static final String DATA =
            """
            4;Test;Canada;1;2;3;4;5
            7;Test2;USA;3;4;5;7;14;5;6
            3;Test3;Russia;3;4;5;1;1;1;5;6
            4;Test4;Germany;3;4;5;3;3;4;5;6
            5;Test5;Japan;3;4;5;3;3;3;4;5;6
            6;Test6;China;3;4;5;12;3;4;5;6""";

    public static void main(String[] args) {
        System.out.println(DATA);
        System.out.println();
        System.out.println(findWinner());
    }

    private static String findWinner() {
        int breakCounter = 0;
        for (char c : DATA.toCharArray()) if (c == '\n') breakCounter++;

        int winnerIdx = 0;
        int winnerPlaceCounter = 0;

        int idx = 0;
        int teamIdx = 0;
        int delimiterCounter = 0;

        while (teamIdx <= breakCounter) {
            char c = DATA.charAt(idx);
            if (c == ';') delimiterCounter++;
            idx++;

            if (delimiterCounter == 3) {
                int placeCounter = 0;
                while (idx < DATA.length() && DATA.charAt(idx) != '\n') {
                    if (DATA.charAt(idx) == ';') {
                        idx++;
                        continue;
                    }
                    int place = 0;
                    while (idx < DATA.length()
                            && DATA.charAt(idx) != ';'
                            && DATA.charAt(idx) != '\n') {
                        place = place * 10 + DATA.charAt(idx) - '0';
                        idx++;
                    }
                    if (place == 1) placeCounter++;
                }
                if (placeCounter > winnerPlaceCounter) {
                    winnerPlaceCounter = placeCounter;
                    winnerIdx = teamIdx;
                }
                delimiterCounter = 0;
                teamIdx++;
            }
        }

        breakCounter = 0;
        StringBuilder result = new StringBuilder();
        for (idx = 0; idx < DATA.length(); idx++) {
            char c = DATA.charAt(idx);
            if (breakCounter == winnerIdx) {
                while (idx < DATA.length() && c != '\n') {
                    result.append(c);
                    c = DATA.charAt(++idx);
                }
            }
            if (c == '\n') breakCounter++;
        }
        return result.toString();
    }
}
