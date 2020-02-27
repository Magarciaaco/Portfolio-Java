/**
 * Conditionals
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Conditionals {
    public static void main(String[] args) {
        // Initialize Integer Type Variables
        int VarName_One = 5;
        int VarName_Two = 9;

        // If Else Condition
        System.out.println("If Condition --");
        if (VarName_One > VarName_Two) {
            System.out.println("VarName_One: " + VarName_One + " is bigger than VarName_Two: " + VarName_Two );
        } else {
            // Do Something
            System.out.println("VarName_One: " + VarName_One + " is not bigger than VarName_Two: " + VarName_Two );
        }

        // If -- Else If ...  --> Nested If Else Condition
        VarName_One = VarName_One + VarName_Two*4; // New Values
        VarName_Two = VarName_Two * 4; // New Values
        System.out.println("If Else if Condition --");
        if (VarName_One > VarName_Two) {
            System.out.println("VarName_One: " + VarName_One + " is bigger than VarName_Two: " + VarName_Two );
        } else if (VarName_Two > VarName_One) {
            //Do Something
            System.out.println("VarName_One: " + VarName_One + " is not bigger than VarName_Two: " + VarName_Two );
        }
    }
}