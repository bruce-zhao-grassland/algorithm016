class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        final int len = endWord.length();
        Map<String, List<String>> allCombos = new HashMap<>();  
        wordList.forEach(w -> {
            for (int i = 0; i < len; ++i) {
                String common = w.substring(0, i) + "*" + w.substring(i+1);
                List<String> list = allCombos.getOrDefault(common, new ArrayList<>());
                if (list.isEmpty()) {
                    allCombos.put(common, list);
                }
                list.add(w);
            }
        });
        Map<String, Integer> beginVisited = new HashMap<>();
        Map<String, Integer> endVisited = new HashMap<>();
        Queue<Pair<String, Integer>> beginQ = new LinkedList<>();
        Queue<Pair<String, Integer>> endQ = new LinkedList<>();
        beginVisited.put(beginWord, 1);
        endVisited.put(endWord, 1);
        beginQ.add(new Pair<>(beginWord, 1));
        endQ.add(new Pair<>(endWord, 1));
        while (!beginQ.isEmpty() && !endQ.isEmpty()) {
            int ans = visitWordNode(beginQ, beginVisited, endVisited, allCombos, len);
            if (ans > -1) {
                return ans;
            }

            ans = visitWordNode(endQ, endVisited, beginVisited, allCombos, len);
            if (ans > -1) {
                return ans;
            }
        }
        return 0;
    }

    private int visitWordNode(Queue<Pair<String, Integer>> queue, Map<String, Integer> beginVisited, Map<String, Integer> endVisited, Map<String, List<String, Integer>> allCombos, int len) {
        Pair<String, Integer> node = queue.remove();
        String word = node.getKey();
        int level = node.getValue();
        for (int i = 0; i < len; i++) {
            String common = word.substring(0, i) + "*" + word.substring(i+1);
            for (String adjacentWord : allCombos.getOrDefault(common, new ArrayList<>())) {
                if (endVisited.containsKey(adjacentWord)) {
                    return level + endVisited.get(adjacentWord);
                } else if (!beginVisited.containsKey(adjacentWord)) {
                    beginVisited.put(adjacentWord, level + 1);
                    queue.add(new Pair<>(adjacentWord, level + 1));
                }
            }
        }
    
        return -1;
    }
}