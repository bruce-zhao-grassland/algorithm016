class Solution {
    private static final Integer INF = Integer.MAX_VALUE;
    private Map<String, Integer> wordId;
    private List<String> idWord;
    private ArrayList<Integer>[] edges;

    public Solution() {
        this.wordId = new HashMap<>();
        this.idWord = new ArrayList<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
            wordId.put(word, id++);
            idWord.add(word);
            }
        }
        List<List<String>> res = new ArrayList<>();
        if (!wordId.containsKey(endWord)) {
            return res;
        }
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }
        edges = new ArrayList[id];
        for (int i = 0; i < id; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0, len = id; i < len - 1; ++i) {
            for (int j = i + 1; j < len; j++) {
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        int dest = wordId.get(endWord);
        int[] costs = new int[id];
        Arrays.fill(costs, INF);
        
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tempBegin = new ArrayList<>();
        tempBegin.add(wordId.get(beginWord));
        q.add(tempBegin);
        costs[wordId.get(beginWord)] = 0;
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.remove();
            int last = now.get(now.size() - 1);
            if (last == dest) {
                List<String> list = new ArrayList<>(now.size());
                for (int idx : now) {
                    list.add(idWord.get(idx));
                }
                res.add(list);
            } else {
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    if (costs[last] + 1 <= costs[to]) {
                        costs[to] = costs[last] + 1;
                        ArrayList<Integer> temp = new ArrayList<>(now);
                        temp.add(to);
                        q.offer(temp);
                    }
                }
            }
        }
        return res;
    }

    private boolean transformCheck(String s1, String s2) {
        int dif = 0;
        for (int i = 0, len = s1.length(); i < len && dif < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dif++;
            }
        }
        return 1 == dif;
    }
}