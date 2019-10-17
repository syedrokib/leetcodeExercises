package problems.undefined.mincosttoconnectallnodes;

import java.util.*;

public class Solution {


    public int minCostToConnectAllNodes(int n, int[][] edges, int[][] newEdges) {

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {

            int a = edge[0] - 1;
            int b = edge[1] - 1;
            int parentOfA = findParent(a, parent);
            int parentOfB = findParent(b, parent);

            if (parentOfA != parentOfB) union(a, b, parent);
        }

        Arrays.sort(newEdges, Comparator.comparing(x -> x[2]));

        int cost = 0;
        for (int[] newEdge : newEdges) {

            int a = newEdge[0] - 1;
            int b = newEdge[1] - 1;

            int parentOfA = findParent(a, parent);
            int parentOfB = findParent(b, parent);

            if (parentOfA != parentOfB) {
                union(a, b, parent);
                cost += newEdge[2];
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

//public class Solution {
//
//    int[] parent;
//    int component;
//
//    private int find(int v) {
//        if (parent[v] == v) return v;
//        return parent[v] = find(parent[v]);
//    }
//
//    private void connect(int v1, int v2) {
//        if (find(v1) == find(v2)) return;
//        int root = find(v1);
//        while (v2 != parent[v2]) {
//            int temp = parent[v2];
//            parent[v2] = root;
//            v2 = temp;
//        }
//        --component;
//        parent[v2] = root;
//    }
//
//    private boolean isConnected(int v1, int v2) {
//        return find(v1) == find(v2);
//    }
//
//    public int minCostToConnectAllNodes(int n, int edges[][], int newEdges[][]) {
//        parent = new int[n + 1];
//        component = n;
//        for (int i = 0; i <= n; ++i) parent[i] = i;
//        for (int[] edge : edges) connect(edge[0], edge[1]);
//
////        int[] copy = new int[parent.length];
////        for (int i = 0; i < copy.length; i++) {
////            copy[i] = parent[i] - 1;
////        }
////
////        System.out.println(Arrays.toString(copy));
//
//
//
//        Arrays.sort(newEdges, (a, b) -> (a[2] - b[2]));
//        int cost = 0;
//        for (int i = 0; i < newEdges.length; ++i) {
//            if (!isConnected(newEdges[i][0], newEdges[i][1])) {
//                connect(newEdges[i][0], newEdges[i][1]);
//                cost += newEdges[i][2];
//                if (component == 1) return cost;
//            }
//        }
//        return -1;
//    }
//
//
//}