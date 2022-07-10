package com.pages;

public class child extends parent{
 public  void print()
 {
	 System.out.println("child");
 }
 
 public static void main(String[] args) {
	
	 parent p=new child();
	 p.print();
}
 
}
