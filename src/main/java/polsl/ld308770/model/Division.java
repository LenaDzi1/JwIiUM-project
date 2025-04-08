/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.errors.OutsideOfDomainException;

/**
 * The Division class extends the abstract Functions class to implement
 * the division of two numbers, `x` and `y`. It performs the division operation
 * and returns a string representation of the division.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public class Division extends Functions {
     
    /**
     * Constructs a Division object with two values, `x` and `y`.
     * The `x` value is the numerator, and the `y` value is the denominator.
     *
     * @param x the numerator of the division.
     * @param y the denominator of the division.
     */
     public Division (double x, double y) {
     super(x, y);
    }

     /**
     * Performs the division operation by dividing `x` by `y`.
     *
     * @return the result of the division.
     * @throws OutsideOfDomainException
     */
    @Override
    public double operation() throws OutsideOfDomainException {
        if (y == 0.0) {
            throw new OutsideOfDomainException("x != 0.");
        }
        result = x/y;
        return result;
         }
    
    /**
     * Returns a string representation of the division operation.
     *
     * @return a string in the format "x / y = ".
     */
     @Override
    public String save_operation() {
        operation = x + " / " + y + " = ";
        return operation;
        
       }
   
}
