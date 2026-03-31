/*
write a program to adding of 2-d matrix 
*/


import java.util.*;

public class additionOfTwoMatrix{
	static Scanner sc=new Scanner(System.in);
	public static void main(String [] args){

		int [][] matrix1=new int[3][3];
		int [][] matrix2=new int[3][3];

		matrix1=helper(matrix1,1);
		matrix2=helper(matrix2,2);
		for(int[]tem:matrix1)System.out.println(Arrays.toString(tem));
		for(int[]tem:matrix2)System.out.println(Arrays.toString(tem));

		int [][]ans=funAddMatrix(matrix1, matrix2,0);
		System.out.println("this is answer");
		for(int[]tem:ans)System.out.println(Arrays.toString(tem));



			
			
		}

		private static  int[][] helper(int[][]arr,int val){
		if(val==1){
			System.out.println("This is for matrix 1");
		}
		else{
			System.out.println("This is for matrix 2");
		}
			for(int row=0;row<3;row++){
				System.out.println("Enter the elements of row: "+ row);
				for(int col=0;col<3;col++){
					System.out.println("Enter the elements of column: "+ col);
					arr[row][col]= sc.nextInt();
				}
			}
			return arr;
		}
	private static int[][] funAddMatrix(int[][]arr1, int[][]arr2, int row){

		//base case if index reached last row
		if (row==arr1.length) return arr1;

		for(int col=0;col<arr1[row].length;col++){
			arr1[row][col]+=arr2[row][col];
		}
		return funAddMatrix(arr1,arr2,row+1);

	}
}