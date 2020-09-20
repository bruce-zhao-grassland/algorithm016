class Solution {
    public boolean isAnagram(String s, String t) {
		// 1.先判断长度是否相同
		if (s.length() != t.length()) {
            return false;
        }
		// 2.判断是否是同一个
        if (s.equals(t)) {
            return true;
        }
		// 3.放置字母数量的数组
        int[] counts = new int[26];
		// 4. s的字母计数
        for (char c : s.toCharArray()) {
            counts[c-'a']++;
        }
		// 5. t对应字母数量做减法
        for (char c : t.toCharArray()) {
            if(--counts[c-'a'] < 0) {
                return false;
            }
        }
		// 有位置不为0，则为字母异位词
        for (int i = 0 ; i < counts.length; i++) {
            if (0 != counts[i]) {
                return false;
            }
        }
        return true;
    }
}