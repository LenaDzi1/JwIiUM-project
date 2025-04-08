/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

/**
 * The Cosine class extends the abstract Functions class to implement
 * the calculation of the cosine of an angle (in degrees). It performs
 * the cosine operation on the `x` value, while the `y` value is unused.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public class Cosine extends Functions {
      
    /**
     * Constructs a Cosine object with two values, `x` and `y`.
     * The `x` value represents the angle (in degrees) for which the cosine will be calculated.
     * The `y` value is not used in this specific operation.
     *
     * @param x the angle in degrees for the cosine operation.
     * @param y unused value (but necessary for consistency with the Functions superclass).
     */
//     public Cosine (double x, double y) {
//     super(x, y);
//    }

    public Cosine(double x) {
        super(x);
    }

     /**
     * Performs the cosine operation on the `x` value, converting it from degrees to radians.
     *
     * @return the cosine of the angle `x`.
     */
    @Override
    public double operation() {
        double radians = Math.toRadians(x);
        result = Math.cos(radians);
        return result;
       }
    
    /**
     * Returns a string representation of the cosine operation.
     *
     * @return a string in the format "cos(x°) = ".
     */
    @Override
    public String save_operation() {
        operation = "cos(" + x + "° ) = ";
        return operation;
        
        }
}