package sortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
 
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
 
        System.out.println("sorted array:"+ Arrays.toString(arr));
	} 
	
	void sort(int[] arr, int low, int high) {
		if(low<high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}

	public int partition(int[] arr, int low, int high) {
		int pi = arr[high];
		int i = (low-1);
		for(int j = low; j <=high-1; j++) {
			if(arr[j] <=pi) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}

}
