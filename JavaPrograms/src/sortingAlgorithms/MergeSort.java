package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		 int arr[] = {12, 11, 13, 5, 6, 7};
		 
	        System.out.println("Given Array"+Arrays.toString(arr));
	        
	 
	        MergeSort ob = new MergeSort();
	        ob.sort(arr, 0, arr.length-1);
	 
	        System.out.println("\nSorted array"+Arrays.toString(arr));

	}

	void sort(int[] arr, int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			sort(arr,l,m);
			sort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}

	void merge(int[] arr, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		int[] la = new int[n1];
		int[] ra = new int[n2];
		
		for(int i =0;i<n1;++i) {
			la[i] = arr[l+i];
		}
		for(int j =0;j<n2;++j) {
			ra[j] = arr[m+1+j];
		}
		int i=0,j=0,k=l;
		while(i<n1 && j<n2) {
			if(la[i]<=ra[j]) {
				arr[k] = la[i];
				i++;
			}else {
				arr[k] = ra[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			arr[k] = la[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k] = ra[j];
			j++;
			k++;
		}
	}
}
