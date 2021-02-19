package visualizer.algortihms;

import visualizer.Array;

public class SelectionSort implements ISortAlgorithm {
	public void sort(Array arr) throws Exception {
		int array[] = arr.array;
	    for (int i = 0; i < array.length; i++) {
	        int min = array[i];
	        int minId = i;
	        for (int j = i+1; j < array.length; j++) {
	            if (array[j] < min) {
	                min = array[j];
	                minId = j;
	                arr.updateArray(10);
	            }
	        }
	        // swapping
	        int temp = array[i];
	        array[i] = min;
	        array[minId] = temp;
	        arr.updateArray(10);
	    }
	}
}
