package java_chobo2.ch14.stream;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {
	public static void main(String[] args) {
//		중간연산
//		extracted(); // skip, limit, filter, distinct

		// sorted
//		extracted02();

		Stream<Student> stdStream = Stream.of(new Student("김자바", 1, 200), new Student("소자바", 1, 200),
				new Student("박자바", 2, 150), new Student("안자바", 2, 100), new Student("이자바", 3, 300),
				new Student("나자바", 3, 290), new Student("김자바", 3, 180));

		//반별로 정렬후 -> 점수높은순
		stdStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder()))
				.forEach(System.out::println);
		
		//반별로 정렬후 -> 이름순
//		stdStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Student::getName))
//		.forEach(System.out::println);
		
		//반별로 정렬후 -> 점수낮은순
//		stdStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Student::getTotalScore))
//		.forEach(System.out::println);
	}

	private static void extracted02() {
		// 기본정렬(대문자 우선 -> 소문자)
		System.err.println("기본정렬");
		Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
		strStream.sorted().forEach(s -> System.out.print(s + " "));

		System.out.println();
		Stream.of("dd", "aaa", "CC", "cc", "b").sorted(Comparator.naturalOrder())
				.forEach(s -> System.out.print(s + " "));

		System.out.println();
		Stream.of("dd", "aaa", "CC", "cc", "b").sorted((s1, s2) -> s1.compareTo(s2))
				.forEach(s -> System.out.print(s + " "));

		System.out.println();
		Stream.of("dd", "aaa", "CC", "cc", "b").sorted(String::compareTo).forEach(s -> System.out.print(s + " "));

		// 역정렬
		System.out.println();
		System.err.println("역정렬");
		Stream.of("dd", "aaa", "CC", "cc", "b").sorted(Comparator.reverseOrder())
				.forEach(s -> System.out.print(s + " "));

		System.out.println();
		Stream.of("dd", "aaa", "CC", "cc", "b").sorted(String.CASE_INSENSITIVE_ORDER)
				.forEach(s -> System.out.print(s + " "));

		System.out.println();
		Stream.of("dd", "aaa", "CC", "cc", "b").sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.forEach(s -> System.out.print(s + " "));
	}

	private static void extracted() {
		System.err.println("1. skip(),limit()");
		IntStream.rangeClosed(1, 10).skip(3).limit(5).forEach(i -> System.out.print(i + " "));
		System.out.println();

		System.err.println("2.filter(),distinct()");
		IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6).distinct().forEach(i -> System.out.print(i + " "));

		System.out.println();
		IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));

		System.out.println();
		IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0).filter(i -> i % 3 == 0)
				.forEach(i -> System.out.print(i + " "));

		IntPredicate test = new IntPredicate() {
			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}
		};
		System.out.println();
		IntPredicate p = t -> t % 2 == 0;
		IntStream.rangeClosed(1, 20).filter(p).forEach(s -> System.out.print(s + " "));
	}
}
