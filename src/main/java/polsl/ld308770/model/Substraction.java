/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

/**
 * The Substraction class extends the Functions abstract class 
 * and represents a subtraction operation.
 * This class computes the difference between two numbers x and y.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */

public class Substraction extends Functions{
    
    /**
     * Constructor for the Substraction class.
     * 
     * @param x the first number (minuend)
     * @param y the second number (subtrahend)
     */
    public Substraction (double x, double y) {
     super(x, y);
    }

    /**
     * Performs the subtraction operation.
     * 
     * @return the result of subtracting y from x
     */
    @Override
    public double operation() {
        result = x-y;
        return result;
        }
    
    /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the subtraction operation
     */
     @Override
    public String save_operation() {
        operation = x + " - " + y + " = ";
        return operation;
         }
}
