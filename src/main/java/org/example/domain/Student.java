//Student.java file
package org.example.domain;
import java.util.HashMap;
import java.util.Map;

public class Student {

    //Numele studentului/elevului
    private String name;

    //Un Map cu toate notele elevului
    private Map<String,Integer> grades;

    public Student(String name) {
        //Constructor pt a initializa obiectul student doar cu numele
        //Preconditii : 'name' trebuie sa fie non-null si non-empty string
        //Postconditii: se creaza un obiect student cu 'name' si un set gol de 'grades'
        this.name = name;
        this.grades = new HashMap<>();
    }


    //getter pt atributul 'name'
    public String getName() {
        return name;
    }


    //setter pt atributul 'name'
    public void setName(String name) {
        this.name = name;
    }

    //getter pt atributul 'grades'
    public Map<String, Integer> getGrades() {
        return grades;
    }

    //setter pt atributul 'grades'

    public void setGrades(Map<String, Integer> grades) {
        this.grades = grades;
    }


    public void addGrade(String subject, int grade)
    {
        //Functie pt adaugarea unei note in 'grades'
        //Preconditii: 'subject' trebuie sa fie non-null si non-empty string , 'grade' trebuie sa fie non-null si sa fie cuprins intre >0 si <11
        //Postconditii: o nota este adaugata in grades
        this.grades.put(subject, grade);
    }
}
