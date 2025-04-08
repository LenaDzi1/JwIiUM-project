/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.errors.OutsideOfDomainException;

/**
 * The Logarithm class extends the Functions abstract class 
 * and represents a logarithmic operation. 
 * This class computes the logarithm of a number with a specified base.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
    
public class Logarithm extends Functions {
        
    /**
     * Constructor for the Logarithm class.
     * 
     * @param x the base of the logarithm
     * @param y the value for which the logarithm is calculated
     */
     public Logarithm (double x, double y) {
     super(x, y);
    }

      /**
     * Performs the logarithmic operation.
     * Calculates the logarithm of value y with base x.
     * 
     * @return the result of the logarithmic operation
     * @throws OutsideOfDomainException
     */
    @Override
    public double operation() throws OutsideOfDomainException {
        // Validate inputs
        if (x <= 0 || y <= 0 || x == 1) {
            throw new OutsideOfDomainException(" base x > 0 and not equal to 1, y > 0.");
        }

        // Perform calculation if inputs are valid
        result = Math.log(y) / Math.log(x);
        return result;
    }
    
    /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the logarithmic operation
     */
     @Override
    public String save_operation() {
        operation = "log(" + x + ") "+ y+ " = ";
        return operation;
        
    }
    
}
