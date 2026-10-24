class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {
        Map<String, Integer> ids = new HashMap<>();

        for (List<String> equation : equations) {
            if (!ids.containsKey(equation.get(0))) {
                ids.put(equation.get(0), ids.size());
            }
            if (!ids.containsKey(equation.get(1))) {
                ids.put(equation.get(1), ids.size());
            }
        }

        int n = ids.size();
        double[][] graph = new double[n][n];

        for (int i = 0; i < equations.size(); i++) {
            int a = ids.get(equations.get(i).get(0));
            int b = ids.get(equations.get(i).get(1));
            graph[a][b] = values[i];
            graph[b][a] = 1.0 / values[i];
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            Integer start = ids.get(queries.get(i).get(0));
            Integer end = ids.get(queries.get(i).get(1));

            if (start == null || end == null) {
                answer[i] = -1.0;
            } else {
                answer[i] = search(
                        start, end, 1.0, graph, new boolean[n]
                );
            }
        }

        return answer;
    }

    private double search(
            int current, int target, double product,
            double[][] graph, boolean[] visited) {
        if (current == target) {
            return product;
        }

        visited[current] = true;

        for (int next = 0; next < graph.length; next++) {
            if (graph[current][next] != 0.0 && !visited[next]) {
                double result = search(
                        next, target, product * graph[current][next], graph, visited
                );

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}