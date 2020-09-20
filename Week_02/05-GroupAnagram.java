class Solution {
	// 字母异位词分组
	// 字母排好序后，是字母异位词的得到相同的char[]
	// 使用Map，查找时间复杂度为O(1)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch  = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            if (list.isEmpty()) {
                map.put(key, list);
            }
            list.add(str);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}