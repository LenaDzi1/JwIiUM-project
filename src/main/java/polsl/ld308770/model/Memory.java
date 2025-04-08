/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.model;

import polsl.ld308770.errors.EmptyMemoryException;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * The Memory class is designed to store the results of operations performed 
 * by the calculator. It maintains a record of the last few calculations, 
 * allowing users to retrieve previous results.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */



@Getter
@ToString
@EqualsAndHashCode
public class Memory {

   private final Map<String, Double> data;  // Stores operations and their results
    private final int maxRows = 10;          // Maximum number of rows to store in memory

    /**
     * Constructor for the Memory class. Initializes the data storage map.
     * It creates a LinkedHashMap with a maximum size and maintains access order.
     */
    public Memory() {
        this.data = new LinkedHashMap<>(maxRows, 0.75f, true); 
    }

    /**
     * Adds a new record of an operation and its result to memory.
     * If the memory is full, it removes the oldest record to make room 
     * for the new record.
     *
     * @param opResult the operation result to be added to memory.
     * @return true if the record was added successfully, false otherwise.
     */
    public boolean addRecord(OperationResult opResult) {
        if (data.size() >= maxRows) { // Check if memory has reached maximum capacity
            String oldestKey = data.keySet().iterator().next(); // Get the oldest entry
            data.remove(oldestKey); // Remove the oldest entry to make space
        }
        data.put(opResult.operation(), opResult.result()); // Add the new operation result
        return true;
    }

    /**
     * Retrieves the result of the most recent operation stored in memory.
     * 
     * @return the result of the last operation stored in memory.
     * @throws EmptyMemoryException if there are no records in memory.
     */
    public double Get_last() throws EmptyMemoryException {
        if (data.isEmpty()) { // Check if memory is empty
            throw new EmptyMemoryException("The memory is EMPTY, try to make a new equation");
        }
        
        return data.values().stream().skip(data.size() - 1).findFirst().orElseThrow(); // Get the last value in memory
    }

    /**
     * Gets the current count of records stored in memory.
     * 
     * @return the number of records currently stored in memory.
     */
    public int getRecordCount() {
        return data.size(); // Return the count of stored records
    }
}