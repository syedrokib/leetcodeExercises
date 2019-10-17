package problems.undefined.criticalconnections;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class Solution {

    @Test
    public void name() {
        int[][] a = new int[][]{{3, 4}, {3, 6}, {4, 5}};
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
        List<List<Integer>> collection = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int[] i : edges) collection.add(Arrays.asList(i[0], i[1]));
        for (int[] i : a) res.add(Arrays.asList(i[0], i[1]));


//        for (int[] i : edges) {
//            System.out.print(Arrays.toString(i));
//
//        }
//        System.out.println();

        assertEquals(res, criticalConnections(9, collection));

        int[][] arrr = new int[][] {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}};
        collection = new ArrayList<>();
        for (int[] i : arrr) collection.add(Arrays.asList(i[0], i[1]));

        assertEquals(0, criticalConnections(6, collection).size());
//        n = 9, edges = [[1, 2], [1, 3], [2, 3], [3, 4], [3, 6], [4, 5], [6, 7], [6, 9], [7, 8], [8, 9]]



    }

    Map<Integer, ArrayList<Integer>> nodeTracker = new HashMap<>();


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        ArrayList<Integer>[] graph = new ArrayList[n];


        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();


        for (List<Integer> connection : connections) {
            int from = connection.get(0) - 1;
            int to = connection.get(1) - 1;
            graph[from].add(to);
            graph[to].add(from);

            ArrayList<Integer> currentList =
                    (nodeTracker.containsKey(from)) ? nodeTracker.get(from) : new ArrayList<>();
            currentList.add(to);
            nodeTracker.put(from, currentList);
        }

//        System.out.println(nodeTracker);

        boolean[] visited = new boolean[n];
        int[] low = new int[n];
        int[] discovery = new int[n];
        List<List<Integer>> results = new ArrayList<>();

        dfs(graph, visited, 0, low, discovery, 0, -1, results);

        return results.stream().
                sorted(Comparator.comparing(a -> a.get(0))).collect(Collectors.toList());


//        return Collections.sort(results, new SortByName());

    }

    private void dfs(ArrayList<Integer>[] graph, boolean[] visited, int node,
                     int[] low, int[] discovery, int timer, int parent, List<List<Integer>> results) {

        low[node] = ++timer;
        discovery[node] = low[node];
        visited[node] = true;

        ArrayList<Integer> neighbours = graph[node];

        for (int neighbour : neighbours) {

            if (neighbour == parent) continue;

            if (!visited[neighbour]) dfs(graph, visited, neighbour, low, discovery, timer, node, results);

            low[node] = Math.min(low[node], low[neighbour]);

            //critical connection / bridge
            if (low[neighbour] > discovery[node]) {

                if (nodeTracker.containsKey(node) && nodeTracker.get(node).contains(neighbour)) {
                    results.add(Arrays.asList(node + 1, neighbour + 1));
                } else {
                    results.add(Arrays.asList(neighbour + 1, node + 1));
                }

            }
        }

    }

}
