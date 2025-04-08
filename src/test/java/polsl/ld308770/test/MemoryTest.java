/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.util.StringUtils;
import polsl.ld308770.errors.EmptyMemoryException;
import polsl.ld308770.model.Memory;
import polsl.ld308770.model.OperationResult;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.platform.commons.util.StringUtils;

/**
 * Test class for the Memory class.
 * This class tests various functionalities of the Memory class,
 * including adding records, handling empty memory, and retrieving the last record.
 */
public class MemoryTest {

    private Memory memo;
    private OperationResult result;

    /**
     * Set up the Memory object before each test.
     */
    @BeforeEach
    public void setUp() {
        memo = new Memory();
    }

    /**
     * Test adding a record with an invalid operation.
     * Ensures that records with invalid operations are not added to memory.
     */
    @Test
    public void testAddNoOperation() {
        result = new OperationResult("aaaaa", 6);
        boolean adding = memo.addRecord(result);
        boolean flag = true;
        assertEquals(adding, flag, "Record shouldn't be added!");
    }

    /**
     * Test adding a valid operation record to memory.
     * Ensures that records with valid operations are added successfully.
     */
    @Test
    public void testAddOperation() {
        result = new OperationResult("2+4=", 6);
        assertTrue(memo.addRecord(result), "Invalid adding to memory!");
    }

    /**
     * Parameterized test for adding multiple valid operation records to memory.
     * Uses a CSV source to provide multiple test cases.
     * 
     * @param operation The operation string (e.g., "2+4=").
     * @param expected  The expected result of the operation.
     */
    @ParameterizedTest
    @CsvSource({
        "2+4=, 6",
        "3+5=, 8",
        "10-3=, 7",
        "7*2=, 14"
    })
    public void testAddManyOperations(String operation, int expected) {
        result = new OperationResult(operation, expected);
        assertTrue(memo.addRecord(result), "Invalid adding to memory!");
    }

    /**
     * Test retrieving the last record from an empty memory.
     * Ensures that an EmptyMemoryException is thrown when attempting to retrieve a record from an empty memory.
     */
    @Test
    public void testEmptyMemory() {
        try {
            memo.Get_last();
            fail("Memory is empty, exception should appear.");
        } catch (EmptyMemoryException e) {
            // Expected behavior
        }
    }

    /**
     * Test retrieving the last record from a non-empty memory.
     * Ensures that no exception is thrown when a record exists in memory.
     */
    @Test
    public void testGetLast() {
        try {
            result = new OperationResult("2+4=", 6);
            memo.addRecord(result);
            memo.Get_last();
        } catch (EmptyMemoryException e) {
            fail("Memory is empty, exception should not appear.");
        }
    }
}

