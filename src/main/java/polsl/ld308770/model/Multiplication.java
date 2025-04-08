/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

/**
 * The Multiplication class extends the Functions abstract class 
 * and represents a multiplication operation.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */

public class Multiplication extends Functions {
    
     /**
     * Constructor for the Multiplication class.
     * 
     * @param x the first value to be multiplied
     * @param y the second value to be multiplied
     */
     public Multiplication (double x, double y) {
     super(x, y);
    }

      /**
     * Performs the multiplication operation.
     * 
     * @return the product of x and y
     */
    @Override
    public double operation() {
         result = x*y;
        return result;
      }
    
    /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the multiplication operation
     */
     @Override
    public String save_operation() {
        operation = x + " * " + y + " = ";
        return operation;
        
        }
    
}
