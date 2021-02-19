package visualizer.algortihms;

import visualizer.Array;

public class QuickSort implements ISortAlgorithm{
	/** Pocet porovani v poslednim provedenem razeni */	
	int compares = 0;
	Array arr;

	boolean greaterThan(int a, int b) {
		compares++;
		return a > b;
	}

	@Override
	public void sort(Array arr) throws Exception {
		int[] data = arr.array;
		this.arr = arr;
		compares = 0;
		int start = 0;
		int end = data.length-1;
		quickSort(data, start, end, true);
	}

	void quickSort(int[] data, int start, int end, boolean x) throws Exception{
		if (start>end) return;
		int i;
		if(x==true) {
			i = split(data, start, end);
		}
		else {
			i = split2(data, start, end);
		}
		if(i!=start)quickSort(data, start, i-1, x); 
		if(i!=end) quickSort(data, i+1, end, x);

	}

	int split(int[] data, int left, int right) throws Exception{ 
		int pivot = data[right];
		while (true){ 	
			while ((greaterThan(pivot, data[left]))&&(right>left)) {
				left++;
			}
			if (right>left){
				data[right] = data[left];

				arr.updateArray(20);

				right--; 
			} else break;

			while ((greaterThan(data[right], pivot))&&(right>left)) {
				right--;
			}
			if (right>left){ 
				data[left] = data[right]; 
				arr.updateArray(20);
				left++; 	
			} else break;

		}
		data[left] = pivot; 
		arr.updateArray(20);
		return(left); 
	} 

	int split2(int[] data, int left, int right) throws Exception{ 
		int pivot = data[right];
		while (true){ 	
			while ((pivot > data[left])&&(right>left)) {
				left++;
			}
			if (right>left){
				data[right] = data[left]; 
				arr.updateArray(20);
				right--; 
			} else break;

			while ((data[right] > pivot)&&(right>left)) {
				right--;
			}
			if (right>left){ 
				data[left] = data[right]; 
				arr.updateArray(20);
				left++; 	
			} else break;

		}
		data[left] = pivot;
		arr.updateArray(20);
		return(left); 
	} 





}
