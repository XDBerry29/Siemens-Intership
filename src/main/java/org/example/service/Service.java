//Service.java file
package org.example.service;
import org.example.domain.*;
import org.example.repo.StudentFileRepo;
import org.example.repo.SubjectFileRepo;
import java.util.Iterator;
import java.util.Map;

public class Service {
    // Clasa Service se ocupa cu gestiunea operatiilor ce pot fi efectuate asupra studentilor si materiilor
    // Ea comunica direct cu repository-urile studentFileRepo si subjectFileRepo

    StudentFileRepo studentFileRepo;
    SubjectFileRepo subjectFileRepo;

    public Service(StudentFileRepo studentFileRepo, SubjectFileRepo subjectFileRepo) {
        // Constructorul primeste ca parametrii doua repository-uri unde au fost incarcati studentii si materiile
        this.studentFileRepo = studentFileRepo;
        this.subjectFileRepo = subjectFileRepo;
    }

    public Iterator<Student> getStudentIterator() {
        // Metoda returneaza un iterator asupra studentilor din repository
       return studentFileRepo.iterator();
    }

    private boolean isElev(Student elev){
        // Metoda isElev verifica daca un student este de tipul elev
        // Un student este considerat elev daca numarul de credite ale unei materii este 0
        // Consider ca elevi au toate materiile cu numarul de credite 0 deci e deajuns sa verificam una
        Map<String,Integer> grades = elev.getGrades();
        String firstSubject = grades.keySet().toArray()[0].toString();
        Subject subject = subjectFileRepo.findSubject(firstSubject);

        return subject.getNoCredits()==0;
    }

    private double calculateElev(Student elev){
        // Metoda calculateElev calculeaza media notelor unui elev
        Map<String,Integer> grades = elev.getGrades();
        int noOfSubjects = grades.size();
        double mean = 0;
        for (Integer grade : grades.values()){
            mean += grade;
        }
        mean /= noOfSubjects;

        return mean;
    }

    private double calculateStudent(Student student){
        // Metoda calculateStudent calculeaza media ponderata a notelor unui student
        Map<String,Integer> grades = student.getGrades();
        int noOfCredits = 0;
        double mean = 0;
        for (Map.Entry<String, Integer> grade : grades.entrySet()){
            int credits = subjectFileRepo.findSubject(grade.getKey()).getNoCredits();
            noOfCredits +=credits;
            mean+= grade.getValue()*credits;

        }
        mean /= noOfCredits;

        return mean;
    }

    public double CalculateMean(Student student){
        // Metoda CalculateMean returneaza media notelor unei entitatii student fie el elev sau nu
        // Daca entitatea are o singura nota consider ca media = nota respectiva
        return (isElev(student) ? calculateElev(student) : calculateStudent(student));
    }

}
