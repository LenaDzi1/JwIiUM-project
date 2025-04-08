/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.model.Addition;
import polsl.ld308770.model.Cosine;
import polsl.ld308770.model.Division;
import polsl.ld308770.model.Functions;
import polsl.ld308770.model.Logarithm;
import polsl.ld308770.model.Multiplication;
import polsl.ld308770.model.NatLog;
import polsl.ld308770.model.Power;
import polsl.ld308770.model.Sine;
import polsl.ld308770.model.SquareRoot;
import polsl.ld308770.model.Substraction;
import polsl.ld308770.model.Tangent;
import polsl.ld308770.model.Y_root;

 /**
 * Enum representing different types of mathematical operations.
 * Each operation can create a corresponding function and defines whether a second argument is required.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public enum OperationType {
    /**
     * Addition operation.
     */
    ADDITION("+", true) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Addition(value1, value2);
        }
    },
    /**
     * Subtraction operation.
     */
    SUBTRACTION("-", true) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Substraction(value1, value2);
        }
    },
    /**
     * Multiplication operation.
     */
    MULTIPLICATION("*", true) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Multiplication(value1, value2);
        }
    },
    /**
     * Division operation.
     */
    DIVISION("/", true) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Division(value1, value2);
        }
    },
    /**
     * Square root operation, requiring only one argument.
     */
    SQUARE_ROOT("root of x", false) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new SquareRoot(value1, value2);
        }
    },
    /**
     * Sine operation in degrees, requiring only one argument.
     */
    SINE("sin(x°)", false) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Sine(value1);
        }
    },
    /**
     * Cosine operation in degrees, requiring only one argument.
     */
    COSINE("cos(x°)", false) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Cosine(value1);
        }
    },
    /**
     * Tangent operation in degrees, requiring only one argument.
     */
    TANGENT("tan(x°)", false) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Tangent(value1, value2);
        }
    },
    /**
     * Logarithm operation with a base specified by the second argument.
     */
    LOGARITHM("log(x)y", true) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Logarithm(value1, value2);
        }
    },
    /**
     * Natural logarithm operation, requiring only one argument.
     */
    NATURAL_LOG("ln x", false) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new NatLog(value1, value2);
        }
    },
    /**
     * Power operation where the base is raised to the power of the second argument.
     */
    POWER("^", true) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Power(value1, value2);
        }
    },
    /**
     * Y-th root operation, where the second argument specifies the root degree.
     */
    Y_ROOT("y-th root(x)", true) {
        @Override
        public Functions createFunction(double value1, double value2) {
            return new Y_root(value1, value2);
        }
    };

    /** The symbol representing the operation in the UI or user input. */
    private final String symbol;

    /** Indicates whether the operation requires a second argument. */
    private final boolean requiresSecondValue;

    /**
     * Constructs an OperationType.
     *
     * @param symbol the symbol representing the operation
     * @param requiresSecondValue whether the operation requires a second value
     */
    OperationType(String symbol, boolean requiresSecondValue) {
        this.symbol = symbol;
        this.requiresSecondValue = requiresSecondValue;
    }

    /**
     * Gets the symbol associated with the operation.
     *
     * @return the symbol of the operation
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Checks if the operation requires a second value.
     *
     * @return true if a second value is required, false otherwise
     */
    public boolean requiresSecondValue() {
        return requiresSecondValue;
    }

    /**
     * Creates a specific function instance based on the operation type.
     *
     * @param value1 the first operand
     * @param value2 the second operand (if required)
     * @return an instance of a subclass of Functions representing the operation
     */
    public abstract Functions createFunction(double value1, double value2);

    /**
     * Finds an OperationType by its symbol.
     *
     * @param symbol the symbol to search for
     * @return the matching OperationType
     * @throws IllegalArgumentException if no matching OperationType is found
     */
    public static OperationType fromSymbol(String symbol) {
        for (OperationType type : values()) {
            if (type.getSymbol().equals(symbol)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown operation: " + symbol);
    }
}



