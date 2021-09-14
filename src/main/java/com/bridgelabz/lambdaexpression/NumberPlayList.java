package com.bridgelabz.lambdaexpression;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class NumberPlayList 
{

	public static void main(String[] args) 
	{

		List<Integer> myNumberList = new ArrayList<Integer>();
		for(int index=0;index<5;index++)
		{
			myNumberList.add(index);
		}

		//Method 1:use of iterator
		Iterator<Integer> iterator = myNumberList.iterator();
		while(iterator.hasNext())
		{
			Integer number=iterator.next();
			System.out.println("Method1: Iterator value: "+number);
		}

		//Method 2:Traversing with consumer interface implementation
		class MyConsumer implements Consumer<Integer>
		{

			@Override
			public void accept(Integer number) 
			{
				System.out.println("Method2: Consumer implemented value: "+number);

			}

		}
		MyConsumer action = new MyConsumer();
		myNumberList.forEach(action);


		//Method 3:anonymous consumer interface implementation
		myNumberList.forEach(new Consumer<Integer>() {
			public void accept(Integer number) 
			{
				System.out.println("Method3: foreach anonymous class value: "+number);

			}
		});

		//Method 4:Explicit lambda function
		Consumer<Integer> myListAction=number->{System.out.println("Method4: foreach lambda implement value: "+number);};
		myNumberList.forEach(myListAction);

		//Method 5:Implicit lambda function
		myNumberList.forEach(number->{System.out.println("Method5: foreach lambda implement value: "+number);});

		
		//Method 6:Implicit lambda function to print double vale
		Function<Integer, Double> toDoubleFunction = Integer::doubleValue; 
		myNumberList.forEach(number->{System.out.println("Method6: foreach lambda double value: "+toDoubleFunction.apply(number));});
		
		//Method 7:Implicit lambda function to check if number even or odd
		Predicate<Integer> isEvenFunction = number->number>0 && number%2==0;
		myNumberList.forEach(number->{System.out.println("Method7: foreach lambda check even : "+isEvenFunction.test(number));});

		//Method 8:processing numbers using stream
		myNumberList.stream().forEach(number->{System.out.println("Method8 :  stream foreach   value: "+number);});
		
		//Method 9:Process the stream,apply operations on stream and store the result
		
		List<Double> streamList = myNumberList.stream()
								.filter(isEvenFunction)
								.peek(number->System.out.println(" peek even number: "+number))
								.map(toDoubleFunction)
								.collect(Collectors.toList());
		System.out.println("Method9: printing double list"+streamList);
		
		//Method 10:even number list
		List<Integer> evenList=myNumberList.stream()
								.filter(isEvenFunction)
								.collect(Collectors.toList());
									 
		System.out.println("method10:printing  even list :"+evenList);
		
		//Method 11:list the first even
		Integer firstElement=myNumberList.stream()
							.filter(isEvenFunction)
							.peek(number->System.out.println(" peek even number: "+number))
							.findFirst()
							.orElse(null);
		System.out.println("method11:First even"+firstElement);
							  
				
		//Method 11:Minimum even numbers
		Integer minimumNumber=myNumberList.stream()
							.filter(isEvenFunction)
							.min((n1,n2)->n1-n2)
							.orElse(null);
		System.out.println("Method11: minimum even"+minimumNumber);

		//Method 12:maximum even number
		Integer maximumNumber=myNumberList.stream()
							.filter(isEvenFunction)
							.max(Comparator.comparing(Integer::intValue))
							.orElse(null);
		System.out.println("Method12: maximum even"+maximumNumber);
		
		//Method 13:average of numbers
		Integer sum=myNumberList.stream().reduce(0, Integer::sum);
		long count=myNumberList.stream().count();
		System.out.println("Method13: average of "+sum+"/"+count+" = "+sum/count);
		
		//Method 14:checking for all even,one even and none are divisible of 6
		boolean allEven = myNumberList.stream().allMatch(isEvenFunction);
		boolean oneEven=myNumberList.stream().anyMatch(isEvenFunction);
		boolean noneMultipleOfSix=myNumberList.stream().noneMatch(number->number>0 && number%6==0);

		System.out.println("All even"+allEven+" one even : "+oneEven+" none multiple of six "+noneMultipleOfSix);
		
		//Method 15:sorting in ascending
		List<Integer> sortedList = myNumberList.stream()
				.sorted((number1,number2)->number1.compareTo(number2))
				.collect(Collectors.toList());

		System.out.println("Method 15:Sorted list "+sortedList);

	}

}