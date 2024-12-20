package activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numSearch=10;
		int sumFixed=30;
		int arr[]= {10, 77, 10, 54, -11, 10};
		System.out.println("The array is "+ Arrays.toString(arr));
		System.out.println("Result is "+ checkSum(numSearch,sumFixed,arr));
		
	}
	
	 public static boolean checkSum(int numSearch,int sumFixed,int[] a)
		{
		
			
			
			int sum=0;
			for (int i=0;i<a.length;i++)
			{
				if(a[i]==10)
					sum=sum+a[i];
			}
			
			System.out.println("The sum is "+sum);
			if(sum==30)
			{
				System.out.println("Sum is 30 and its true");
				return true;
			}
			else
			{
				System.out.println("Sum is not 30 and its false");
				return false;
			}
		
	   }

}
