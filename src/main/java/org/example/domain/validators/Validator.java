//Validator.java file
package org.example.domain.validators;

// interfata pentru clasele de validare
public interface Validator<T> {
    void validate(T entity) throws ValidationException;
}
