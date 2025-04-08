/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import polsl.ld308770.errors.OutsideOfDomainException;
import polsl.ld308770.model.*;

class OperationTypeTest {

    /**
     *
     */
    @ParameterizedTest
    @CsvSource({
            "ADDITION, 5, 3, 8",
            "SUBTRACTION, 5, 3, 2",
            "MULTIPLICATION, 5, 3, 15",
            "DIVISION, 6, 2, 3",
            "POWER, 2, 3, 8"
    })
    void testCreateFunction_ValidOperations(String operationType, double value1, double value2, double expectedResult) {
        try {
            OperationType operation = OperationType.valueOf(operationType);
            Functions function = operation.createFunction(value1, value2);
            
            
            assertNotNull(function, "Function should not be null");
            
         
            assertEquals(expectedResult, function.operation(), 0.0001, "Unexpected operation result");
        } catch (OutsideOfDomainException ex) {
            
        }
    }

   

    /**
     * 
     */
    @ParameterizedTest
    @CsvSource({
            "+, ADDITION",
            "-, SUBTRACTION",
            "*, MULTIPLICATION",
            "/, DIVISION",
            "^, POWER"
    })
    void testFromSymbol_ValidSymbols(String symbol, String expectedOperation) {
        OperationType operation = OperationType.fromSymbol(symbol);

        assertEquals(OperationType.valueOf(expectedOperation), operation, "Unexpected OperationType for symbol: " + symbol);
    }

    /**
     * 
     */
    @ParameterizedTest
    @ValueSource(strings = {"invalid", "?", "#"})
    void testFromSymbol_InvalidSymbols(String symbol) {
       
        assertThrows(IllegalArgumentException.class, () -> OperationType.fromSymbol(symbol), "Expected IllegalArgumentException for symbol: " + symbol);
    }

    /**
     * 
     */
    @ParameterizedTest
    @CsvSource({
            "ADDITION, true",
            "SUBTRACTION, true",
            "MULTIPLICATION, true",
            "DIVISION, true",
            "SQUARE_ROOT, false",
            "SINE, false"
    })
    void testRequiresSecondValue(String operationType, boolean expectedRequiresSecondValue) {
        OperationType operation = OperationType.valueOf(operationType);

 
        assertEquals(expectedRequiresSecondValue, operation.requiresSecondValue(), "Unexpected requiresSecondValue for operation: " + operationType);
    }
}
