import java.util.*;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Populate frequency array for p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Sliding window technique
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++; // Add current character

            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--; // Remove left character
            }

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1); // Found anagram start index
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> indices = findAnagrams(s, p);
        System.out.println("Anagram start indices: " + indices);
    }
}
