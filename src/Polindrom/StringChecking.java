package Polindrom;

public class StringChecking {

    public static void main(String[] args) {
        String[] strings = {
            "",
            "a",
            "aa",
            "ab",
            "aba",
            "abc",
            "abba",
            "abcd",
            "Aba",
            "a man a plan a canal panama",
            "racecar",
            "hello",
            "madam",
            "level",
            "not a palindrome",
            "12321",
            "12345",
            "Was it a car or a cat I saw",
            "No 'x' in Nixon",
            "Python"
        };

        for (String string : strings) {
            System.out.println(string + " - " + checkStringFromMiddle(string));
        }

        System.out.println("--------------------------------");

        for (String string : strings) {
            System.out.println(string + " - " + checkStringFromCorners(string));
        }
    }

    public static boolean checkStringFromMiddle(String str) {
        str = str.toLowerCase();
        int i, j;
        if (str.length() % 2 == 0) {
            i = str.length() / 2 - 1;
            j = str.length() / 2;
        } else {
            i = str.length() / 2;
            j = i;
        }

        while (i >= 0 && j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i--;
            j++;
        }

        return true;
    }

    public static boolean checkStringFromCorners(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            char left = Character.toLowerCase(str.charAt(i));
            char right = Character.toLowerCase(str.charAt(j));
            if (left != right) {
                if (!Character.isLetterOrDigit(left)) {
                    i++;
                    continue;
                }
                if (!Character.isLetterOrDigit(right)) {
                    j--;
                    continue;
                }
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
