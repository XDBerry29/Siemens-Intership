//SubjectFileRepo.java file
package org.example.repo;
import org.example.domain.Subject;
import org.example.domain.validators.StudentValidator;
import org.example.domain.validators.SubjectValidator;
import org.example.domain.validators.ValidationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SubjectFileRepo extends FileHandlerRepo<Subject> {
    // Clasa SubjectFileRepo extinde FileHandlerRepo specializandu-se pe gestionarea materiilor
    // Ea se ocupa cu citirea materiilor din fisier si adaugarea acestora in repository


    public SubjectFileRepo(String filename) throws ValidationException, IOException {
        // Constructorul primeste ca parametru numele fisierului de unde se vor incarca materiile
        this.repository = new HashSet<>();
        this.validator = new SubjectValidator();
        this.filename = filename;
        parseFile(this.filename);
    }

    public void addSubject(String name, int noCredits) throws ValidationException {
        // Metoda addSubject adauga o noua materie in repository
        // Inainte de adaugare, materie este validata
        Subject subject = new Subject(name, noCredits);
        validator.validate(subject);
        repository.add(subject);
    }

    public Subject findSubject(String name){
        // Metoda findSubject cauta o materie dupa nume in repository si o returneaza
        // Daca nu exista o materie cu numele dat, arunca o exceptie de tip NullPointerException
        for(Subject s : repository)
            if(Objects.equals(s.getName(), name))
                return s;
        throw new NullPointerException("Subject '"+ name +"' not found");
    }

    public void parseFile(String filename) throws IOException, ValidationException {
        // Metoda parseFile citeste materiile din fisier si le adauga in repository
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines.subList(1, lines.size())) {
            String[] parts = line.split(";");
            addSubject(parts[0], Integer.parseInt(parts[1]));

        }
    }
}
