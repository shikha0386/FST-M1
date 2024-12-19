package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a[]= {10, 77, 10, 54, -11, 10};
		
		int sum=0;
		for (int i=0;i<a.length;i++)
		{
			if(a[i]==10)
				sum=sum+a[i];
		}
		
		System.out.println("The sum is "+sum);
	}

}
