/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8demo;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author engan.bala
 */
public class StreamParallel {
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Timeit.code(()->
        System.out.println("Result : " + 
                list.stream()
                .filter(e -> e%2 == 0)
                .mapToInt(StreamParallel::compute)
                .sum()
        ));
        
         Timeit.code(()->
        System.out.println("Multiple Thread is running, Result : " + 
                list.parallelStream()
                .filter(e -> e%2 == 0)
                .mapToInt(StreamParallel::compute)
                .sum()
        ));
        
    }
    
    public static int compute(int val) {
        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }
        return val * 2;
    }
    
}
