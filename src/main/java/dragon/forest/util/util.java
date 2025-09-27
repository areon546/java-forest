package dragon.forest.util;

import java.util.Scanner;

public class util {

    public static String Input(String message) {
        Scanner sc = new Scanner(System.in);

        util.Output(message);
        return sc.nextLine().toUpperCase();
    }

    public static void Output(String msg) {
        System.out.println(msg);
    }

    public static char InputChar(String msg, char[] allowed) {
        String in = Input(msg);
        if (in.isEmpty()) {
            return failedInput(msg, allowed);
        }

        char c = in.charAt(0);
        boolean notAllowed = !charIn(c, allowed);
        if (notAllowed) {
            return failedInput(msg, allowed);
        }

        return c;
    }

    private static char failedInput(String msg, char[] allowed) {
        Output("Sorry I didn't understand that. Only " + chars(allowed) + " are valid. ");
        return InputChar(msg, allowed);
    }

    public static boolean charIn(char c, char[] allowed) {
        for (char valid : allowed) {
            if (valid == c) {
                return true;
            }
        }
        return false;
    }

    public static String chars(char[] chars) {
        String s = "[";

        for (char c : chars) {
            s += Character.toString(c) ;

            if (c != chars[chars.length -1 ]) {
                s+=", ";
            }
        }

        return s + "]";
    }


}
