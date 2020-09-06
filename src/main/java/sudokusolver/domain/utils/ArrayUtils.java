package sudokusolver.domain.utils;

public class ArrayUtils {
    public static int[][] copy(int[][] array) {
        int[][] newArr = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                newArr[i][j] = array[i][j];
            }
        }
        return newArr;
    }
}
