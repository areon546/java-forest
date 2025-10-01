package forest.util;

import forest.collections.TownBuilding;

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

    public static char[] allowed(String s) {
        char[] cs = new char[s.length()];
        s.getChars(0, s.length(), cs, 0);

        return cs;
    }

    public static String chars(char[] chars) {
        StringBuilder s = new StringBuilder("[");

        for (char c : chars) {
            s.append(Character.toString(c));

            if (c != chars[chars.length -1 ]) {
                s.append(", ");
            }
        }

        return s + "]";
    }

    /**
     *
     * @param question  Question prepended to options.
     * @param symbols   A parallel array to `desc`
     * @param desc      A short description of the option.
     * @return Returns the character inputted by the user. It asks repeatedly until they input a valid symbol.
     */
    public static char ask(String question, Character[] symbols, Object[] desc) {
        StringBuilder message = new StringBuilder(question);
        StringBuilder allowed = new StringBuilder();
        for (int i=0; i<symbols.length; i++) {
            char symbol = symbols[i];
            message.append("\n[").append(symbol).append("] ").append(desc[i]);
            allowed.append(symbol);
        }

        return util.InputChar(message.toString(), util.allowed(allowed.toString()));
    }

}
