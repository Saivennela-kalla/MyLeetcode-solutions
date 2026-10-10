class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int longest = 1;

        for (int center = 0; center < s.length(); center++) {
            int oddLength = expand(s, center, center);
            int evenLength = expand(s, center, center + 1);
            int length = Math.max(oddLength, evenLength);

            if (length > longest) {
                longest = length;
                start = center - (length - 1) / 2;
            }
        }

        return s.substring(start, start + longest);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}