https://www.codingninjas.com/studio/problems/periodic-string_1094904
https://www.codingninjas.com/studio/problem-details/periodic-string_1094904
public class SubstringCheck {
    public static boolean isSubstring(String s, String S) {
        String T = (s + s).substring(1, s.length() * 2 - 1);  // Create T by concatenating s to itself and removing first and last character
        return T.indexOf(S) != -1;  // Check if S is a substring of T using indexOf() method
    }

    public static void main(String[] args) {
        String s = "hello";
        String S = "ell";
        boolean result = isSubstring(s, S);
        System.out.println(result);  // Output: true
    }
}
