//Subject.java file
package org.example.domain;

public class Subject {
    //Numele Materiei
    private String name;

    //Numarul de credite al Materiei
    private Integer noCredits;


    public Subject(String name, Integer noCredits) {
        //Constructor pt a initializa obiectul Subject cu numele si numarul de credite
        //Preconditii : 'name' trebuie sa fie non-null si non-empty string iar 'noCredits'
        //Postconditii: se creaza un obiect Subject cu 'name' si un set gol de 'grades'
        this.name = name;
        this.noCredits = noCredits;
    }

    //getter pentru 'name'
    public String getName() {
        return name;
    }

    //setter pentru 'name'
    public void setName(String name) {
        this.name = name;
    }

    //getter pentru 'NoCredits'
    public Integer getNoCredits() {
        return noCredits;
    }


    //setter pentru 'NoCredits'
    public void setNoCredits(Integer noCredits) {
        this.noCredits = noCredits;
    }
}
