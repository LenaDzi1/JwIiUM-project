/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.errors.OutsideOfDomainException;

/**
 * The Tangent class extends the Functions abstract class 
 * and represents a tangent operation.
 * This class computes the tangent of an angle x (in degrees).
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public class Tangent extends Functions {
        
    /**
     * Constructor for the Tangent class.
     * 
     * @param x the angle in degrees for which the tangent is to be calculated
     * @param y a placeholder parameter (not used in tangent calculation)
     */
     public Tangent (double x, double y) {
     super(x, y);
    }

     /**
     * Performs the tangent operation.
     * 
     * @return the tangent of the angle x in radians
     * @throws OutsideOfDomainException
     */
    @Override
    public double operation() throws OutsideOfDomainException {
        if (x % 180 == 90) {
            throw new OutsideOfDomainException("x∈R, where x ≠ 90° + k⋅180° for any integer k.");
        }
        double radians = Math.toRadians(x);
        result = Math.tan(radians);
        return result;
         }
    
    /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the tangent operation
     */
    @Override
    public String save_operation() {
        operation = "tan(" + x + "° ) = ";
        return operation;   
     }
}
