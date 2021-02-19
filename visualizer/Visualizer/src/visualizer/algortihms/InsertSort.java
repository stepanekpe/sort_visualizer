package visualizer.algortihms;

import visualizer.Array;

public class InsertSort implements ISortAlgorithm{
	int compares = 0;

	
	boolean greaterThan(int[] data, int i, int v) {
		compares++;
		return data[i] > v;
	}

	@Override
	public void sort(Array arr) throws Exception{
		int[] data = arr.array;
		compares = 0; 
		for (int i = 1; i < data.length; i++) {
			int v = data[i]; 
 			int j = i - 1;
			while((j >= 0) && (greaterThan(data, j, v))) {
				data[j+1] = data[j];
				j--;
			}		
			data[j+1] = v;
			
			
			arr.updateArray(30);
			
		}
	}

	
	
}
