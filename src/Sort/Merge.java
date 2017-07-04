package Sort;

import sun.tools.jar.resources.jar;

public class Merge {
	private static Comparable []aux;
	
	public static void sort(Comparable[]a){
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	//�Զ�����
	private static void sort(Comparable[]a,int lo,int hi){
		if(hi<lo) return;
		int mid =  lo+(hi-lo)/2;
		sort(a,lo,mid);//��������
		sort(a,mid+1,hi);//�Ұ������
		merge(a, lo, mid, hi);//����
	}
	
	
	
	public static void merge(Comparable [] a,int lo,int mid,int hi){
		int i = lo; 
		int j=mid+1;
		
		for(int k=lo;k<=hi;k++){
			//������Ԫ�ظ��Ƶ���������aux[]��
			aux[k]=a[k];
		}
		//�鲢��a[]
		for(int k=lo;k<=hi;k++){
			//�������þ���ȡ�ұ�
			if(i>mid)                    a[k] = aux[j++];
			////����ұ��þ���ȡ���
			else if(j>hi)                a[k] = aux[i++];
			//�Ұ�ߵ�ǰԪ��С�����ߵ�ǰԪ�أ�ȡ�ұ�
			else if(SortDemo.less(aux[j],aux[i])) a[k] = aux[j++];
			//�Ұ�ߵ�ǰԪ�ش������ߵ�ǰԪ�أ�ȡ���
			else 						 a[k] = aux[i++];
			
		}
		
	}

}
