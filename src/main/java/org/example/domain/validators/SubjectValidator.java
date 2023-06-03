//SubjectValidator.java file
package org.example.domain.validators;
import org.example.domain.Subject;

public class SubjectValidator implements Validator<Subject> {
   // Clasa SubjectValidator implementeaza interfata Validator
   //fiind folosita pentru validarea obiectelor de tip Subject

    private boolean validateName(String name){
        // Metoda valida numele unui obiect Subject
        // Returneaza true daca numele nu este null sau gol dupa eliminarea spatiilor
        return name != null && !name.trim().isEmpty();
    }

    private boolean validateNoCredits(Integer noCredits){
        // Metoda valida numarul de credite al unui obiect Subject
        // Returneaza true daca numarul de credite nu este null si este mai mare sau egal cu 0
        return noCredits != null && noCredits >= 0;
    }

    @Override
    public void validate(Subject entity) throws ValidationException {
        // Metoda suprascrie metoda validate din interfata Validator
        // Aceasta valideaza un obiect Subject aruncand o exceptie daca acesta este null
        // daca numele este invalid sau daca numarul de credite este invalid
        if (entity == null) {
            throw new ValidationException("Subject cannot be null");
        }

        if (!validateName(entity.getName())) {
            throw new ValidationException("Invalid subject name");
        }

        if (!validateNoCredits(entity.getNoCredits())) {
            throw new ValidationException("Invalid number of credits: " + entity.getNoCredits());
        }
    }
}