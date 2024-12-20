package activities;

import java.util.Arrays;

public class Activity4 {
	public static void main(String args[]) {
        int[] data = { 4,3,2,10,12,1,5,6};
        insertnSort(data);
        System.out.println("Input Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }

	static void insertnSort(int array[]) {
        int size = array.length, i;
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
    
    

}
