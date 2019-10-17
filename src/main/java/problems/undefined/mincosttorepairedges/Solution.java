package problems.undefined.mincosttorepairedges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {

    public int minCostToRepairEdges(int n, int[][] edges, int[][] edgesToRepair) {

        if ((edges == null || edges.length == 0) && (edgesToRepair == null || edgesToRepair.length == 0)) return -1;

        ArrayList<Integer>[] brokenEdges = new ArrayList[n];
        for (int i = 0; i < n; i++) brokenEdges[i] = new ArrayList<>();

        for (int[] edge : edgesToRepair) {
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            brokenEdges[a].add(b);
            brokenEdges[b].add(a);
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // apply union find on disjoint sets
        for (int i = 0; i < edges.length; i++) {

            int a = edges[i][0] - 1;
            int b = edges[i][1] - 1;

            if (!brokenEdges[a].contains(b)) {

                int parentOfA = findParent(a, parent);
                int parentOfB = findParent(b, parent);
                if (parentOfA != parentOfB) union(a, b, parent);
            }
        }

        Arrays.sort(edgesToRepair, Comparator.comparingInt(x -> x[2]));

        int cost = 0;
        for (int i = 0; i < edgesToRepair.length; i++) {

            int a = edgesToRepair[i][0] - 1;
            int b = edgesToRepair[i][1] - 1;
            int parentOfA = findParent(a, parent);
            int parentOfB = findParent(b, parent);

            if (parentOfA != parentOfB) {
                union(a, b, parent);
                cost += edgesToRepair[i][2];
            }
        }

        int setRoot = findParent(0, parent);

        for (int i = 0; i < n; i++) {
            if (findParent(i, parent) != setRoot) return -1;
        }

        return cost;
    }

    private void union(int a, int b, int[] parent) {
        //get parent of b, set it to parent of a
        int parentOfA = findParent(a, parent);
        int parentOfB = findParent(b, parent);

        parent[parentOfB] = parentOfA;
    }

    private int findParent(int id, int[] parent) {

        if (id != parent[id]) {
            parent[id] = findParent(parent[id], parent);
        }
        return parent[id];
    }
}
