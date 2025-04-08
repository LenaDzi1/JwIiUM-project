/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.errors.OutsideOfDomainException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import polsl.ld308770.errors.NoArgumentsException;


/**
 * The abstract class `Functions` serves as a base class for different mathematical operations.
 * It defines the common behavior and properties that all specific function implementations
 * must have, including the ability to perform an operation and represent it as a string.
 * 
 * Each operation is represented by two operands (`x` and `y`), with the result stored in `result`.
 * The `operation` field contains a string representation of the operation performed.
 * 
 * Classes extending `Functions` must implement the {@link #operation()} and {@link #save_operation()} methods.
 * 
 * This class uses Lombok annotations for automatic generation of getters, setters, `toString`,
 * `equals`, and `hashCode` methods.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
@Getter @Setter @ToString @EqualsAndHashCode
public abstract class Functions {

    /**
     * The first operand of the operation.
     */
    protected double x;

    /**
     * The second operand of the operation.
     * May be unused for operations that require only a single value.
     */
    protected double y = 0;

    /**
     * The result of the operation after it is performed.
     */
    protected double result;

    /**
     * A string representation of the operation performed.
     */
    protected String operation;

    /**
     * Constructs a `Functions` object and initializes the operands `x` and `y`.
     * 
     * @param x the first operand of the operation.
     * @param y the second operand of the operation.
     */
    public Functions(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Constructs a `Functions` object and initializes the operand `x`.
     * Param y deafult is 0.
     * 
     * @param x the first operand of the operation.
     */
    public Functions (double x){
        this.x = x;
        this.y = 0;
    }

    /**
     * Performs the specific mathematical operation defined by a subclass and returns the result.
     * 
     * @return the result of the operation as a double.
     * @throws OutsideOfDomainException if the operation cannot be performed due to invalid input or domain restrictions.
     */
    public abstract double operation() throws OutsideOfDomainException;

    /**
     * Returns a string representation of the operation performed, including operands and the operator.
     * 
     * Example: `"5 + 3"` for addition, or `"sqrt(9)"` for a square root.
     * 
     * @return a string describing the operation performed.
     * @throws polsl.ld308770.errors.NoArgumentsException
     */
    public abstract String save_operation() throws NoArgumentsException;
}