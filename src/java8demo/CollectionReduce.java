/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 *
 * @author engan.bala
 */
public class CollectionReduce {
    
      public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        list.forEach(System.out::print);
        
//        list.stream().reduce(Integer.SIZE, new BinaryOperator<Integer>
//        () {
//
//            @Override
//            public Integer apply(Integer t, Integer u) { 
//                 t =  t+u;
//                System.out.println(" i = " + t + " u = " + u);
//             return t;   
//            }
//        });
//        
        int result = 0;
          for (Integer val : list) {
              if(val % 2 ==0 ){
                  result += val *2;  
              }
          }
        
          System.out.println(" result "+ result);
          
          
          System.out.println(" Stream API : " +list.stream().filter(e -> e % 2 == 0)
                  .map(e -> e * 2)
                  .reduce(0, Integer::sum)
          );
          
          System.out.println(" Stream SUM API : " +list.stream().filter(e -> e % 2 == 0)
                  .mapToInt(e -> e * 2)
                  .sum()
          );
      }
      
      
    
}
