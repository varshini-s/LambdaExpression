package com.bridgelabz.lambdaexpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

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


	}

}
