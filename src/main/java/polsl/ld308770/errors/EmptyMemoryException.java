/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.errors;

/**
 * The EmptyMemoryException class represents an exception that is thrown
 when the memory is empty or uninitialized.
 *
 * @author Lena Dziurska
 * @version 1.0
 */
public class EmptyMemoryException extends Exception {
 
    /**
     * Constructs a new EmptyMemoryError with the specified detail message.
     *
     * @param message the detail message, which is saved for later retrieval.
     */
    public EmptyMemoryException(String message) {
        super(message);
    }
}
