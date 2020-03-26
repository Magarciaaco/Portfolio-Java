import java.util.LinkedList;

/**
 * Scope
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

public class Scope {
    public static void main(String[] args) {
        // Out of Scope: ScopeMethod()
        Circle MyCircle = new Circle();
        Circle[] myCircleArray = new Circle[ 5 ];

        // Scope
        System.out.println("Main Scope");

        // GetArea(); -- Main Scope
        System.out.println ("GetArea(): " + MyCircle.GetArea() );

        // This returns the ID || Memory Value of myCircleArray [ 0 ] -- null due to non-initialized variable
        System.out.println(myCircleArray[ 0 ]);

        myCircleArray[ 0 ] = new Circle( 1 );

        // This returns the ID || Memory Value of myCircleArray [ 0 ]
        System.out.println(myCircleArray[ 0 ]);

        // Call ScopeMethod()
        ScopeMethod();
    }    

    public static void ScopeMethod() {
        
        // in Scope: ScopeMethod()
        System.out.println("\nScopeMethod Scope");
        // Scope Circle
        Circle C1 = new Circle();
        System.out.println(C1);
    }
}