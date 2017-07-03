package Sort;

public class Inseration {
	public static void sort(Comparable [] a){
		int N = a.length;
		for(int i=0;i<N;i++){
			for(int j=i;j>0 && SortDemo.less(a[j], a[j-1]);j--){
				SortDemo.exch(a, j, j-1);
			}
		}
	}

}
