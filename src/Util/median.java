package Util;

import Sort.QuickSort;
import edu.princeton.cs.algs4.StdRandom;

public class median {
	
	//找到一组数据中第K小的元素，也可以用来找中位数 k=2/N
	public static Comparable select(Comparable[]a,int k){
		StdRandom.shuffle(a);
		int lo = 0; int hi = a.length-1;
		while(hi>lo){
			int j = QuickSort.partition(a,lo,hi);
			if(j==k)  return a[k];
			else if(j>k) hi = j-1;
			else if(j<k) lo = j+1;
		}
		return a[k];
		
	}

}
