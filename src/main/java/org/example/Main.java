package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ノード数4の隣接行列
        // ⓪ →　①
        // ↓　↙　↓
        // ② →　③
        int[][] adjacencyMatrix = {
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
        };
        // 行：そのノードから出ているエッジがあるかどうか
        // 列：ノード

        topologicalSort(adjacencyMatrix);
    }

    public static void topologicalSort(int[][] adjacencyMatrix) {

        // ノード数の取得
        int nodes = adjacencyMatrix.length;

        // 各頂点の入次数（入力エッジの数）を計算
        int[] inDegree = GraphUtil.getInDegreeVector(adjacencyMatrix);
        // → [0,1,2,3] : ノード0の入力次数=0, ノード1の入力次数=1, ノード2の入力次数=2, ノード3の入力次数=3

        // 入力次数が0のノードのindex全てをキューに追加
        Queue<Integer> queue = new ArrayDeque<>();
        for (int idx = 0; idx < nodes; idx++) {
            if (inDegree[idx] == 0) {
                queue.add(idx);
            }
        }

        // キューから取り出した数
        int cnt = 0;

        // ソート結果(ノードのindex)を格納するリスト
        List<Integer> sortedList = new ArrayList<>();

        while (!queue.isEmpty()) {
            // キューから取り出した数をソート結果に追加
            int node = queue.poll();
            sortedList.add(node);

            // キューから取り出したノードに隣接するノードの入力次数を1減らす
            for (int idx = 0; idx < nodes; idx++) {
                if (adjacencyMatrix[node][idx] == 1) {
                    inDegree[idx]--;
                    // 入力次数を減らした結果、入力次数が0になったら、そのノードをキューに追加
                    if (inDegree[idx] == 0) {
                        queue.add(idx);
                    }
                }
            }
            cnt++;
        }

        if (cnt != nodes) {
            // キューから取り出した数 がノード数と一致しない場合、サイクルがある
            System.out.println("サイクルがあります");
        } else {
            System.out.println("ソート結果");
            System.out.println(sortedList.stream()
                .map(String::valueOf)
                .reduce((a, b) -> a + " → " + b)
                .get());
        }
    }


}
