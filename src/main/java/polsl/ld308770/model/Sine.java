/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

/**
 * The Sine class extends the Functions abstract class 
 * and represents a sine operation.
 * This class computes the sine of an angle given in degrees.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */

public class Sine extends Functions {
        
    /**
     * Constructor for the Sine class.
     * 
     * @param x the angle in degrees for which the sine is calculated
     * 
     */
     public Sine (double x) {
     super(x);
    }

    /**
     * Performs the sine operation.
     * 
     * @return the sine of the angle x (in degrees)
     */
    @Override
    public double operation() {
        double radians = Math.toRadians(x);
        result = Math.sin(radians);
        return result;
       }
    
     /**
     * Saves the operation in a string format.
     * 
     * @return a string representation of the sine operation
     */
    @Override
    public String save_operation() {
        operation = "sin(" + x + "° ) = ";
        return operation;
  }
}