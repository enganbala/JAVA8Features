import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {
	public static void main(String[] args) {

		 List<Person> people = Arrays.asList(
		     new Person("bala@test.com", "bala", 27),
		     new Person("raju@test.com", "raju", 30),
		     new Person("ram@test.com", "ram", 20),
                     new Person("test1@test.com","kumar", 30),
	             new Person("test2@test.com","bala", 200),
                     new Person("test3@test.com","ram", 40),
                     new Person("test4@test.com","bala", 50),
                     new Person("test5@test.com","bala", 60),
                     new Person("test6@test.com","bala", 70),
                     new Person("test7@test.com","bala", 80),
                     new Person("test8@test.com","bala", 90),
                     new Person("test9@test.com","bala", 43),
                     new Person("test10@test.com","bala", 46) 
		 );
				
		 Map<String, Person> mapEmailPerson = 
		          people.stream()
		                .collect(Collectors.toMap(Person::getEmail, Function.identity()));
				
		 System.out.println(mapEmailPerson);
		 
		 Map<String, Person> result1 = 
		          people.stream()
		                .collect(Collectors.toMap(x -> x.getName(), x -> x));
		 
		 List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd", "a");
		 
		 Set<String> result3 = givenList.stream().collect(Collectors.toCollection(TreeSet::new));
		 
		 System.out.println(result3);
		 
		 
		 Set<String> result4 = givenList.stream().collect(Collectors.toCollection(HashSet::new));
		 
		 System.out.println(result4);
		 
		 
		 Set<String> result5 = givenList.stream().collect(Collectors.toSet());
		 
		 System.out.println(result5);
		
		        Person result6 = persons.stream()                        // Convert to steam
                	.filter(x -> "bala".equals(x.getName()))        // we want "bala" only
                	.findAny()                                      // If 'findAny' then return found
                	.orElse(null);                                  // If not found, return null

        	System.out.println(result6);
		
	//peek - consume a stream without ending the pipeline of operations 
		Long count = persons.stream().parallel()
		.peek(t ->System.out.println("before filter "+ t))
		.filter(x -> "bala".equals(x.getName())) 
		.peek(t ->System.out.println("after name  filter "+ t))        
		.filter(x -> x.getAge() >50)
		.peek(t ->System.out.println("after age filter "+ t))  
		.limit(10)
		.count();
        
       		 System.out.println(count);
	}
}
