//StudentFileRepo.java file
package org.example.repo;
import org.example.domain.Student;
import org.example.domain.validators.StudentValidator;
import org.example.domain.validators.ValidationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StudentFileRepo extends FileHandlerRepo<Student>{
    // Clasa StudentFileRepo extinde FileHandlerRepo specializandu-se pe gestionarea studentilor
    // Ea se ocupa cu citirea studentilor din fisier si adaugarea acestora in repository

    public StudentFileRepo(String filename) throws ValidationException, IOException {
        // Constructorul primeste ca parametru numele fisierului de unde se vor incarca studentii
        this.repository = new HashSet<>();
        this.validator = new StudentValidator();
        this.filename = filename;
        parseFile(this.filename);
    }

    public Student findStudent(String name){
        // Metoda findStudent cauta un student dupa nume in repository si il returneaza
        // Daca nu exista un student cu numele dat returneaza null
        for(Student s : repository)
            if(Objects.equals(s.getName(), name))
                return s;
        return null;
    }

    public void addStudent(String name, String subject, int grade) throws ValidationException {
        // Metoda addStudent adauga un nou student in repository
        // Daca studentul exista deja se adauga doar nota la materie
        // Daca studentul nu exista se creeaza un nou student se adauga nota si se adauga in repository
        Student student = findStudent(name);
        if(student != null)
        {
            student.addGrade(subject, grade);
            validator.validate(student);
        }
        else {
            student = new Student(name);
            student.addGrade(subject, grade);
            validator.validate(student);
            repository.add(student);
        }
    }

    public void parseFile(String filename) throws IOException, ValidationException {
        // Metoda parseFile citeste studentii din fisier si ii adauga in repository
        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (String line : lines.subList(1, lines.size())) {
            String[] parts = line.split(";");
            addStudent(parts[0], parts[1], Integer.parseInt(parts[2]));
        }
    }
}
