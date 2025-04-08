/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.errors;

/**
 *
 * The OutsideOfDomainError class represents an exception that is thrown
 * when a provided argument falls outside the domain of a mathematical function.
 * This indicates that the function cannot process the input as it lies outside
 * the expected input domain.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public class OutsideOfDomainException extends Exception {
     /**
     * Constructs a new OutsideOfDomainError with a detailed message specifying
     * the range of valid domain values for the function.
     *
     * @param message1 the lower bound of the valid domain.
     * @param message2 the upper bound of the valid domain.
     */
    
    public OutsideOfDomainException(String message1, String message2) {
        super("""
              ArgumentOutsideOfDomainException
              Message: The argument provided is out of the domain of function.
              Expected range: 
              """
                + message1 + " to " + message2); 
    }
    
    /**
     * Constructs a new OutsideOfDomainError with a detailed message specifying
     * the valid domain of the function as a single message.
     *
     * @param message a description of the domain of the function.
     */
    
    public OutsideOfDomainException(String message) {
        super("""
              ArgumentOutsideOfDomainException
              Message: The argument provided is out of the domain of function.
              Domain of function:
              """
                + message ); 
    }
}