import java.util.Scanner;


//牛客网：二叉树遍历
class BTNode{
	public BTNode(char val){
		this.val = val;
	}
	BTNode left = null;
	BTNode right = null;
	char val;
}

class BinTree{
	private BTNode root = null;
	int index = 0;
	BinTree(String s, char invalid){
		root = createBinTree(s, invalid);
	}
	
	private BTNode createBinTree(String s, char invalid){
		BTNode newRoot = null;
		if(index < s.length() && s.charAt(index) != invalid){
			newRoot = new BTNode(s.charAt(index));
			
			++index;
			newRoot.left = createBinTree(s, invalid);
			
			++index;
			newRoot.right = createBinTree(s, invalid);
			
		}
		
		return newRoot;
	}
	
	public void inOrder(){
		inOrder(root);
		System.out.println();
	}
	
	private void inOrder(BTNode root){
		if(null != null){
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}
}

public class Main{
	public static void main(String[] args){
		
		//将来要通过标准输入接收前序结果
		Scanner sc = new Scanner(System.in);
		
		//对于IO类型的OJ题目，必须要循环输入
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			BinTree bt = new BinTree(s, '#');
			bt.inOrder();
		}
	}
}