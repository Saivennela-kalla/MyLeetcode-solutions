class Solution {
    public int networkDelayTime(int[][] times, int n, int source) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : times) {
            graph[edge[0]].add(new int[] {edge[1], edge[2]});
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            Comparator.comparingInt(state -> state[0]));
        queue.offer(new int[] {0, source});
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int currentDistance = state[0];
            int node = state[1];
            if (currentDistance != distance[node]) continue;
            for (int[] edge : graph[node]) {
                int next = edge[0];
                int newDistance = currentDistance + edge[1];
                if (newDistance < distance[next]) {
                    distance[next] = newDistance;
                    queue.offer(new int[] {newDistance, next});
                }
            }
        }
        int ans = 0;
        for (int node = 1; node <= n; node++) {
            if (distance[node] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, distance[node]);
        }
        return ans;
    }
}