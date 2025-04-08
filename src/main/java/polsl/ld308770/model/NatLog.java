/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.errors.OutsideOfDomainException;

/**
 * The NatLog class extends the Functions abstract class 
 * and represents a natural logarithm operation.
 * This class computes the natural logarithm (base e) of a number.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public class NatLog extends Functions {
        
    /**
     * Constructor for the NatLog class.
     * 
     * @param x the value for which the natural logarithm is calculated
     * @param y an unused parameter for consistency with the Functions class
     */
     public NatLog (double x, double y) {
     super(x, y);
    }

     /**
     * Performs the natural logarithm operation.
     * 
     * @return the result of the natural logarithm of x
     * @throws OutsideOfDomainException
     */
    @Override
   public double operation() throws OutsideOfDomainException {
        if (x <= 0) {
            throw new OutsideOfDomainException("x>0");
        }
        result = Math.log(x);
        return result;
        }
    
    /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the natural logarithm operation
     */
    @Override
    public String save_operation() {
        operation = "ln(" + x + ") = ";
        return operation;
        }
}

