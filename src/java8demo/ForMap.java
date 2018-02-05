/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import sun.applet.Main;

/**
 *
 * @author engan.bala
 */
public class ForMap {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        list.forEach(System.out::print);
        System.out.println("Using Stram API + FUNCITON Interface");
        list.stream().map(new Function<Integer, String>(){

            @Override
            public String apply(Integer t) {
                return String.valueOf(t) + ", ";
            }
        
        }).forEach(System.out::print);
        
        System.out.println("");
        System.out.println("Using Stram API");
        list.stream().map((Integer t) ->String.valueOf(t) + ", ").forEach(System.out::print);
        
        System.out.println("");
        System.out.println("Using Stram API + Remove Noise");
        list.stream().map(t ->String.valueOf(t) + ", ").forEach(System.out::print);
        
        System.out.println("");
        System.out.println("Using Stram API + Again Remove Noise");
        list.stream().map(t ->String.valueOf(t)).forEach(System.out::print);
       
        System.out.println("");
        System.out.println("Using Stram API + Again Remove Noise, but string manipulation is not possible");
       
        list.stream().map(String::valueOf).forEach(System.out::print);
        
    }
}
