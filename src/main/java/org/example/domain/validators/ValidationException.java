//ValidationException.java file
package org.example.domain.validators;


// Clasa ValidationException reprezinta o exceptie personalizata
// care este aruncata atunci cand validarea unei entitati esueaza

public class ValidationException extends Exception {

    // Constructor fara argumente
    // Acesta creeaza o noua exceptie de tip ValidationException cu un mesaj implicit null
    public ValidationException() {
        super();
    }

    // Constructor cu un argument
    // Acesta creeaza o noua exceptie de tip ValidationException cu un anumit mesaj
    public ValidationException(String message) {
        super(message);
    }

}