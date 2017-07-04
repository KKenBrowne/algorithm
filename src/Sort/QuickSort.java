package Sort;


import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	public static void sort(Comparable []a){
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}

	private static void sort(Comparable []a,int lo,int hi){
		if(hi<=lo) return;
		int j = partition(a,lo,hi);//切分。关键
		//递归调用
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	private static int partition(Comparable []a,int lo,int hi){
		//左右扫描指针
		int i = lo;
		int j = hi+1;
		//切分元素
		Comparable v = a[lo];
		
		
		while(true)
		{
			while(SortDemo.less(a[++i],v)) if(i==hi) break; //a[i]小于v时，增大i
			while(SortDemo.less(v,a[--j])) if(i==hi) break; //a[j]大于v时，减小j
			if(i>=j) break;
			SortDemo.exch(a, i, j);
		}
		//指针相遇后
		SortDemo.exch(a, lo, j);
		return j;
	}
	
}
