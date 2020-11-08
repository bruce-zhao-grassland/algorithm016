public class Merge {
    public int[][] merge(int[][] intervals) {
        if (0 == intervals.length) return new int[0][2];
        Arrays.sort(intervals, (a1, a2) -> {
            return a1[0] - a2[0];
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0, n = intervals.length; i < n; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            int[] last = list.size() > 0 ? list.get(list.size()-1) : null;
            if (null == last || last[1] < L) {
                list.add(intervals[i]);
            } else {
                last[1] = Math.max(R, last[1]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }   
}