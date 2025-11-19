package com.lsr.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class metro {

	

public static void main(String[] args) {
		
		Ticket t = () ->{
			// TODO Auto-generated method stub
			return "ticket bought!";
		};
		System.out.println(t.BuyTicket());
		
		Startions s = (s1,s2) ->s1+":"+s2;
		System.out.println(s.pass("station1 ", "station2"));
		
		Function<String, Integer> f = (x) -> Integer.valueOf(x)+10;
		//System.out.println(f.apply("9"));

		List<Integer> num = Arrays.asList(1,3,2,32131,232,12,312312,2);
		
		num.stream().filter(m->m>4)
					.sorted()
					.forEach(System.out::println);
	/*	
		for (Iterator iterator = num.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(integer.compareTo(4)<1) {
				num.remove(integer);
			}
			System.out.println(integer.compareTo(4)>1);
		}
		num.sort(new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		*/
	}

}
