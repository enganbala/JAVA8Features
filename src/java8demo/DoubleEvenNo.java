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
public class DoubleEvenNo {
    
    public static void main(String[] args) {
        
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        
        int result = 0;
        for(int no : numbers){
            if(no % 2 == 0){
                result += no * 2;
            }
        }
        
        System.out.println("Result : " + result);
        result = 0;
        
        
        
        System.out.println("Result : " + 
                numbers.stream()
                .filter(e -> e%2 == 0)
                .map(e -> e * 2)
                .reduce(0,Integer::sum)
        );
        
            
        System.out.println("Result : " + 
                numbers.stream()
                .filter(e -> e%2 == 0)
                .mapToInt(e -> e * 2)
                .sum()
        );
        
    }
    
    
}
