package eulerproblems.helper;

public class InsertionSort {
	
	private int[] x;
	
	public InsertionSort(int[] unsorted) {
		this.x = unsorted;
	}
	
	public void sort() {
		for(int i=1; i<x.length; i++) {
			int key = x[i];
			int j;
			for(j=i-1; j>=0 && key < x[j]; j--) {
				x[j+1] = x[j];
			}
			x[j+1] = key;
		}
	}
	
	public void print() {
		for(int n : x) {
			System.out.print(n + " ");
		}
	}
	

}
