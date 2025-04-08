/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.errors.OutsideOfDomainException;

/**
 * The SquareRoot class extends the Functions abstract class 
 * and represents a square root operation.
 * This class computes the square root of a given number x.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */


public class SquareRoot extends Functions {
        
    
     /**
     * Constructor for the SquareRoot class.
     * 
     * @param x the number for which the square root is calculated
     * @param y an unused parameter for consistency with the Functions class
     */
     public SquareRoot (double x, double y) {
     super(x, y);
    }

     
     /**
     * Performs the square root operation.
     * 
     * @return the square root of the number x
     * @throws OutsideOfDomainException
     */
    @Override
     public double operation() throws OutsideOfDomainException {
        if (x < 0) {
            throw new OutsideOfDomainException("x>=0");
        }
        result = Math.sqrt(x);
        return result;
        }
    
    /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the square root operation
     */
    @Override
    public String save_operation() {
        operation = "√" + x + " = ";
        return operation;
        
      }
   
}
