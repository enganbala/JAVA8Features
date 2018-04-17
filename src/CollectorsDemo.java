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
		     new Person("ram@test.com", "ram", 20)
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
		
	}
}
