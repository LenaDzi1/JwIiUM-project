/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.errors.OutsideOfDomainException;

/**
 * The Y_root class extends the Functions abstract class 
 * and represents the operation of calculating the y-th root of a number x.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public class Y_root extends Functions{
    
    /**
     * Constructor for the Y_root class.
     * 
     * @param x the number from which to calculate the y-th root
     * @param y the degree of the root
     */
    public Y_root (double x, double y) {
     super(x, y);
    }

    /**
     * Performs the y-th root operation.
     * 
     * @return the result of the y-th root of x
  * @throws OutsideOfDomainException
     */
    @Override
    public double operation() throws OutsideOfDomainException {
        if (y <= 0 || y % 1 != 0) {
            throw new OutsideOfDomainException("Root degree y should be an integer > 0.");
        }
        if (x < 0 && y % 2 == 0) {
            throw new OutsideOfDomainException("For even y (e.g., 2, 4, 6), x >= 0.");
        }
        result = Math.pow(x, 1.0 / y);
        return result;
      }
    
    /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the y-th root operation
     */
    @Override
    public String save_operation() {
        operation = "("+ y + ")√" + x + " = ";
        return operation; 
      }
}
