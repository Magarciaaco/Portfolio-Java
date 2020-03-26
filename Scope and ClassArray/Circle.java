
/**
 * Circle
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

public class Circle {
    // Data Field
    double radius = 1.0;

    Circle nextCircle;
    
    // Constructor with no parameter(s)
    Circle() {
        System.out.println("Created a new Circle Object");
    }

    // Constructor with parameter(s)
    Circle(double newR) {
        radius = newR;
    }

    // Method
    double GetArea() {
        return (Math.pow(radius, 2) * 3.14);
    }
}