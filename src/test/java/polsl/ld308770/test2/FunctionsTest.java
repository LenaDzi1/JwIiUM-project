/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polsl.ld308770.test2;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import polsl.ld308770.errors.OutsideOfDomainException;
import polsl.ld308770.model.*;
import polsl.ld308770.errors.*;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.platform.commons.util.StringUtils;

/**
 *
 * @author SuperStudent-PL
 */
public class FunctionsTest {
    private Functions function;
    

   
  //////////ADDITION /////////////////////////////  
        @ParameterizedTest
        @CsvSource({"1, 1, 2", "-5, -3, -8", "10, -3, 7"})
        void testCorrectAddition(double a, double b, double expected) {
            try{
            function = new Addition (a,b);
         //   double result = function.operation();
            assertEquals(expected, function.operation(), "Invalid operation result.");
            }catch(OutsideOfDomainException ex) {
              fail("An exception shouldn't be thrown");
            }
        }
        
        

        @Test
        void testSaveAdittion() {
            
        try {
            function = new Addition(3, 4);
            function.operation();
            assertEquals("3.0 + 4.0 = ", function.save_operation(), "Incorrect saving result.");
        } catch (OutsideOfDomainException | NoArgumentsException ex) {}
        }
        
           @Test
           void testAdditionWithNull() {
              Double a = null;
              Double b = null;
               
               assertThrows(NullPointerException.class, () -> {
                   function = new Addition(a, b);
                   function.operation();
               }, "NullPointerException expected to be thrown.");
           }

           @Test
           void testSaveAdditionWithNull() {
               Double a = null;
               Double b = null;

               assertThrows(NullPointerException.class, () -> {
                   function = new Addition(a, b);
                   function.operation();
                  // function.save_operation();
               }, "NullPointerException expected to be thrown.");
           }
      
           
  //////////COSINE //////////////////////////////
        @ParameterizedTest
        @CsvSource({"0,1", "180, -1"})
        void testCorrectCosine(double a, double expected) {
            try{
            function = new Cosine (a);
         //   double result = function.operation();
            assertEquals(expected, function.operation(), "Invalid operation result.");
            }catch(OutsideOfDomainException ex) {
              fail("An exception shouldn't be thrown");
            }
        }
        
        

        @Test
        void testSaveCosine() {
            
        try {
            function = new Cosine(180);
            function.operation();
            assertEquals("cos(180.0° ) = ", function.save_operation(), "Incorrect saving result.");
        } catch (OutsideOfDomainException | NoArgumentsException ex) {}
        }
        
           @Test
           void testCosineWithNull() {
              Double a = null;

               assertThrows(NullPointerException.class, () -> {
                   function = new Cosine(a);
                   function.operation();
               }, "NullPointerException expected to be thrown.");
           }

           @Test
           void testSaveCosineWithNull() {
               Double a = null;

               assertThrows(NullPointerException.class, () -> {
                   function = new Cosine(a);
                   function.operation();
                   function.save_operation();
               }, "NullPointerException expected to be thrown.");
           }
 /////////////DIVISION ////////////////////
        @ParameterizedTest
        @CsvSource({"6,3,2", "21,3,7"})
        void testCorrectDivision(double a,double b, double expected) {
            try{
            function = new Division(a,b);
         //   double result = function.operation();
            assertEquals(expected, function.operation(), "Invalid operation result.");
            }catch(OutsideOfDomainException ex) {
              fail("An exception shouldn't be thrown");
            }
        }
        
        @ParameterizedTest
        @CsvSource({"4,0"})
        public void testDivisionByZero(double a,double b) {
        try {
           function = new Division (a,b);
           function.operation();
           fail("An exception should be thrown");
        } catch (OutsideOfDomainException ex) {}
          }

        @Test
        void testSaveDivision() {
            
        try {
            function = new Division (4,2);
            function.operation();
            assertEquals("4.0 / 2.0 = ", function.save_operation(), "Incorrect saving result.");
        } catch (OutsideOfDomainException | NoArgumentsException ex) {}
        }
        
           @Test
           void testDivisionWithNull() {
              Double a = null;
              Double b = null;

               assertThrows(NullPointerException.class, () -> {
                   function = new Division(a,b);
                   function.operation();
               }, "NullPointerException expected to be thrown.");
           }

           @Test
           void testSaveDivisionWithNull() {
               Double a = null;
               Double b = null;

               assertThrows(NullPointerException.class, () -> {
                   function = new Division(a,b);
                   function.operation();
                   function.save_operation();
               }, "NullPointerException expected to be thrown.");
           }
 ///////////// LOGARITHM ////////////////         
        @ParameterizedTest
        @CsvSource({"2,8,3", "3, 27, 3"})
        void testCorrectLogarithm(double a, double b, double expected) {
            try{
            function = new Logarithm (a,b);
         //   double result = function.operation();
            assertEquals(expected, function.operation(), "Invalid operation result.");
            }catch(OutsideOfDomainException ex) {
              fail("An exception shouldn't be thrown");
            }
        }
        
        @ParameterizedTest
        @CsvSource({"0,0"})
        public void testLogarithmWith0(double a, double b) {
            try {
               function = new Logarithm (a,b);
               double result = function.operation();
               fail("An exception should be thrown");
            } catch (OutsideOfDomainException ex) {

            }

        }

        @ParameterizedTest
        @CsvSource({"1,4"})
        public void testLogarithmBase1(double a, double b) {
            try {
               function = new Logarithm (a,b);
               double result = function.operation();
               fail("An exception should be thrown");
            } catch (OutsideOfDomainException ex) {

            }

        }
        

        @Test
        void testSaveLogarithm() {
            
        try {
            function = new Logarithm(3, 4);
            function.operation();
            assertEquals("log(3.0) 4.0 = ", function.save_operation(), "Incorrect saving result.");
        } catch (OutsideOfDomainException | NoArgumentsException ex) {}
        }
        
           @Test
           void testLogarithmWithNull() {
              Double a = null;
              Double b = null;
               
               assertThrows(NullPointerException.class, () -> {
                   function = new Logarithm(a, b);
                   function.operation();
               }, "NullPointerException expected to be thrown.");
           }

           @Test
           void testSaveLogarithmWithNull() {
               Double a = null;
               Double b = null;

               assertThrows(NullPointerException.class, () -> {
                   function = new Logarithm(a, b);
                   function.operation();
                  // function.save_operation();
               }, "NullPointerException expected to be thrown.");
           }      
 //////////////// MULTIPLICATION ///////////////
            @ParameterizedTest
        @CsvSource({"4,2,8", "-5, -3, 15"})
        void testCorrectMultiplication(double a, double b, double expected) {
            try{
            function = new Multiplication (a,b);
         //   double result = function.operation();
            assertEquals(expected, function.operation(), "Invalid operation result.");
            }catch(OutsideOfDomainException ex) {
              fail("An exception shouldn't be thrown");
            }
        }
        
        

        @Test
        void testSaveMultiplication() {
            
        try {
            function = new Multiplication(3, 4);
            function.operation();
            assertEquals("3.0 * 4.0 = ", function.save_operation(), "Incorrect saving result.");
        } catch (OutsideOfDomainException | NoArgumentsException ex) {}
        }
        
           @Test
           void testMultiplicationWithNull() {
              Double a = null;
              Double b = null;
               
               assertThrows(NullPointerException.class, () -> {
                   function = new Multiplication(a, b);
                   function.operation();
               }, "NullPointerException expected to be thrown.");
           }

           @Test
           void testSaveMultiplicationWithNull() {
               Double a = null;
               Double b = null;

               assertThrows(NullPointerException.class, () -> {
                   function = new Multiplication(a, b);
                   function.operation();
                  // function.save_operation();
               }, "NullPointerException expected to be thrown.");
           }
 /////////POWER ///////////////
       @ParameterizedTest
        @CsvSource({"1, 2, 1", "2, 3, 8", "4, 0, 1"})
        void testCorrectPower(double a, double b, double expected) {
            try{
            function = new Power (a,b);
         //   double result = function.operation();
            assertEquals(expected, function.operation(), "Invalid operation result.");
            }catch(OutsideOfDomainException ex) {
              fail("An exception shouldn't be thrown");
            }
        }
        
        

        @Test
        void testSavePower() {
            
        try {
            function = new Power(3, 4);
            function.operation();
            assertEquals("3.0^4.0 = ", function.save_operation(), "Incorrect saving result.");
        } catch (OutsideOfDomainException | NoArgumentsException ex) {}
        }
        
           @Test
           void testPowerWithNull() {
              Double a = null;
              Double b = null;
               
               assertThrows(NullPointerException.class, () -> {
                   function = new Power(a, b);
                   function.operation();
               }, "NullPointerException expected to be thrown.");
           }

           @Test
           void testSavePowerWithNull() {
               Double a = null;
               Double b = null;

               assertThrows(NullPointerException.class, () -> {
                   function = new Power(a, b);
                   function.operation();
                  // function.save_operation();
               }, "NullPointerException expected to be thrown.");
           }
 /////////////// SINE //////////////////////
       @ParameterizedTest
        @CsvSource({"0, 0", "-90, -1"})
        void testCorrectSine(double a, double expected) {
            try{
            function = new Sine (a);
         //   double result = function.operation();
            assertEquals(expected, function.operation(), "Invalid operation result.");
            }catch(OutsideOfDomainException ex) {
              fail("An exception shouldn't be thrown");
            }
        }
        
        

        @Test
        void testSaveSine() {
            
        try {
            function = new Sine(180);
            function.operation();
            assertEquals("sin(180.0° ) = ", function.save_operation(), "Incorrect saving result.");
        } catch (OutsideOfDomainException | NoArgumentsException ex) {}
        }
        
           @Test
           void testSineWithNull() {
              Double a = null;
               
               assertThrows(NullPointerException.class, () -> {
                   function = new Sine(a);
                   function.operation();
               }, "NullPointerException expected to be thrown.");
           }

           @Test
           void testSaveSineWithNull() {
               Double a = null;
               
               assertThrows(NullPointerException.class, () -> {
                   function = new Sine(a);
                   function.operation();
                  // function.save_operation();
               }, "NullPointerException expected to be thrown.");
           }     
 //////////////SUBSTRACTION /////////////////
           
           
}