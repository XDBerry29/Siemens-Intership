//StudentValidator.java file
package org.example.domain.validators;

import org.example.domain.Student;

import java.util.Map;

public class StudentValidator implements Validator<Student> {
    // Clasa StudentValidator implementeaza interfata Validator
    // fiind folosita pentru validarea obiectelor de tip Student

    private boolean validateName(String name){
        // Metoda valida numele unui obiect Student
        // Returneaza true daca numele nu este null sau gol dupa eliminarea spatiilor
        return name != null && !name.trim().isEmpty();
    }

    private boolean validateGrade(Integer grade){
        // Metoda valida numele unui obiect Student
        // Returneaza true daca numele nu este null sau gol dupa eliminarea spatiilor
        return grade != null && grade >= 1 && grade <= 10;
    }

    @Override
    public void validate(Student entity) throws ValidationException {
        // Metoda suprascrie metoda validate din interfata Validator
        // Aceasta valideaza un obiect Student aruncand o exceptie daca acesta este null
        // daca numele este invalid sau daca exista vreo nota sau nume de materie invalid
        if (entity == null) {
            throw new ValidationException("Student cannot be null");
        }

        if (!validateName(entity.getName())) {
            throw new ValidationException("Invalid student name");
        }

        for (Map.Entry<String, Integer> gradeEntry : entity.getGrades().entrySet()) {
            String subject = gradeEntry.getKey();
            Integer grade = gradeEntry.getValue();

            if (!validateName(subject)) {
                throw new ValidationException("Invalid subject name");
            }

            if (!validateGrade(grade)) {
                throw new ValidationException("Invalid grade: " + grade + "for :" + entity.getName());
            }
        }
    }
}
