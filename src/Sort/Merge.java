package Sort;

import sun.tools.jar.resources.jar;

public class Merge {
	private static Comparable []aux;
	
	public static void sort(Comparable[]a){
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	//自顶向下
	private static void sort(Comparable[]a,int lo,int hi){
		if(hi<lo) return;
		int mid =  lo+(hi-lo)/2;
		sort(a,lo,mid);//左半边排序
		sort(a,mid+1,hi);//右半边排序
		merge(a, lo, mid, hi);//并归
	}
	
	
	
	public static void merge(Comparable [] a,int lo,int mid,int hi){
		int i = lo; 
		int j=mid+1;
		
		for(int k=lo;k<=hi;k++){
			//把所有元素复制到辅助数组aux[]中
			aux[k]=a[k];
		}
		//归并回a[]
		for(int k=lo;k<=hi;k++){
			//如果左边用尽，取右边
			if(i>mid)                    a[k] = aux[j++];
			////如果右边用尽，取左边
			else if(j>hi)                a[k] = aux[i++];
			//右半边当前元素小于左半边当前元素，取右边
			else if(SortDemo.less(aux[j],aux[i])) a[k] = aux[j++];
			//右半边当前元素大于左半边当前元素，取左边
			else 						 a[k] = aux[i++];
			
		}
		
	}

}
