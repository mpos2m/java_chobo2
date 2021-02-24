package java_chobo2.ch11.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student {
	int ban;
	int no;
	String name;
	int kor;
	int math;
	int eng;

	public Student(int ban, int no, String name, int kor, int math, int eng) {
		this.ban = ban;
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	int getTotal() {
		return kor + math + eng;
	}

	double getAverage() {
		return getTotal() / 3;
	}

	@Override
	public String toString() {
		return String.format("Student [ban=%s, no=%s, name=%s, kor=%s, math=%s, eng=%s, total=%s, Average=%s]", ban, no, name, kor, math,
				eng,getTotal(),getAverage());
	}

}

class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student)o1;
			Student s2 = (Student)o2;
			
			int result = s1.ban - s2.ban;
			
			if(result == 0) {
				return s1.no -s2.no;
			}
			return result;
		}
		return -1;
	}

}

public class Exam11_3 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();

		list.add(new Student(2, 1, "홍길동", 90, 50, 90));
		list.add(new Student(2, 2, "홍길동", 80, 60, 91));
		list.add(new Student(1, 3, "홍길동", 70, 70, 92));
		list.add(new Student(1, 1, "홍길동", 60, 80, 93));
		list.add(new Student(1, 2, "홍길동", 50, 90, 94));

		Collections.sort(list,new BanNoAscending());
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
