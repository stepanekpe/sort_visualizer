package visualizer.algortihms;

import visualizer.Array;

public class BubbleSort implements ISortAlgorithm {

	int compares;

	@Override
	public void sort(Array arr) throws Exception {
		int[] data = arr.array;
		compares = 0; 

		int n = data.length;  
		int temp = 0;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(data[j-1] > data[j]){ 
					temp = data[j-1];  
					data[j-1] = data[j];  
					data[j] = temp;  
					
					arr.updateArray(2);
					
					
				}  

			}  
		}  


	}

}
