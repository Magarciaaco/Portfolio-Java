/**
 * Loops
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Loops {
    public static void main(String[] args) {
        // Initialize an Array to loop/print the values
        int[] MyArray_1D = new int[5];
        // Use for Loops to Save: index value times two, plus one more
        System.out.println("FOR LOOP\n");
        for(int i = 0; i < MyArray_1D.length /* lenght of the Array */; i++ /* i++ --> adds one more to the variable */) {
            MyArray_1D[i] = (i * 2) + 1;
            System.out.println("MyArray_1D[ " + i + " ]" + ": " + MyArray_1D[i]);
        }

        System.out.println("\nWHILE LOOP\n");

        int i = 0;
        do {
            System.out.println("MyArray_1D[ " + i + " ]" + ": " + MyArray_1D[i]);
            i++;
        } while (i < MyArray_1D.length);
    }
}