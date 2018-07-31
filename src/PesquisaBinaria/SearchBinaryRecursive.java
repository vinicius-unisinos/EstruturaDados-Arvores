package PesquisaBinaria;

import java.util.Arrays;

public class SearchBinaryRecursive {

 public static void main(String[] args) {
		int[] array = { 1, 8, 34, 67, 9, 6, 78, 12, 56, 41, 90 };
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(search(array, 6));
		System.out.println(search(array, 78));
		System.out.println(search(array, 90));
	}

	private static int search(int[] array, int chave) {
		return searchBinaryRecursive(array, 0, array.length - 1, chave);
	}
 
	static int searchBinaryRecursive(int[] array, int menor, int maior,
			int chave) {
		int media = (maior + menor) / 2;
		int valorMeio = array[media];

		if (menor > maior)
			return -1;
		else if(valorMeio == chave) 
			return media;
		else if (valorMeio < chave)
			return searchBinaryRecursive(array, media+1, maior, chave);
		else
			return searchBinaryRecursive(array, menor, media-1, chave);
	}
}