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

    public static boolean deepEqual(int[][] arr1, int[][] arr2) {
        if ((arr1.length != arr2.length)
                || arr1[0].length != arr2[0].length) return false;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
            }
        }

        return true;
    }
}
