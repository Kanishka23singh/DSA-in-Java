public class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int[] charIndex = new int[128]; // Array to store the index of the last occurrence of each character.
    int maxLen = 0; // The length of the longest substring without repeating characters.
    int left = 0; // The left index of the sliding window.

    for (int right = 0; right < s.length(); right++) {
      char currentChar = s.charAt(right);

      // If the character is already present in the window, update the left index of the window to the index of that character.
      if (charIndex[currentChar] >= left) {
        left = charIndex[currentChar] + 1;
      }

      // Update the index of the last occurrence of the current character.
      charIndex[currentChar] = right;

     // Calculate the length of the current substring and update the maximum length if necessary.
      maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }
}
