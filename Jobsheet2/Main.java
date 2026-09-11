/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jobsheet2;

/**
 *
 * @author Galih Candra
 */
public class Main {
    public static void main(String[] args) {
        Rectangle original = new Rectangle(6,4);
        
        System.out.println("Area " + original.area());
        
        Rectangle copy = original;
        copy.width = 10;
        
        System.out.println("Via original " + original.area());
        System.out.println("Via copy " + copy.area());
    }
}
