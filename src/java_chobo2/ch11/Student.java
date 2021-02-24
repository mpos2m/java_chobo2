package java_chobo2.ch11;

public class Student{
	private int stdNo;
	private String name;
	private int kor, eng, math;
	
	//필드를 이용해서 생성자생성 
	// ctrl shift s -> using fields
	
	public Student (int stdNo, String name, int kor, int eng, int math) {
		super();	// super(); 생략가능
		this.stdNo = stdNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	
	public int getStdNo() {
		return stdNo;
	}


	public void setStdNo(int StdNo) {
		this.stdNo = StdNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public Student(int stdNo) {
		this.stdNo = stdNo;
	}
	public int total() {
		int sum = kor+eng+math;
		return sum;
	}
	
	public double avg() {
		return total()/3d;
	}
	@Override
	public String toString() {
		return String.format("%3d %5s %3d %3d %3d %3d %.1f", stdNo, name, kor, eng, math, total(), avg());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eng;
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stdNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (eng != other.eng)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stdNo != other.stdNo)
			return false;
		return true;
	}
	
	
}
