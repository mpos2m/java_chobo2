package java_chobo2.ch14.stream;

public class Student implements Comparable<Student> {
	private String name;
	private int ban;
	private int totalScore;

	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s", name, ban, totalScore);
	}
	
	@Override
	public int compareTo(Student o) {

		return (this.totalScore - o.totalScore) * -1;
	}

}
