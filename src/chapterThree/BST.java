package chapterThree;

import javax.print.attribute.standard.RequestingUserName;
import javax.security.auth.kerberos.KeyTab;

import com.sun.javafx.sg.prism.NodePath;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.org.apache.xml.internal.serializer.ElemDesc;

import edu.princeton.cs.algs4.Queue;
import sun.net.www.content.text.plain;

public class BST <Key extends Comparable<Key>,Value>{
	//二叉树查找根节点
	private Node root;      
	
	private class Node{
		
		private Key key;    //键
		private Value val;	//值
		private Node left,right; //指向子树的链接
		private int N;  //已该节点为根的子节点总数
		
		public Node(Key key,Value val,int N)
		{
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(Node x)
	{
		if(x==null) return 0;
		else {return x.N;}
	}
	
	//性能优化的get
	public Value get(Key key)
	{
		Node x = root;
		while(x!=null)
		{
			int cmp = key.compareTo(x.key);
			if(cmp==0) return x.val;
			else if(cmp<0) x = x.left;
			else if(cmp>0) x = x.right;
		}
		return null;
	}
	
//	private Value get(Node x,Key key)
//	{
//		//节点不存在，返回null
//		if(x==null) return null;
//		int cmp = key.compareTo(x.key);
//		//如果查找的比此节点的小，就继续左节点查找，反之右节点
//		if(cmp<0) return get(x.left, key);
//		else if(cmp>0) return get(x.right, key);
//		else return x.val;
//	}
//	
//	
//	public Value get(Key key){
//		return get(root,key);
//	}
	
	private Node put(Node x,Key key,Value val){
		//如果x节点不存在，就新建一个X子节点
		if(x==null) return new Node(key,val,1);
		//如果x节点存在，key不存在，比较，小往左放，大往右放，迭代进行，插入适当位置，递归后重置父节点指向子节点的链接，并增加计数器的值
		int cmp = key.compareTo(x.key);
		if(cmp<0)      x.left  =  put(x.left,key,val);
		else if(cmp>0) x.right =  put(x.right,key,val);
		// =0代表key存在，直接更新
		else x.val = val;
		//路径上每个节点的计数器加1，等于所有子节点加一
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void put(Key key,Value val){
		root = put(root, key, val);
	}
	
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node x)
	{
		//递归
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public Key max()
	{
		return max(root).key;
	}
	
	private Node max(Node x){
		if(x.right==null) return x;
		return max(x.right);
	}
	public Key floor(Key key)
	{
		Node x = floor(root, key);
		if(x==null) return null;
		return x.key;
	}
	
	private Node floor(Node x,Key key)
	{
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp<0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t !=null) return x;
		else return x;
	}
	
	public Key select(int k){
		return select(root,k).key;
	}
	
	//查找排名为k的键
	private Node select(Node x,int k)
	{
		if(x==null) return null;
		//左树中的节点数
		int t = size(x.left);
		//如果左树中的节点数大于k，继续递归地在左树中查找
		if(t>k) return select(x.left, k);
		//左树中的节点数小于k，就在右找排名为k-t-1
		else if(t<k) return select(x.right, k-t-1);
		//节点数等于k的，返回
		else return x;
	}
	
	//rank不太懂
	public int rank(Key key){
		return rank(key,root);
	}
	private int rank(Key key,Node x)
	{
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return rank(key, x.left);
		else if(cmp>0) return 1+size(x.left)+rank(key, x.right);
		else return size(x.left);
	}
	
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	
	//不断检索左子树直到找到空的左链接，返回该节点的右链接，递归调用后更新链接和节点计算器
	private Node deleteMin(Node x)
	{
		if(x.left==null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) +1;
		return x;
	}
	
	public void deleteMax()
	{
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node x)
	{
		if(x.right==null) return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) +1;
		return x;
	}
	
	
	public void delete(Key key)
	{
		//新的根节点为删除之后的根节点
		root = delete(root, key);
	}
	
	private Node delete(Node x,Key key)
	{
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0)      x.left = delete(x.left,key);
		else if(cmp>0) x.right  = delete(x.right, key);
		//找到了该删除的节点后
		else
		{
			//如果是根节点的话
			if(x.right==null) return x.left;
			if(x.left==null) return x.right;
			//将指向即将被删除的节点保存指向为t
			Node t = x;
			//把X赋值为它右边树上最小的那个，此时x的左右是空的
			x = min(t.right);
			//将右链接指向删除最小的之后仍然所有节点都大于x.key的二叉树
			x.right = deleteMin(t.right);
			//把X的左边设置为原来的左边
			x.left = t.left;
		}
		//更新大小
		x.N = size(x.left) + size(x.right) +1;
		return x;
	}
	public Iterable<Key> keys()
	{ return keys(min(),max());}
	
	
	public Iterable<Key> keys(Key lo,Key hi)
	{ 
		Queue<Key> queue = new Queue<Key>();
		keys(root,queue,lo,hi);
		return queue;
	
	}
	
	
	private void keys(Node x,Queue<Key> queue,Key lo,Key hi)
	{
		if(x==null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo<0) keys(x.left, queue, lo, hi);
		if(cmplo<=0 && cmphi>=0) queue.enqueue(x.key);
		if(cmphi>0) keys(x.right, queue, lo, hi);
		
	}
	
	  public int height() 
	  {
        return height(root);
	  }
	  private int height(Node x) 
	  {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
      }	

	
	

}
