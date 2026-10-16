class Solution {
    private final String[] letters = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        build(digits, 0, new StringBuilder(), result);
        return result;
    }
    private void build(String digits, int index, StringBuilder current,
                       List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String choices = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < choices.length(); i++) {
            current.append(choices.charAt(i));
            build(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}