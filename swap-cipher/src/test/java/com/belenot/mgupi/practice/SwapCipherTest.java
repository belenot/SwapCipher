package com.belenot.mgupi.practice;


import java.util.List;
import java.util.LinkedList;
import java.util.stream.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;



public class SwapCipherTest {

	private class Bundle {
		public Bundle(String message, String encoded, String indexes) {
			this.message = message.toCharArray();
			this.indexes = indexes.codePoints().mapToObj( c -> String.valueOf( (char) c)).mapToInt( c -> (Integer.parseInt(c))).toArray();
			this.encoded = encoded.toCharArray();
		}
		public char[] message;
		public char[] encoded;
		public int[] indexes;
	}

	public List<Bundle> trueBundles = new LinkedList<>();
	{
		trueBundles.add(new Bundle("hello", "hello", "12345"));
		trueBundles.add(new Bundle("hello", "hlelo", "13245"));
		trueBundles.add(new Bundle("hello", "hlleo", "14325"));
		trueBundles.add(new Bundle("hello", "hello", "12345"));
		trueBundles.add(new Bundle("hello", "oellh", "52341"));
		trueBundles.add(new Bundle("hello", "holle", "15342"));
	}
	
	public List<Bundle> falseBundles = new LinkedList<>();
	{
		falseBundles.add(new Bundle("hello", "hello", "13425"));
		falseBundles.add(new Bundle("hello", "hello", "13245"));
		falseBundles.add(new Bundle("hello", "lhleo", "14325"));
		falseBundles.add(new Bundle("hello", "helol", "12345"));
		falseBundles.add(new Bundle("hello", "oelhl", "52341"));
		falseBundles.add(new Bundle("hello", "hloel", "15342"));
	}

	public List<Bundle> excBundles = new LinkedList<>();
	{
		excBundles.add(new Bundle("helloa", "hello", "12345"));
		excBundles.add(new Bundle("hello", "hello", "153245"));
		excBundles.add(new Bundle("hellso", "hlleo", "12345"));
		excBundles.add(new Bundle("hellop", "helol", "12345"));
		excBundles.add(new Bundle("hello", "dapofig", "12341"));
		excBundles.add(new Bundle("", "hlole", "15342"));
	}
	
	
	@Test
	void testTrueBundles() {
		System.out.println("test true bundles:");
		int i = 1;
		for (Bundle bundle : trueBundles) {
			String log = String.format("%d. message=%s; key=%s; encoded=%s\n",
									   i++, Arrays.toString(bundle.message),
									   Arrays.toString(bundle.indexes),
									   Arrays.toString(bundle.encoded));
			System.out.println(log);
			assertArrayEquals(bundle.encoded, SwapCipher.encode(bundle.message, bundle.indexes), log);
			assertArrayEquals(bundle.message, SwapCipher.decode(bundle.encoded, bundle.indexes), log);
		}
	}

	@Test
	void testFalseBundles() {
		System.out.println("test false bundles:");
		int i = 1;
		for (Bundle bundle : falseBundles) {
			String log = String.format("%d. message=%s; key=%s; encoded=%s\n",
									   i++, Arrays.toString(bundle.message),
									   Arrays.toString(bundle.indexes),
									   Arrays.toString(bundle.encoded));
			System.out.println(log);
			assertFalse(Arrays.equals(bundle.encoded, SwapCipher.encode(bundle.message, bundle.indexes)), log);
			assertFalse(Arrays.equals(bundle.message, SwapCipher.decode(bundle.encoded, bundle.indexes)), log);
		}
	}

	@Test
	void testExcBundles() {
		System.out.println("test exception bundles:");
		int i = 1;
		for (Bundle bundle : excBundles) {
			String log = String.format("%d. message=%s; key=%s; encoded=%s\n",
									   i++, Arrays.toString(bundle.message),
									   Arrays.toString(bundle.indexes),
									   Arrays.toString(bundle.encoded));
			System.out.println(log);
			assertThrows(Throwable.class, new Executable() {
				public void execute() { SwapCipher.encode(bundle.message, bundle.indexes); }
			}, log);
		}
	}
	
}
