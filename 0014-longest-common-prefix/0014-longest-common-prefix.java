class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String min = strs[0];
        String max = strs[0];
        for (String s : strs) {
            if (s.compareTo(min) < 0) min = s;
            if (s.compareTo(max) > 0) max = s;
        }
        int i = 0;
        while (i < min.length() && i < max.length() && min.charAt(i) == max.charAt(i)) {
            i++;
        }
        return min.substring(0, i);
    }
}