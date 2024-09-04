package com.mypractice.DemoCrudOperation.Others;

interface QuestionInterface {
	 default void display() {
	 System.out.println("Interface");
	 }
	}

	class QuestionClass {
	 public void display() {
	 System.out.println("Class");
	 }
	}

	public class CodeSnippetLinkedIn1 extends QuestionClass implements QuestionInterface {
	 public static void main(String[] args) {
	 new CodeSnippetLinkedIn1().display();
	 }
	}