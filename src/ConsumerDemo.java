
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author engan.bala
 */
public class ConsumerDemo {
    
    public static void main(String[] args) {
        
        List <Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println("For Loop Consumer Interface");
        list.forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
            
        });
        
        list.forEach((Integer t) -> System.out.println(t));
        
        list.forEach((t) -> System.out.println(t));
        
        list.forEach(t -> System.out.println(t));
        
        list.forEach(System.out::println);
        
        
        Stream.of("AAA","BBB","CCC").parallel().forEach(s->System.out.println("Output:"+s));
        Stream.of("AAA","BBB","CCC").parallel().forEachOrdered(s->System.out.println("Output:"+s));
        
}
    
}
