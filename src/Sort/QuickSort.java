package Sort;


import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	public static void sort(Comparable []a){
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}

	private static void sort(Comparable []a,int lo,int hi){
		if(hi<=lo) return;
		int j = partition(a,lo,hi);//�з֡��ؼ�
		//�ݹ����
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	private static int partition(Comparable []a,int lo,int hi){
		//����ɨ��ָ��
		int i = lo;
		int j = hi+1;
		//�з�Ԫ��
		Comparable v = a[lo];
		
		
		while(true)
		{
			while(SortDemo.less(a[++i],v)) if(i==hi) break; //a[i]С��vʱ������i
			while(SortDemo.less(v,a[--j])) if(i==hi) break; //a[j]����vʱ����Сj
			if(i>=j) break;
			SortDemo.exch(a, i, j);
		}
		//ָ��������
		SortDemo.exch(a, lo, j);
		return j;
	}
	
}
