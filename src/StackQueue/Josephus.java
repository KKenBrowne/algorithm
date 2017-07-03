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
			//for循环一次，就把第M个数字放到队列尾巴，然后dequeue打印出来
			for(int i=0;i<M-1;i++)
			{
				queue.enqueue(queue.dequeue());
			}
			System.out.println(queue.dequeue()+"");
		}
		
	}

}
