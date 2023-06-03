//Main.java file
package org.example;
import org.example.domain.validators.ValidationException;
import org.example.repo.StudentFileRepo;
import org.example.repo.SubjectFileRepo;
import org.example.service.Service;
import org.example.ui.UI;

import java.io.IOException;

public class Main {



    public static void main(String[] args) {

        try {
            // Se creaza obiectele repository pentru studenti si subiecte
            // Fisierele cu datele initiale sunt citite
            StudentFileRepo studentFileRepo = new StudentFileRepo("E:\\Facultate\\Internship\\Siemens\\src\\main\\java\\org\\example\\data_files\\elevi_studenti.csv");
            SubjectFileRepo subjectFileRepo = new SubjectFileRepo("E:\\Facultate\\Internship\\Siemens\\src\\main\\java\\org\\example\\data_files\\materii.csv");

            // Se creaza obiectul Service care va folosi repository-urile create
            Service service = new Service(studentFileRepo, subjectFileRepo);

            // Se apeleaza metoda console a obiectului UI pentru a incepe interactiunea cu utilizatorul
            UI ui = new UI(service);
            ui.console();

        } catch (IOException e) {
            // Se afiseaza mesajul de eroare daca apare o exceptie in timpul citirii fisierelor
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (ValidationException e) {
            // Se afiseaza mesajul de eroare daca apare o exceptie in timpul validarii datelor
            System.out.println(e.getMessage());
        }
    }
}