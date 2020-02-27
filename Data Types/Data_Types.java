/**
 * Data_Types
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

 public class Data_Types {
     public static void main(String[] args) {

        final Object[] O = new Object[9];
        
        O[0] = 'A'; // Character
        O[1] = "I am a String"; // String
        O[2] = 123456789; // Integer
        O[3] = 12345.6789; // Double
        O[4] = Short.valueOf((short) 123); // Short
        O[5] = Float.valueOf("12345.12345"); // Float
        O[6] = 12345678987654321L; // Long
        O[7] = true; // Boolean
        O[8] = Byte.valueOf((byte) 100);

        for (int i = 0; i <= 8; i++) {
            if ( i == 6 || i == 8 )
                System.out.println("Data Type:\t" + O[i].getClass().getTypeName() + " \t\t " + O[i]);
            else
                System.out.println("Data Type:\t" + O[i].getClass().getTypeName() + " \t " + O[i]);
        }
     }
 }