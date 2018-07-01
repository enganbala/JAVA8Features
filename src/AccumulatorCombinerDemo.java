
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AccumulatorCombinerDemo {
	String name;
	int age;

	AccumulatorCombinerDemo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		
		List<AccumulatorCombinerDemo> persons =
			    Arrays.asList(
			        new AccumulatorCombinerDemo("Ram", 87),
			        new AccumulatorCombinerDemo("Kumar", 23),
			        new AccumulatorCombinerDemo("Santhosh", 45),
			        new AccumulatorCombinerDemo("David", 42));
		
		//supplier, accumulator, combiner, characteristics
		//Collector.of(()-> new StringJoiner('|') )
		
		Integer ageSum = persons
			    .stream()
			    .reduce(0,
			        (sum, p) -> {
			            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			            return sum += p.age;
			        },
			        (sum1, sum2) -> {
			            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			            return sum1 + sum2;
			        });
		System.out.println("Without Parallel Result :"+ ageSum);
		
		Integer ageSumParallel = persons
			    .parallelStream()
			    .reduce(0,
			        (sum, p) -> {
			            System.out.format("parallal accumulator: sum=%s; person=%s\n", sum, p);
			            return sum += p.age;
			        },
			        (sum1, sum2) -> {
			            System.out.format("parallal combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			            return sum1 + sum2;
			        });
		System.out.println("Parallel Result :"+ ageSumParallel);
	}
}
