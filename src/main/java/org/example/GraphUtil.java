package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphUtil {

    /**
     * 隣接行列から隣接リストを取得する.
     */
    public static List<List<Integer>> getAdjacencyList(int[][] adjacencyMatrix) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    list.add(j);
                }
            }
            adjacencyList.add(list);
        }
        return adjacencyList;
    }


    /**
     * 隣接行列から入力次数ベクトルを取得
     *
     * @param adjacencyMatrix 隣接行列
     * @return 入力次数ベクトル
     */
    public static int[] getInDegreeVector(int[][] adjacencyMatrix) {
        int[] degreeVector = new int[adjacencyMatrix.length];
        Arrays.fill(degreeVector, 0); // 0で初期化
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                degreeVector[i] += adjacencyMatrix[j][i]; // i列目の合計を計算
            }
        }
        return degreeVector;
    }


    /**
     * 隣接行列から入力次数行列を取得
     *
     * @param adjacencyMatrix 隣接行列
     * @return 入力次数行列
     */
    public static int[][] getDegreeMatrix(int[][] adjacencyMatrix) {
        int[][] degreeMatrix = new int[adjacencyMatrix.length][adjacencyMatrix.length];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            int degree = 0;
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                degree += adjacencyMatrix[j][i];
            }
            degreeMatrix[i][i] = degree;
        }
        return degreeMatrix;
    }


    /**
     * 隣接リストの表示.
     */
    public static void display(List<List<Integer>> adjacencyList) {
        System.out.println("---隣接リストを表示---");
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println(i + " : " + adjacencyList.get(i));
        }
    }


    /**
     * 行列の表示.
     *
     * @param matrix 行列
     */
    public static void display(int[][] matrix) {
        System.out.println("---行列を表示---");
        System.out.println(Arrays.stream(matrix)
            .map(Arrays::toString)
            .reduce((a, b) -> a + "\n" + b).get());
    }


    /**
     * ベクトルの表示.
     *
     * @param vector ベクトル
     */
    public static void display(int[] vector) {
        System.out.println("---ベクトルを表示---");
        System.out.println(Arrays.toString(vector));
    }
}
