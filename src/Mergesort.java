import java.lang.reflect.Array;

/**
 * Sorts an array using merge sort algorithm
 * 
 * @author scott
 * 
 */
public class Mergesort<T extends Comparable<? super T>> {

	public Mergesort() {
		
	}
	
	@SuppressWarnings("unchecked")
	private T[] sort(T[] pNumbers) throws IllegalArgumentException {
		int length = pNumbers.length;

		if (length > 1) {

			int firstSize = length / 2;
			int secondSize = length - (length / 2);

			// Split array in 1/2.
			
			T[] firstHalf = (T[])Array.newInstance(pNumbers.getClass().getComponentType(), firstSize);
			T[] secondHalf = (T[])Array.newInstance(pNumbers.getClass().getComponentType(), secondSize);
			System.arraycopy(pNumbers, 0, firstHalf, 0, firstSize);
			System.arraycopy(pNumbers, length / 2, secondHalf, 0, secondSize);
			// Recursively sort first half and sort second half. Then merge
			return merge(sort(firstHalf), sort(secondHalf));
		} else if (length == 1) {
			return pNumbers;
		} else { // length == 0
			// throw new IllegalArgumentException("Array should not be empty.");
			return pNumbers;
		}
	}

	@SuppressWarnings("unchecked")
	private T[] merge(T[] pHalf1, T[] pHalf2) {

		T[] result = (T[])Array.newInstance(pHalf1.getClass().getComponentType(), pHalf1.length + pHalf2.length);

		// Half1 index, Half2 index, result index
		int i = 0, j = 0, k = 0;

		while (i < pHalf1.length && j < pHalf2.length) {
			if (pHalf1[i].compareTo(pHalf2[j]) < 0) {
				result[k++] = pHalf1[i++];
			} else {
				result[k++] = pHalf2[j++];
			}
		}

		// add any remaining values
		while (i < pHalf1.length) {
			result[k++] = pHalf1[i++];
		}

		while (j < pHalf2.length) {
			result[k++] = pHalf2[j++];
		}

		return result;
	}

	static void printArray(Double[] numbers) {
		int length = numbers.length;
		for (int i = 0; i < length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println("");
	}

	// entry-point
	public static void main(String[] args) {

		// array of numbers to sort
		Double[] numbers = { -60.0, 3.0, 5.0, 7.0, 8.0, 2.0, 4.0, 6.0, 1.0, 13.0, 25.0, -7.0, 64.0, 0.0, 8.0,
				8.0, 6.0, 7.0, -4.0, -6.0, -45.6, 70.0 };
		System.out.println("Unsorted array: ");
		printArray(numbers);

		// get the sorting algorithm
		Mergesort<Double> mergeSort = new Mergesort<Double>();

		// sort the numbers
		numbers = mergeSort.sort(numbers);

		// print the result
		System.out.println("Sorted array: ");
		printArray(numbers);
	}

}
