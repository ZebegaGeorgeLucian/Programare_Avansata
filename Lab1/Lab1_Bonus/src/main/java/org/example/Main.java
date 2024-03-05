package org.example;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int [][] matrix = new int[20][20];
        createMatrix(n , matrix);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void createMatrix(int n , int [][] matrix) {
        int mainNode = 1;
        int firstEdge = 2;
        int lastEdge = n;
        for(int i = 1; i <=n ; i++){
                for (int j = 1; j <= n; j++)
                { if (i == j)
                        matrix[i][j] = 0;
                    else if (i == mainNode || j == mainNode)
                        matrix[i][j] = 1;
                    else if (i == j + 1 || i == j - 1)
                        matrix[i][j] = 1;
                    else if (i == firstEdge && j == lastEdge || i == lastEdge && j == firstEdge)
                        matrix[i][j] = 1;
                    else matrix[i][j] = 0;
                }
        }

    }
}