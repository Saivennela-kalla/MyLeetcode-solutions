class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> remaining = new HashSet<>(wordList);
        if (!remaining.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        remaining.remove(beginWord);
        int wordsInPath = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                char[] current = queue.poll().toCharArray();
                for (int position = 0; position < current.length; position++) {
                    char original = current[position];
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        if (letter == original) {
                            continue;
                        }
                        current[position] = letter;
                        String next = new String(current);
                        if (next.equals(endWord)) {
                            return wordsInPath + 1;
                        }
                        if (remaining.remove(next)) {
                            queue.offer(next);
                        }
                    }
                    current[position] = original;
                }
            }

            wordsInPath++;
        }

        return 0;
    }
}