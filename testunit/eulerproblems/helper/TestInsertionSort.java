package eulerproblems.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestInsertionSort {
	 
	protected int[] a;
	
	@Before
	public void setUp() {
		a = new int[]{4,5,1,0,3,9,5,0};
	}

	@Test
	public void testInsertionSort() {
		InsertionSort is = new InsertionSort(a);
		is.sort();
		//is.print();
		assertTrue(Arrays.equals(a, new int[]{0,0,1,3,4,5,5,9}));
	}

}
