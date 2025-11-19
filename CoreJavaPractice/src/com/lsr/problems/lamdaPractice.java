package com.lsr.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntPredicate;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class lamdaPractice{

	public static void main(String[] args) {
		
		Calculator exp =  (s1,  s2) -> s1+s2;
		int sum = exp.sum(10,20);
		System.out.println(sum);
		
		
        // Lambda expression to check if a given string is empty

		String str = "sddsnj";
        String str1 = ""; // empty string

		Predicate<String> isEmptyCheck = s->s.isEmpty();
		
		System.out.println("str is empty? "+str+" .. "+isEmptyCheck.test(str));
		System.out.println("str1 is empty ? "+str1+""+isEmptyCheck.test(str1));
		
	//	factorial of a given number. -> 
		
		LongUnaryOperator factorial = n -> {
			long result =1;
			for (long i = 1; i <= n; i++) {
				result*=i;
			}
			return result;
		};
		System.out.println("factorial is ? "+factorial.applyAsLong(7));
		
		// prime Number -> Build predicate to find given num is prime or not.
		
		IntPredicate isPrime = n->{
			if (n <1)
				return false;

			for (int i = 2; i < Math.sqrt(n); i++) {

				if (n%i == 0)
					return false;
			}
			return true;
		};
		
		System.out.println("Prime number 15 :  "+isPrime.test(15));
		System.out.println("Prime number 17 :  "+isPrime.test(17));
		
		//sum of all prime numbers in a given range
		
		System.out.println("sum of Prime number rang 10 - 100 :  "+
					IntStream.rangeClosed(10, 100).filter(isPrime).sum());
		
		//largest prime factor of a given number
		
		
		
		BiFunction<String, String, String> concontenate = (s1 , s2)-> s1+ s2;
		
		System.out.println("concontenations example :  "+concontenate.apply("string", "concat"));
		
	    String text = "Java lambda expression.";

	    WordCounter split = t -> t.split("\\s").length;
		System.out.println("countWords example :  "+split.countWords(text));
		
	    // Define the palindrome check lambda expression -> use string builder to reverse and compare with actual string
		
		Predicate<String>  palindrome = s->{
			String reverse = new StringBuilder(s).reverse().toString();
			return s.equals(reverse);
		};
		System.out.println("palindrome example Madam:  "+palindrome.test("Madam"));
		System.out.println("palindrome example radar:  "+palindrome.test("radar"));
		
		//sum of squares of all odd and even numbers in a list.
		// -> Use predicate to find evev or odd , then map to int for square and sum them
		
		Predicate<Integer> odd = t -> t%2!=0;
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		Integer oddsum= list.stream().filter(odd)
									.mapToInt(n->n*n)
									.sum();

		System.out.println("sum of squares of odd number list:  "+oddsum);
		System.out.println("sum of squares of even number list:  "+list.stream().filter(n->n%2==0).mapToInt(n->n*n).sum());

		//list of strings contains a specific word -> map to int to check length of each string then use min and max.
		
		List<String> colors = Arrays.asList("Red","Blue","Green","Orange");
		Predicate<String> match = (o)->o.equals("Red");
		System.out.println("contains a specific word:  "+colors.stream().anyMatch(match));
		System.out.println("length of longest string:  "+colors.stream().mapToInt(String::length).max().getAsInt());
		System.out.println("length of smallest string:  "+colors.stream().mapToInt(String::length).min().getAsInt());
	
		// smallest string -> create comparator condition and then sort using condition and find first.
		
		Comparator<String> compareBig= (a,b) -> a.length() > b.length()?1:-1;
		Comparator<String> compareSmall= (a,b) -> a.length() < b.length()?1:-1;

		System.out.println("smallest string which has smaller length:  "+colors.stream()
																			.sorted(compareBig).findFirst().get());
		System.out.println("largest string which has smaller length:  "+colors.stream()
		.sorted(compareSmall).findFirst().get());
		
		// if a given number is a perfect square.
		Predicate<Integer> isSquare = n->{
			int sqrt = (int) Math.sqrt(n);
			System.out.println(sqrt);
			System.out.println(sqrt * sqrt);
			return sqrt * sqrt ==n;
		};
		System.out.println("36 is a perfect square "+isSquare.test(36));
		System.out.println("26 is a perfect square "+isSquare.test(26));
		
		//sort a list of objects based on a specific attribute.
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("sri","X",10,3));
		studentList.add(new Student("raj","X",20,2));
		studentList.add(new Student("las","X",23,1));
		studentList.add(new Student("srav","X",22,5));
		studentList.add(new Student("anu","X",21,4));
		
		Stream<Student> nameSort = studentList.stream()
				.sorted(Comparator.comparing(Student::getName));
		Stream<Student> idSort = studentList.stream()
				.sorted(Comparator.comparing(Student::getId));
		
		System.out.println("compare using nameSort "+nameSort.collect(Collectors.toList()));
		System.out.println("compare using idSort "+idSort.collect(Collectors.toList()));
		
		//System.out.println("compare using nameSort "+studentList.stream().collect(Collectors.reducing(Student, BinaryOperator<T> new )));

		
		 int n = 176;
		    System.out.println("Number: " + n);

		    long largestPrimeFactor = findLargestPrimeFactor(n);
		    System.out.println("Largest prime factor: " + largestPrimeFactor);
		    n = 36;
		    System.out.println("\nNumber: " + n);

		    largestPrimeFactor = findLargestPrimeFactor(n);
		    System.out.println("Largest prime factor: " + largestPrimeFactor);
		    System.out.println("Binary representation: " + Integer.toBinaryString(33));

	}
	
	public static long findLargestPrimeFactor(long n) {
		
	//	  return LongStream.rangeClosed((long) Math.sqrt(n), 2).filter(no -> n%no != 0 && isPrime(no)).lo;

	    for (long i = (long) Math.sqrt(n); i >= 2; i--) {
		    System.out.println("n, i " + n + " "+i);

	      if (n % i == 0 && isPrime(i)) {
	        return i;
	      }
	    }
	    return n;
	  }

	  public static boolean isPrime(long number) {
		  return LongStream.rangeClosed(2, (long) Math.sqrt(number)).allMatch(no -> number%no != 0 );
	  }
	
}

@FunctionalInterface
interface WordCounter {
  int countWords(String text);
}


class Student{
	
	private String name,Sclass;
	private int age,id;
	
	public Student(String name, String sclass, int age, int id) {
		super();
		this.name = name;
		Sclass = sclass;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getSclass() {
		return Sclass;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", Sclass=" + Sclass + ", age=" + age + ", id=" + id + "]";
	}
	
	
	
} 
