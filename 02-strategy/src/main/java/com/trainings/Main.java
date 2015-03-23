package com.trainings;

import com.trainings.basic.ConcreteStrategyAdd;

public class Main {

	public static void main(String[] args) {

		Context ctx = new Context(new ConcreteStrategyAdd());
		int result = ctx.executeStrategy(10, 20);
		System.out.println(result);
	}

}
