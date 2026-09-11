/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jobsheet2;

/**
 *
 * @author Galih Candra
 */
public class Student {
    private String name;
    private String studentId;
    private double gpa;
    
    Student(String name, String studentId, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.gpa = gpa;
    }
    
    public String describe() {
        return name + " (" + studentId + ", GPA: " + gpa + ")";
    }
}
