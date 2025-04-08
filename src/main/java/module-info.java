module com.mycompany.calculatorgui3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires lombok;
    opens com.mycompany.calculatorgui3 to javafx.fxml;
    
    exports com.mycompany.calculatorgui3;
    exports polsl.ld308770.controllers;
    exports polsl.ld308770.errors;
    exports polsl.ld308770.model;
        
}

