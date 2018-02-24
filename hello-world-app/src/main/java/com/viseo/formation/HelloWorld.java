package com.viseo.formation;

/**
 * Spring bean
 */
public class HelloWorld {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("Spring says hello to you " + name + "!");
	}
}