/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jobsheet2;

/**
 *
 * @author Galih Candra
 */
public class Rectangle {
    int width;
    int height;
    
    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    int area() {
        return width * height;
    }
    
    int perimeter() {
        return 2 * (width + height);
    }
}
