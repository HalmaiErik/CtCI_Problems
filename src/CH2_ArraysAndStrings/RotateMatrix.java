package CH2_ArraysAndStrings;

// each pixel : 4 bytes => integer

// rotate by layers, as in edges : swap of 4(not the usual 2; using a temp)
// O(n ^ 2)

public class RotateMatrix {
    static boolean rotateImage(int[][] matrix) {
        int n = matrix.length;
        if(n == 0 || matrix[0].length != n)
            return false;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < n - layer - 1; i++) {
                //save current elem
                int temp = matrix[layer][i];
                //right to top
                matrix[layer][i] = matrix[i][n- 1 - layer];
                //bottom to right
                matrix[i][n - 1 - layer] = matrix[n - 1 - layer][n - 1 - i];
                //left to bottom
                matrix[n - 1 - layer][n - 1 - i] = matrix[n - 1 - i][layer];
                //left = temp
                matrix[n - 1 - i][layer] = temp;
                showImage(matrix);
                System.out.println();
            }
        }
        return true;
    }

    static void showImage(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };

        showImage(matrix);
        System.out.println();
        rotateImage(matrix);
        showImage(matrix);

    }
}
