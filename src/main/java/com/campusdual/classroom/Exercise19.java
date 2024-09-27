package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {
        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));
        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }


    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int rows = intArrayTri[0].length;
        int columns = intArrayTri[0][0].length;
        int[][] flatArray = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int d = 0; d < intArrayTri.length; d++) {
                    flatArray[i][j] += intArrayTri[d][i][j];
                }
            }
        }
        return flatArray;
    }


    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            sb.append(getUnidimensionalString(intArrayBi[i]));
            if (i < intArrayBi.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    // Método para convertir un array unidimensional a String
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            sb.append(uniArray[i]);
            if (i < uniArray.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // Método para crear y poblar un array unidimensional
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] array = new int[columns];
        for (int i = 0; i < columns; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // Método para crear y poblar un array bidimensional
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = i * columns + j + 1;
            }
        }
        return array;
    }

    // Método para crear y poblar un array tridimensional
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] array = new int[depth][rows][columns];
        for (int d = 0; d < depth; d++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    array[d][i][j] = d * rows * columns + i * columns + j + 1;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(3, 3);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(2, 2, 2);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
