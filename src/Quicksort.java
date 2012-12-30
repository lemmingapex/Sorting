/**
 * Sorts an array using quick sort algorithm
 * 
 * @author scott
 * 
 */
public class Quicksort<T extends Comparable<? super T>> {

	private T[] numbers;
	
	public Quicksort() {
		
	}
	
	private T[] sort(T[] pNumbers) {
		if(pNumbers == null || pNumbers.length == 0) {
			return pNumbers;
		} else {
			numbers = pNumbers;
			quicksort(0, numbers.length - 1);
		}
		return numbers;
	}
	
	
	private void quicksort(int low, int high) {	
		int i = low, j = high;
		
		// choose pivot element 
		T pivot = numbers[(high + low)/2];

		while (i <= j) {
			while (numbers[i].compareTo(pivot) < 0) {
				i++;
			}

			while (numbers[j].compareTo(pivot) > 0) {
				j--;
			}
			
			if(i <= j) {
				swap(i++, j--);
			}
		}
		
		if(low < j) {
			quicksort(low, j);
		}
		if(i < high) {
			quicksort(i, high);
		}
		return;
	}
	
	private void swap(int i, int j) {
		T temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	void printArray(T[] numbers) {
		int length = numbers.length;
		for (int i = 0; i < length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println("");
	}

	// entry-point
	public static void main(String[] args) {

		// array of numbers to sort
		Double[] numbers = { -60.0, 3.0, 5.0, 4.0, -6.0, -45.6, 70.0, -109.3, 0.0, 70.1 };

		// get the sorting algorithm
		Quicksort<Double> quickSort = new Quicksort<Double>();

		System.out.println("Unsorted array: ");
		quickSort.printArray(numbers);
		
		// sort the numbers
		numbers = quickSort.sort(numbers);

		// print the result
		System.out.println("Sorted array: ");
		quickSort.printArray(numbers);
	}

}
