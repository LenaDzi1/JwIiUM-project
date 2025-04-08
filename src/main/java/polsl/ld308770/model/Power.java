/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

/**
 * The Power class extends the Functions abstract class 
 * and represents an exponentiation operation.
 * This class computes the value of x raised to the power of y.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */

public class Power extends Functions {
        
    /**
     * Constructor for the Power class.
     * 
     * @param x the base value
     * @param y the exponent value
     */
     public Power (double x, double y) {
     super(x, y);
    }

     /**
     * Performs the exponentiation operation.
     * 
     * @return the result of x raised to the power of y
     */
    @Override
    public double operation() {
        result = Math.pow(x, y);
        return result;
       }
    
    /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the exponentiation operation
     */
    @Override
    public String save_operation() {
        operation = x + "^" + y + " = ";
        return operation;  
        }
}