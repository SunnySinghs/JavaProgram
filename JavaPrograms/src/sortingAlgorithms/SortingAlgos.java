package sortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SortingAlgos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number to be present in array:");
		int n = sc.nextInt();
		int[] arr = new int[n]; 
		System.out.println("Please enter the element to store in array:");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the number to sort array  according to corresponding sorting");
		System.out.println("1 : Bubble Sort");
		System.out.println("2 : Recursive Bubble Sort");
		System.out.println("3 : Selection Sort");
		System.out.println("4 : Insertion Sort");
		System.out.println("5 : Recursive Insertion Sort");
		System.out.println("6 : Quick Sort");
		System.out.println("7 : Recursive Quick Sort");
		System.out.println("8 : Merge Sort");
		System.out.println("9 : Heap Sort");
		System.out.println("10 : Counting Sort");
		System.out.println("11 : Radix Sort");
		System.out.println("0 : Exit");
		System.out.println("input array: "+Arrays.toString(arr));
		switch (sc.nextInt()) {
		case 1:
			bubbleSort(arr);
			break;
		case 2:
			recursiveBubbleSort(arr, arr.length);
			break;
		case 3:
			selectionSort(arr);
			break;
		case 4:
			insertionSort(arr);
			break;
		case 5:
			recursiveInsertionSort(arr, arr.length);
			break;
		case 6:
			recursiveInsertionSort(arr, arr.length);
			break;
		case 7:
			recursiveQuickSort(arr, 0, arr.length-1);
			break;
		case 8:
			mergeSort(arr, 0, arr.length-1);
			break;
		case 9:
			heapSort(arr);
			break;
		case 10:
			countingSort(arr);
			break;
		case 11:
			radixSort(arr,arr.length);
			break;
		default:
			break;
		}
		System.out.println("Sorted array: "+Arrays.toString(arr));

		sc.close();
	}

	private static void radixSort(int[] arr, int n) {
		int max = getMax(arr);
		for(int exp = 1; max/exp>0; exp*=10) {
			radixCountSort(arr,n,exp);
		}
	}
	private static void radixCountSort(int[] arr, int n, int exp) {
		int[] output = new int[n];
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		for(int i=0;i<n;i++) {
			count[(arr[i]/exp)%10]++;
		}
		
		for(int i=1;i<10;i++) {
			count[i]+=count[i-1];
		}
		
		for(int i=n-1;i>=0;i--) {
			output[count[(arr[i]/exp)%10]-1] = arr[i]; 
			count[(arr[i]/exp)%10]--;
		}
		for(int i=0;i<n;i++) {
			arr[i] = output[i];
		}
	}

	private static int getMax(int[] arr) {
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max<arr[i])
				max = arr[i];
		}
		return max;
	}

	private static void countingSort(int[] arr) {
		int n = arr.length;
		int[] output = new int[n];
		int[] count = new int[256];
		for(int i=0;i<256;i++) {
			count[i] = 0;
		}
		for(int i=0; i<n; i++) {
			++count[arr[i]];
		}
		for(int i=1;i<256;i++) {
			count[i]+=count[i-1];
		}
		for(int i=0; i<n; i++) {
			output[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}
		for(int i=0;i<n;i++) {
			arr[i] = output[i];
		}
	}

	private static void heapSort(int[] arr) {
		int n = arr.length;
		for(int i=n/2-1;i>=0;i--) {
			heapify(arr,n,i);
		}
		for(int i=n-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int[] arr, int n, int i) {
		int larg = i, l = 2*larg+1, r = 2*larg+2;
		if(l<n && arr[l] > arr[larg] ) {
			larg = l;
		}
		if(r<n && arr[r] > arr[larg] ) {
			larg = r;
		}
		if(larg!=i) {
			int temp = arr[i];
			arr[i] = arr[larg];
			arr[larg] = temp;
			heapify(arr, n, larg);
		}
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if(low<high) {
			int mid = (low + high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr,low,mid,high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int n1 = mid-low+1;
		int n2 = high-mid;
		
		int[] la = new int[n1];
		int[] ra = new int[n2];
		
		for(int i=0;i<n1;i++) {
			la[i] = arr[low+i];
		}
		for(int j=0;j<n2;j++) {
			ra[j] = arr[mid+1+j];
		}
		int i=0,j=0,k=low;
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
			k++;
			i++;
		}
		while(j<n2) {
			arr[k] = ra[j];
			j++;
			k++;
		}
	}

	private static void recursiveQuickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pi = partition(arr,low,high);
			recursiveQuickSort(arr, low, pi-1);
			recursiveQuickSort(arr, pi+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pi = arr[high], i = low-1,temp;
		for(int j=low;j<high;j++) {
			if(arr[j]<=pi) {
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}

	private static void recursiveInsertionSort(int[] arr, int n) {
		if(n<=1) {
			return;
		}
		recursiveInsertionSort(arr, n-1);
		int key,j;
		key = arr[n-1];
		j= n-2;
		for(int i=1;i<arr.length;i++) {
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}

	private static void insertionSort(int[] arr) {
		int key,j;
		for(int i=1;i<arr.length;i++) {
			key = arr[i];
			j= i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}

	private static void selectionSort(int[] arr) {
		int min,temp;
		for(int i=0; i<arr.length-1; i++) {
			min = i;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					min = j;
				}
			}
			if(min != i) {
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}

	private static void recursiveBubbleSort(int[] arr, int length) {
		if(length == 1) {
			return;
		}
		int temp;
		boolean swapped = false;
		for(int j= 0; j<arr.length-1; j++) {
			swapped = false;
			if(arr[j+1]<arr[j]) {
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				swapped = true;
			}
		}
		if(!swapped) {
			recursiveBubbleSort(arr, 1);
		}else {
			recursiveBubbleSort(arr, length-1);
		}
	}

	private static void bubbleSort(int[] arr) {
		if(arr== null) {
			return;
		}
		int temp;
		boolean swapped = false;
		for(int i =0; i<arr.length-1; i++) {
			swapped = false;
			for(int j= 0; j<arr.length-i-1; j++) {
				if(arr[j+1]<arr[j]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}

}
