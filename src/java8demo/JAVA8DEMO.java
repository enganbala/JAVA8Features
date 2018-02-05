/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8demo;

/**
 *
 * @author engan.bala
 */
public class JAVA8DEMO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thread t = new Thread(()-> System.out.println("Thread started"));
        
        t.start();
    }
    
}
