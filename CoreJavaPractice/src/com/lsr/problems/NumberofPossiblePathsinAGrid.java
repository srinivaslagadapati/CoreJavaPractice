package com.lsr.problems;

import java.util.Iterator;

//Problem Statement: Find the number of unique paths from the top-left corner (0, 0)
//to the bottom-right corner (n-1, m-1) of an n x m grid. You can only move right or down.

public class NumberofPossiblePathsinAGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(4,6));
		 

	}
	
	public static int uniquePaths(int n, int m) {
		int[][] arr= new int[n][m];
		System.out.println("arr  init"+arr);
		for (int i=0;i<n;i++) {
			arr[i][0]=1;
		}
		System.out.println("after n arr  "+arr.toString());
		
		for (int j=0;j<m;j++) {
			arr[0][j]=1;
		}
		System.out.println("after m arr  "+arr.toString());

		for (int i=1;i<n;i++) {
			for (int j=1;j<m;j++) {
				arr[i][j]= arr[i-1][j]+arr[i][j-1];
			}
		}
		
		
		 
		 
		return arr[n-1][m-1];		 
		 
	 }

}
