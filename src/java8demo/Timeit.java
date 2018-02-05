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
public class Timeit {
           
    public static void code(Runnable r){
        long start = System.nanoTime();
        try{
            r.run();
        }catch(Exception e ){
        }finally{
        long end = System.nanoTime();
            System.out.println("Time Taken "+ (end - start)/1.0e9);
        }
    }
    
}
