import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[][] adj = new int[n][n];
        int[] neighborCount = new int[n];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u][neighborCount[u]++] = v;
            adj[v][neighborCount[v]++] = u;
        }

        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                int[] component = new int[n];
                int componentSize = 0;
                component[componentSize++] = i;

             while (!queue.isEmpty()) {
                int node = queue.poll();
                 for (int j = 0; j < neighborCount[node]; j++) {
                     int neighbor = adj[node][j];
                     if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                        component[componentSize++] = neighbor;
                   }
                }
            }

                boolean isComplete = true;
                for (int j = 0; j < componentSize; j++) {
                    int node = component[j];
                    if (neighborCount[node] != componentSize - 1) {
                        isComplete = false;
                        break;
                    }
                }

                if (isComplete) {
                    count++;
                }
            }
        }

        return count;
    }
}