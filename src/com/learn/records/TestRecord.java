package com.learn.records;

import java.io.Serializable;

record MyGame() {}
record MyBook(String isbn, String title) implements Serializable, Comparable<MyBook> {
	
//	MyBook{
//		if(isbn.length() != 13) throw new IllegalArgumentException("Isbn is not 13 characters long");
//	}
	
	
	MyBook(String isbn, String title){
		if(isbn.length() != 13) throw new IllegalArgumentException("Isbn is not 13 characters long");
		this.isbn = isbn + "_test";
		this.title = title;
	}
	
	MyBook(){
		this("test_isbn_123", "test_title");
	}

	@Override
	public int compareTo(MyBook o) {
		
		return 0;
	}
	
	public String testMethod() {
		return "testMethod Returns";
	}
	
	public static String testStaticMethod() {
		return "testStaticMethod Returns";
	}
}

public class TestRecord {

	public static void main(String[] args) {
		
		MyBook book1 = new MyBook("1234567890123", "A tale of mountains");
		MyBook book2 = new MyBook("1234567890123", "A tale of mountains");
		
		System.out.println(book1);
		
		System.out.println("Book1 equals Book2 ? " + book1.equals(book2));
		
		System.out.println(book1.isbn());
		
		System.out.println(book1.title());
		
		System.out.println(new MyBook());
		
		System.out.println(book1.testMethod());
		
		System.out.println(MyBook.testStaticMethod());
	}

}
