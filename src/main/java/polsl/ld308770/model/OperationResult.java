/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

/**
 * A record that represents the result of a mathematical operation.
 * 
 * @param operation a string representing the performed operation (e.g., "5 + 3").
 * @param result the numerical result of the operation (e.g., 8.0).
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public record OperationResult(String operation, double result) {
}