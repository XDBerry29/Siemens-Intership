//UI.java file
package org.example.ui;

import org.example.domain.Student;
import org.example.service.Service;

import java.util.Iterator;

public class UI {
    // Clasa UI se ocupa cu interactiunea cu utilizatorul prin intermediul consolei
    // Aceasta contine metode pentru a afisa informatii despre studenti

    private Service service;

    public UI(Service service) {
        // Constructorul primeste ca parametru un obiect Service
        this.service = service;
    }

    public void calculateMeans() {
        // Metoda calculateMeans calculeaza si afiseaza media notelor pentru fiecare student din repository
        try {
            Iterator<Student> studentIterator = service.getStudentIterator();
            while (studentIterator.hasNext()) {
                Student student = studentIterator.next();
                double mean = service.CalculateMean(student);
                System.out.println("Mean for " + student.getName() + " is " + mean);
            }
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void console() {
        // Metoda console este punctul de intrare in modulul de UI al aplicatiei
        calculateMeans();
    }
}
