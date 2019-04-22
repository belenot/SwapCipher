package com.belenot.mgupi.practice;

import java.util.stream.*;
import java.util.Arrays;

public class SwapCipher {
	private SwapCipher() {} ;
	
	public static void main(String[] args) {
		System.out.println("SwapCipher");
	    encode(null, new int[] {1,2,3,5,4});
	}

	public static char[] encode(char[] message, int[] indexes) {
	    if (message == null || indexes == null ||
			message.length == 0 || indexes.length == 0 ||
			message.length != indexes.length ||
			Arrays.stream(indexes).distinct().count() != indexes.length
			) {
			throw new IllegalArgumentException();
		}
		char[] encoded = new char[message.length];
		for (int i = 0; i < message.length; i++) {
		    encoded[i] = message[indexes[i] - 1];
		}
			
		return encoded;
	}

	public static char[] decode(char[] encoded, int[] indexes) {
		if (encoded == null || indexes == null ||
			encoded.length == 0 || indexes.length == 0 ||
			encoded.length != indexes.length ||
			Arrays.stream(indexes).distinct().count() != indexes.length
			) {
			throw new IllegalArgumentException();
		}
		char[] message = new char[encoded.length];
		for (int i = 0; i < encoded.length; i++) {
			message[i] = encoded[indexes[i] - 1];
		}

		return message;
	}

	
}
