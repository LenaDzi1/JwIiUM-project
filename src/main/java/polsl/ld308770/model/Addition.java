/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;
/**
 * The Addition class extends the abstract Functions class to implement 
 * the addition of two numbers. It performs the addition operation and 
 * returns a string representation of the operation.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public class Addition extends Functions{

    /**
     * Constructs an Addition object with two values, `x` and `y`.
     *
     * @param x the first value for the addition.
     * @param y the second value for the addition.
     */
    public Addition(double x, double y) {
        super(x, y);
    }

    /**
     * Performs the addition operation by adding `x` and `y`.
     *
     * @return the result of the addition.
     */
    @Override
    public double operation() {
        result = x+y;
        return result;
         }
    
    /**
     * Returns a string representation of the addition operation.
     *
     * @return a string in the format "x + y = ".
     */
    @Override
    public String save_operation() {
        operation = x + " + " + y + " = ";
        return operation;
       }
   
}
