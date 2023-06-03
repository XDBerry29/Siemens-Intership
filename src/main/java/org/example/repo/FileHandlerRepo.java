//FileHandlerRepo.java file
package org.example.repo;
import org.example.domain.validators.ValidationException;
import org.example.domain.validators.Validator;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

abstract class FileHandlerRepo<obj> {
    // Clasa abstracta FileHandlerRepo gestioneaza o colectie de obiecte
    // Ea implementeaza operatii de baza asupra colectiei si defineste metode abstracte pentru operatii specifice

    protected HashSet<obj> repository; // HashSet-ul 'repository' stocheaza obiectele gestionate de repository

    protected Validator<obj> validator;// Validatorul este folosit pentru validarea obiectelor inainte de a fi adaugate in repository

    protected String filename;// Numele fisierului de unde se incarca obiectele

    // Getter pentru repository
    public HashSet<obj> getRepository() {
        return repository;
    }

    public Iterator<obj> iterator() {
        // Returneaza un iterator pentru obiectele din repository
        // Asta permite parcurgerea obiectelor din repository in alte clase
        return repository.iterator();
    }

    // Metoda abstracta care se va suprascrie in clasele concrete
    // Aceasta metoda se ocupa cu incarcarea obiectelor din fisier
    abstract void parseFile(String filename) throws IOException, ValidationException;
}