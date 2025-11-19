package com.lsr.problems;

import java.util.*;

public class MergeList {
	
	
	
	private static List<Integer> mergeList(List<Integer> l1 , List<Integer> l2){
		List<Integer> mergedList = new ArrayList<Integer>();
		Collections.sort(l1);
		l2.sort(null);
		System.out.println(l1);
		System.out.println(l2);
		
		int i=0, j=0;
		try {
			while (i< l1.size() || j<l2.size()) {
				
				if(l1.get(i) <= l2.get(j) ) {
					mergedList.add(l1.get(i));
					i++;				
				}else {
					mergedList.add(l2.get(j));
					j++;
				}
				System.out.println("i is "+i);
				System.out.println("j is "+j);
				System.out.println(mergedList);
				System.out.println(" ========= ");
				
			}
		}catch(Exception e) {
		//	
		}
		while(i < l1.size()) {		
			mergedList.add(l1.get(i));
			i++;			
		}
		while(j < l2.size()) {		
			mergedList.add(l2.get(j));
			j++;			
		}
		
		
		
		
		System.out.println(mergedList);
		return mergedList;
		
	}
	public static void main(String args[]) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(3);
		l1.add(5);
		l1.add(7);
		l1.add(6);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(2);
		l2.add(4);
		l2.add(3);
		
		
		int[] a1 = {2,6,3};
		int[] a2 = {1,9,2};
		mergeList(l1,l2);
		mergeList(a1,a2);
		
		int n =12;
	    int result = 0;
	    char arr = (char) (n);

	}
	private static void mergeList(int[] a1, int[] a2) {
		
		int[] mergedInt = new int[a1.length+a2.length] ;
		
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		int i=0, j=0,k=0;
		try {
			while (i< a1.length || j<a2.length) {
				
				if(a1[i] <= a2[j] ) {
					mergedInt[k] = (a1[i]);
					i++;				
				}else {
					mergedInt[k] =(a2[j]);
					j++;
				}
				k++;
				System.out.println("i is "+i);
				System.out.println("j is "+j);
				System.out.println(mergedInt);
				System.out.println(" ========= ");
				
			}
		}catch(Exception e) {
		//	
		}
		while(i < a1.length) {		
			mergedInt[k] = (a1[i]);
			i++;	
			k++;
		}
		while(j < a2.length) {		
			mergedInt[k] = (a2[j]);
			j++;
			k++;
		}
		
		int x= 0;
		while(x < mergedInt.length) {		
			System.out.print(mergedInt[x]);
			x++;			
		}
	
		
		
	}
	

}
