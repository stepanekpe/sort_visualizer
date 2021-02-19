package visualizer.algortihms;

import visualizer.Array;

public class MergeSort implements ISortAlgorithm {
	int compares = 0;
	boolean x = true;
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
		mergeSort(data, 0, data.length-1);
	
	}

	void mergeSort(int[] data, int start, int end) throws Exception{ 
		if (end==start) return; 
		int mid = (start + end)/2; 
		mergeSort(data, start, mid); 
		mergeSort(data, mid+1, end); 
		int[] temp = bitonic(data, start, mid, end); 
		if(x==true) mergeBitonic(data, start, temp);
		else mergeBitonic2(data, start, temp);
	}
	
	int[] bitonic(int[] data, int start, int mid, int end) throws Exception{ 
		int[] result = new int[end-start+1];
		for (int i = start;i<=mid;i++)
			result[i-start] = data[i];
			arr.updateArray(20);
		for (int i = mid+1;i<=end;i++)
			result[end - start + mid + 1 - i] = data[i]; 
			arr.updateArray(20);
		return result;
	}

	void mergeBitonic(int[] data, int start, int[] bitonic) throws Exception{ 
		int i = 0;
		int j = bitonic.length-1; 
		for (int k = 0;k<bitonic.length;k++) 
			data[start+k] = greaterThan(bitonic[j], bitonic[i])? 
					bitonic[i++]:bitonic[j--];
			arr.updateArray(20);		
	}
	
	void mergeBitonic2(int[] data, int start, int[] bitonic) throws Exception{ 
		int i = 0;
		int j = bitonic.length-1; 
		for (int k = 0;k<bitonic.length;k++) 
			data[start+k] = (bitonic[j]>bitonic[i])? 
					bitonic[i++]:bitonic[j--];
			arr.updateArray(20);		
	}
	

}
