package java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamCount {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("안자바", 2, 100)); 
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("김자바", 3, 180));
		list.add(new Student("감자바", 3, 95));
		list.add(new Student("소자바", 3, 80));
		
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		long cnt1 = list.stream().count();
		long cnt2 = intList.stream().count();
		System.out.printf("list cnt = %d, intList con = %d%n", cnt1, cnt2);
		
		Optional<Student> optStd =  list.stream().max(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				 
				return o1.getTotalScore() - o2.getTotalScore();
			}
		});
		Optional<Student> optStd2 = list.stream().min((o1,o2) -> o1.getTotalScore() - o2.getTotalScore());
		System.out.println("max Total Score Student " + optStd);
		System.out.println("min Total Score Student " + optStd2);
		System.out.println("==================================================");
		
		
		
	}
}
