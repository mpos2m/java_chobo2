package java_chobo2.ch11;

import java.util.ArrayList;
import java.util.Comparator;


class Department{
	int deptNo;
	String deptName;
	int floor;

	public Department(int deptNo, String deptName, int floor) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.floor = floor;
	}

	public Department(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNo;
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
		Department other = (Department) obj;
		if (deptNo != other.deptNo)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Department [%s, %s, %s]", deptNo, deptName, floor);
	}
	
}


public class ArrayListEx {

	public static void main(String[] args) {
		
//		extractedMethod01();
		
		ArrayList<Department> deptList = new ArrayList<Department>();
		deptList.add(new Department (1,"기획",20));
		deptList.add(new Department (2,"개발",10));
		deptList.add(new Department (3,"인사",30));
		
		prnList(deptList);
		
		int idx = deptList.indexOf(new Department(2));
		System.out.println("idx : " + idx);
		
		boolean isContain = deptList.contains(new Department(2));
		System.out.println(isContain);
		
//		deptList.remove(new Department(2));
//		prnList(deptList);
		
		Department upDept = new Department(2, "마케팅", 11); 
		deptList.set(deptList.indexOf(upDept), upDept);
		prnList(deptList);
		
	}

	private static void prnList(ArrayList<Department> deptList) {
		for(Department d : deptList) {
			System.out.println(d);
		}
		System.out.println();
	}

	private static void extractedMethod01() {
		ArrayList<Integer> arList = new ArrayList<>();
		System.out.println(arList);
		
		//추가
		arList.add(10); //autoboxing
		arList.add(20);
		System.out.println(arList);
		System.out.println(arList.size());
		
		System.out.println("=============================");
		arList.add(1, 40);
		System.out.println(arList);
		System.out.println(arList.size());
		
		System.out.println("40 indexOf : " + arList.indexOf(40));
		
		//삭제
		System.out.println("=============================");
		arList.remove(1);
		System.out.println(arList);
		System.out.println(arList.size());
		
		arList.add(50);
		arList.add(60);
		System.out.println(arList);
		
		arList.remove(new Integer(50));
		System.out.println(arList);
		System.out.println("=============================");
		for(int a : arList) {
			System.out.println(a);
		}
		System.out.println("============================");
		for(int i=0;i<arList.size(); i++) {
			System.out.println(arList.get(i));
		}
		
		arList.set(1, 40);
		System.out.println(arList);
		
		if(arList.contains(30)) {
			System.out.println("30 있음");
		}else {
			System.out.println("30 없음");
		}
		
		System.out.println(arList.contains(60));
		
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("cc");
		strList.add("bb");
		strList.add("aa");
		System.out.println(strList);
		//정렬
		strList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.hashCode()-o2.hashCode();  // 'a', 'b' ->97-98
			}
		});
		System.out.println(strList);
	}
}
