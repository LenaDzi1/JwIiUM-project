/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package polsl.ld308770.controllers;

import polsl.ld308770.model.OperationType;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.animation.PauseTransition;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import polsl.ld308770.errors.EmptyMemoryException;
import polsl.ld308770.errors.NoArgumentsException;
import polsl.ld308770.errors.OutsideOfDomainException;
import polsl.ld308770.model.Addition;
import polsl.ld308770.model.Cosine;
import polsl.ld308770.model.Division;
import polsl.ld308770.model.Functions;
import polsl.ld308770.model.Logarithm;
import polsl.ld308770.model.Memory;
import polsl.ld308770.model.Multiplication;
import polsl.ld308770.model.NatLog;
import polsl.ld308770.model.OperationResult;
import polsl.ld308770.model.Power;
import polsl.ld308770.model.Sine;
import polsl.ld308770.model.SquareRoot;
import polsl.ld308770.model.Substraction;
import polsl.ld308770.model.Tangent;
import polsl.ld308770.model.Y_root;

/**
 * Controller class for handling calculator operations, memory functions, and UI interactions.
 * Contains methods for calculation, displaying memory, loading last result, and handling errors.
 * 
 * @author Lena Dziurska
 * @version 1.0
 */
public class CalculatorController  {

    
     /**
     * List of operations available for selection in the ChoiceBox.
     */
    ObservableList<String> Operations = FXCollections.observableArrayList("+","-","*","/",
            "root of x", "sin(x°)", "cos(x°)", "tan(x°)", "log(x)y", "ln x", "^", "y-th root(x)");
            
    
    @FXML
    public TextField arg1;
    @FXML
    public TextField arg2;
    @FXML
    public Text result;
    @FXML
    public ChoiceBox<String> operation;
    
    private Memory memo;
    @FXML
    public Label errorLabel;
    @FXML
    public Button Calculate;
    @FXML
    public Button Show_memory;
    @FXML
    public Button Load_last;
    @FXML
    public Button Exit;
    
    public Button show_memo;
    public Button load_last;
    public Button exit;
    
    /**
     * Initializes the calculator controller, setting up default values for the operation choice box
     * and initializing memory storage.
     */
    public void initialize (){
        operation.setValue("+");
        operation.setItems(Operations);
        memo = new Memory();
        
         operation.valueProperty().addListener((observable, oldValue, newValue) -> {
            
            OperationType operationType = OperationType.fromSymbol(newValue);
            if (!operationType.requiresSecondValue()) {
                arg2.setText("");
        }
    });
        
    }
    
    
    
    
    public CalculatorController (){}

    
    /**
     * Performs the selected calculation operation when the calculate button is pressed.
     * The result is stored in memory, and any domain errors or input errors are displayed temporarily.
     *
     * @param event the action event triggered by pressing the calculate button
     */
    @FXML
    public void calculate(ActionEvent event) throws NoArgumentsException {
         try {
            double value1 = Double.parseDouble(arg1.getText());
            double value2 = 0;
            String op = operation.getValue();
            double resultValue = 0;
   
            Functions function = null;
 
            OperationType operationType = OperationType.fromSymbol(op);
             
              // Sprawdzenie, czy operacja wymaga drugiej wartości
            if (operationType.requiresSecondValue()) {
                value2 = Double.parseDouble(arg2.getText());
            } else {arg2.setText("");}
            

            // Tworzenie odpowiedniej funkcji przy pomocy enum
            function = operationType.createFunction(value1, value2);

            // Wykonanie operacji
            
            result.setText(String.valueOf(resultValue));
            
           if (function != null) {
            resultValue = function.operation();
            result.setText(String.valueOf(resultValue)); 
            OperationResult opResult = new OperationResult(function.save_operation(), resultValue);

            memo.addRecord(opResult);
        
        }

    } catch (OutsideOfDomainException e) {
        showTemporaryError(e.getMessage()); // Show error in temporary popup
    
        } catch (NumberFormatException e) {
            showTemporaryError("Error: invalid input. X and Y must be numbers");
        }
    }

    
    /**
     * Displays the memory table in a new window with scrollable contents.
     *
     * @param event the action event triggered by pressing the show memory button
     */
    @FXML
     public void show_memo(ActionEvent event) {
    // Create a new stage for the popup window
    Stage memoStage = new Stage();
    memoStage.setTitle("Memory");

    TableView<Map.Entry<String, Double>> tableView = new TableView<>();
    
   
    TableColumn<Map.Entry<String, Double>, String> operationColumn = new TableColumn<>("Operation");
   
    TableColumn<Map.Entry<String, Double>, Double> resultColumn = new TableColumn<>("Result");

    operationColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey()));
    resultColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getValue()).asObject());

    tableView.getColumns().add(operationColumn);
    tableView.getColumns().add(resultColumn);

    operationColumn.setPrefWidth(200);
    resultColumn.setPrefWidth(100);

        Map<String, Double> memoryData = memo.getData(); 


    ObservableList<Map.Entry<String, Double>> tableRows = FXCollections.observableArrayList();
    
        for (Map.Entry<String, Double> entry : memoryData.entrySet()) {
            tableRows.add(entry);
        }
        
    tableRows = tableRows.stream()
        .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) 
        .collect(Collectors.toCollection(FXCollections::observableArrayList)); 


        tableView.setItems(tableRows);

    ScrollPane scrollPane = new ScrollPane(tableView);
    scrollPane.setFitToWidth(true);

   
    Scene scene = new Scene(scrollPane, 320, 400); 
    memoStage.setScene(scene);
    memoStage.initModality(Modality.APPLICATION_MODAL); 
    memoStage.show();
}

     /**
     * Loads the last result from memory and displays it in the x argument text box.
     * If memory is empty, an error message is displayed.
     *
     * @param event the action event triggered by pressing the load last button
     */
    @FXML
    public void load_last(ActionEvent event) {
    try{ double lastValue = memo.Get_last(); 
    arg1.setText(String.valueOf(lastValue));
    
    }catch (EmptyMemoryException e) {
        showTemporaryError(e.getMessage());}
}
    /**
     * Closes the application when the exit button is pressed.
     *
     * @param event the action event triggered by pressing the exit button
     */
    @FXML
    public void exit(ActionEvent event) {
         System.exit(0);
    }

    /**
     * Displays a temporary error message in the error label for 3 seconds.
     *
     * @param message the error message to display
     */
    private void showTemporaryError(String message) {
    errorLabel.setText(message);
    errorLabel.setVisible(true); 
    
    PauseTransition pause = new PauseTransition(Duration.seconds(3));
    pause.setOnFinished(e -> errorLabel.setVisible(false));
    pause.play();
    }

}   

