package com.lsr.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class AverageOfIntegers {

	public static void main(String[] args) {
		
		//Average = (Sum of the integers in the set) / (The number of integers in the set)
		
		// prior java 8 
		int sum= 0;
		int high=0 ;
		List<Integer> marks = Arrays.asList(0,15,22,43,33,77,88,99,66,78,97,76,86,55,77,77,43,15);
		int low=marks.get(0) ;
		List<Integer> even = new ArrayList<>();
		List<Integer> odd  = new ArrayList<>();
		for (int i = 0; i < marks.size(); i++) {
			sum = sum +marks.get(i);
			System.out.println("abs.."+Math.abs(i));
			System.out.println("square.."+Math.multiplyExact(marks.get(i),marks.get(i)));
			if ( marks.get(i).compareTo(high) >0)
				high = marks.get(i);
			if ( marks.get(i).compareTo(low) <0)
				low = marks.get(i);
			if(marks.get(i)%2 == 0 && marks.get(i)!=0)	{
				System.out.println("even num.. "+marks.get(i));
				even.add(marks.get(i));
				odd.add(marks.get(i)+1);
			}else if(marks.get(i)%2 == 1)	{
				System.out.println("odd num.. "+marks.get(i));
				odd.add(marks.get(i));
				even.add(marks.get(i)+1);
			}else {
				odd.add(marks.get(i));
				even.add(marks.get(i));
				System.out.println("NA .. "+marks.get(i));
			}
		}
		System.out.println("Total count.. "+marks.size());
		System.out.println("Sum is.. "+sum);
		System.out.println("Avg is.. "+Double.valueOf(sum/marks.size()));
		System.out.println("high is.. "+high);
		System.out.println("low is.. "+low);
		System.out.println("even List is.. "+even);
		System.out.println("odd List is.. "+odd);

		
		System.out.println("---- In java 8 ----");
		// In java 8
		System.out.println("Avg is.. "+marks.stream().mapToDouble(Integer::doubleValue ).average().orElse(0.0));
		System.out.println("Sum is.. "+marks.stream().mapToInt(Integer::intValue ).sum());
		System.out.println("max is.. "+marks.stream().max(Integer::compare).orElse(null));
		System.out.println("min is.. "+marks.stream().min(Integer::compare).orElse(null));
		System.out.println("even is.. "+marks.stream().filter(t->t%2==0).collect(Collectors.toList()));
		System.out.println("odd is.. "+marks.stream().filter(t->t%2!=0).collect(Collectors.toList()));
		System.out.println("sum of even is.. "+marks.stream().filter(t->t%2==0).mapToInt(Integer::intValue).sum());
		System.out.println("sum of odd is.. "+marks.stream().filter(t->t%2!=0).mapToInt(Integer::intValue).sum());
		System.out.println("second smallest element is.. "+
						marks.stream()
						.distinct()
						.sorted()
						.skip(1)
						.findFirst().get());
		System.out.println("second highest element is.. "+
				marks.stream()
				.distinct()
				.sorted((a, b) -> Integer.compare(b, a))
				.skip(1)
				.findFirst().get());

		System.out.println("after duplicate elements.. "+marks.stream().distinct().toList());
		
		List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
		System.out.println("lower case is.. "+colors.stream().map(String::toLowerCase).collect(Collectors.toList()));
		System.out.println("upper case is.. "+colors.stream().map(String::toUpperCase).collect(Collectors.toList()));
	    char startingLetter = 'R';
		System.out.println("startingLetter with R is.. "+colors.stream()
															.filter(t ->t.startsWith(String.valueOf(startingLetter)) )
															.collect(Collectors.toList()));
		System.out.println("count of startingLetter with R is.. "+
									colors.stream()
									.filter(t ->t.startsWith(String.valueOf(startingLetter)))
									.count());
		System.out.println("list of strings in alphabetical order, ascending .. "+
				colors.stream()
				.sorted()
				.collect(Collectors.toList())
				);
		
		System.out.println("list of strings in alphabetical order, descendingOrder .. "+
				colors.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList())
				);

	}

}
