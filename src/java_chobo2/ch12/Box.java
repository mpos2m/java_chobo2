package java_chobo2.ch12;

import java.util.ArrayList;

public class Box<T> {
//	private ArrayList<T> list = new ArrayList<T>();
	private ArrayList<T> list;

	public ArrayList<T> getList() {
		return list;
	}

	public Box() {
		list = new ArrayList<T>();
	}

	public void add(T item) {
		list.add(item);

	}

	public T get(int idx) {
		return list.get(idx);
	}

	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		return String.format("Box [%s]", list);
	}

}
