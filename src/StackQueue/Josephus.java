package StackQueue;
import edu.princeton.cs.algs4.Queue;

public class Josephus {
	
	public static void main(String[] args) {
		int N = 7;
		int M = 2;
		Queue<Integer> queue = new Queue<Integer>();
		for(int i=0;i<N;i++){
			queue.enqueue(i);
		}
		while(!queue.isEmpty())
		{
			//forѭ��һ�Σ��Ͱѵ�M�����ַŵ�����β�ͣ�Ȼ��dequeue��ӡ����
			for(int i=0;i<M-1;i++)
			{
				queue.enqueue(queue.dequeue());
			}
			System.out.println(queue.dequeue()+"");
		}
		
	}

}
