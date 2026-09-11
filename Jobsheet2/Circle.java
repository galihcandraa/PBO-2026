/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jobsheet2;

/**
 *
 * @author Galih Candra
 */
public class Circle {
    private double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    public double area() {
        return Math.PI * radius * radius;
    }
    
    public double circumference() {
        return 2 * Math.PI * radius;
    }
}
