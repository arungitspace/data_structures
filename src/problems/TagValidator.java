package problems;

import java.util.Stack;

public class TagValidator {
    public static void main(String[] args) {
        String code = "<DIV>T<![CDATA[<div>]]></DIV>";
        System.out.println(isValid(code));
    }

    public static boolean isValid(String code) {
        Stack<String> stack = new Stack<>();

        int i = 0;
        int len = code.length();
        while (i < len) {
            if (i > 0 && stack.isEmpty()) {
                return false;
            }
            if (code.startsWith("<![CDATA[", i)) { //<![CDATA[
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i == -1) {
                    return false;
                }
                i = i + 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i == -1) {
                    return false;
                }
                String tag = code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(tag)) {
                    return false;
                }
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i == -1) {
                    return false;
                }
                String tagName = code.substring(j, i++);
                if (tagName.length() < 1 || tagName.length() > 9) {
                    return false;
                }
                for (char c : tagName.toCharArray()) {
                    if (!Character.isUpperCase(c)) {
                        return false;
                    }
                }
                stack.push(tagName);
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }

}
