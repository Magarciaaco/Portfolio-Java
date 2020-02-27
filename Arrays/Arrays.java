/**
 * Arrays
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Arrays {


    // 2D Squared Array Print Helper
    public static void print2Darray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                System.out.println();
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // 1D
        int[] Array_Name_1D = new int[] {1,2,3,4,5,6,7,8,9,0};

        System.out.println("1D ARRAY\n");
        for(int i=0; i < Array_Name_1D.length; i++) {
            System.out.println(Array_Name_1D[i]);
        }

        // 2D (Nested Loop Required)
        System.out.println("\n2D ARRAY(Squared Array) 5 x 5\n");
        int[][] Array_Name_2D = new int[5][5];
        for (int i = 0; i < Array_Name_2D.length; i++) { // Rows
            for (int j = 0; j < Array_Name_2D[0].length; j++) { // Columns
                Array_Name_2D[i][j] = i;
            }
        } print2Darray(Array_Name_2D);

        // 2D (Nested Loop Required)
        System.out.println("\n2D ARRAY(Jagged Array) Row : Colums |         Data ...\n");
        for (int i = 0; i < Array_Name_2D.length; i++) {

            Array_Name_2D[i] = new int[i + 1];
            System.out.print("\n" + i + " : " + Array_Name_2D[i].length + " | \t");

            for (int j = 0; j < Array_Name_2D[i].length; j++) {
                if (j == 0 || j == i) {
                    Array_Name_2D[i][j] = 1;
                    System.out.print(Array_Name_2D[i][j] + "\t");
                } else {
                    Array_Name_2D[i][j] = Array_Name_2D[i - 1][j] + Array_Name_2D[i - 1][j - 1];
                    System.out.print(Array_Name_2D[i][j] + "\t");
                }
            }
        }
    }
}