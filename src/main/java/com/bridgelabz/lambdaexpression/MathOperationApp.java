package com.bridgelabz.lambdaexpression;

public class MathOperationApp 
{
	@FunctionalInterface
	interface MathFunctionIF
	{
		int calculate(int a,int b);
		static void printResult(int a,int b,String function,MathFunctionIF functionObject)
		{
			System.out.println("Result of "+function+" is "+functionObject.calculate(a, b));
		}
		
	}

	public static void main(String[] args) 
	{
		MathFunctionIF add = Integer::sum;
		MathFunctionIF subtract =(x,y)->x-y;
		MathFunctionIF  multiply =(x,y)->x*y;
		MathFunctionIF divide=(int x,int y)->x/y;


		System.out.println("Addition result is: "+add.calculate(2,3));
		System.out.println("Subtraction result is :"+subtract.calculate(3, 1));
		System.out.println("Multiplication result is :"+multiply.calculate(2, 3));
		System.out.println("Division result is :"+divide.calculate(4, 4));
		
		MathFunctionIF.printResult(2, 3, "Addition", add);
		MathFunctionIF.printResult(3, 1, "Subtraction", subtract);
		MathFunctionIF.printResult(2, 3, "Multiplication", multiply);
		MathFunctionIF.printResult(4, 4, "Division", divide);
		
	}

}
