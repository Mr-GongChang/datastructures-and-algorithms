package com.gongchang.dsaa.datastructure.tree.binarytree;

/**
 * ����������
 * 
 * ��n���ڵ�Ķ�������n+1�����㷽ʽ��2n-(n-1)������ָ������Щ��ָ�������ָ��ĳ�ֱ�����ʽ��ǰ�����򣬺����µ�ǰ�������̽ڵ�
 * ��ָ��Ϊ��ʱָ��ǰ����㣬��Ϊ��ʱָ��������
 * ��ָ��Ϊ��ʱָ���̽ڵ㣬��Ϊ��ʱָ��������
 * 
 * 
 * @author GongChang
 *
 */
public class ThreadedBinaryTree {
	public static void main(String[] args) {
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		threadedBinaryTree.buildBinaryTree();
		
		threadedBinaryTree.preOrderThreadBinaryTree();
		threadedBinaryTree.preOrderRecListBinaryTree();
	}
	
	public void buildBinaryTree() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		node1.setLeftNode(node2);
		node1.setRightNode(node3);
		
		node2.setLeftNode(node4);
		node2.setRightNode(node5);
		
		node4.setRightNode(node6);
		
		node5.setLeftNode(node7);
		
		setRoot(node1);
	}
	
	
	private Node root;
	
	private Node preThreadedNode;
	
	private Boolean isPostRecListEnd = false;
	
	
	public void preOrderThreadBinaryTree() {
		preOrderThreadBinaryTree(root);
	}
	
	public void midOrderThreadBinaryTree() {
		midOrderThreadBinaryTree(root);
	}
	
	public void postOrderThreadBinaryTree() {
		postOrderThreadBinaryTree(root);
	}
	
	public void preOrderLoopListBinaryTree() {
		preOrderLoopListBinaryTree(root);
	}
	
	public void preOrderRecListBinaryTree() {
		preOrderRecListBinaryTree(root);
	}

	public void midOrderLoopListBinaryTree() {
		midOrderLoopListBinaryTree(root);
	}
	
	public void midOrderRecListBinaryTree() {
		midOrderRecListBinaryTree(root);
	}
	
	public void postOrderLoopListBinaryTree() {
		postOrderLoopListBinaryTree(root);
	}
	
	public void postOrderRecListBinaryTree() {
		postOrderRecListBinaryTree(root);
	}
	
	/**
	 * ǰ������������
	 * 
	 * @param node ��Ҫ�����������ĸ��ڵ�
	 */
	private void preOrderThreadBinaryTree(Node node) {
		// �����ݹ�
		if(node==null) {
			return;
		}
		
		// ��ǰ�ڵ㴦��
		if(node.getLeftNode()==null) {
			node.setLeftNode(preThreadedNode);
			node.setLeftType(1);
		}
		if(preThreadedNode!=null&&preThreadedNode.getRightNode()==null) {
			preThreadedNode.setRightNode(node);
			preThreadedNode.setRightType(1);
		}
		preThreadedNode = node;
		
		// ��ݹ�
		if(node.getLeftType()!=1) {
			preOrderThreadBinaryTree(node.getLeftNode());
		}
		
		// �ҵݹ�
		if(node.getRightType()!=1) {
			preOrderThreadBinaryTree(node.getRightNode());
		}
	}
	
	/**
	 * ��������������
	 * 
	 * @param node ��Ҫ�����������ĸ��ڵ�
	 */
	private void midOrderThreadBinaryTree(Node node) {
		// �����ݹ�
		if(node==null) {
			return;
		}
		
		// ��ݹ�
		if(node.getLeftType()!=1) {
			midOrderThreadBinaryTree(node.getLeftNode());
		}
		
		// ��ǰ�ڵ㴦��
		if(node.getLeftNode()==null) {
			node.setLeftNode(preThreadedNode);
			node.setLeftType(1);
		}
		if(preThreadedNode!=null&&preThreadedNode.getRightNode()==null) {
			preThreadedNode.setRightNode(node);
			preThreadedNode.setRightType(1);
		}
		preThreadedNode = node;
		
		// �ҵݹ�
		if(node.getRightType()!=1) {
			midOrderThreadBinaryTree(node.getRightNode());
		}
	}
	
	/**
	 * ��������������
	 * 
	 * @param node ��Ҫ�����������ĸ��ڵ�
	 */
	private void postOrderThreadBinaryTree(Node node) {
		// �ݹ��˳�����
		if(node==null) {
			return;
		}
		
		// ��ݹ�
		if(node.getLeftType()!=1) {
			postOrderThreadBinaryTree(node.getLeftNode());
		}
		
		// �ҵݹ�
		if(node.getRightType()!=1) {
			postOrderThreadBinaryTree(node.getRightNode());
		}
		
		// ��ǰ�ڵ㴦��
		if(node.getLeftNode()==null) {
			node.setLeftNode(preThreadedNode);
			node.setLeftType(1);
		}
		if(preThreadedNode!=null&&preThreadedNode.getRightNode()==null) {
			preThreadedNode.setRightNode(node);
			preThreadedNode.setRightType(1);
		}
		preThreadedNode = node;
	}
	
	/**
	 * ǰ��ݹ����������
	 * 
	 * @param node ��Ҫǰ������ĸ��ڵ�
	 */
	private void preOrderRecListBinaryTree(Node node) {
		if(node==null) {
			return;
		}
		
		Node curNode = node; 
		curNode.printNodeInfo();
		
		while(curNode.getLeftType()!=1) {
			curNode = curNode.getLeftNode();
			curNode.printNodeInfo();
		}
		
		while(curNode.getRightType()==1) {
			curNode = curNode.getRightNode();
			curNode.printNodeInfo();
		}
		
		if(curNode.getLeftType()!=1) {
			preOrderRecListBinaryTree(curNode.getLeftNode());
		}else {
			preOrderRecListBinaryTree(curNode.getRightNode());
		}
		
		
	}
	
	/**
	 * ǰ��ѭ������������
	 * 
	 * @param node ��Ҫǰ������ĸ��ڵ�
	 */
	private void preOrderLoopListBinaryTree(Node node) {
		if(node==null) {
			return;
		}
		
		Node curNode = node; 
		while(curNode!=null) {
			
			curNode.printNodeInfo();
			
			while(curNode.getLeftType()!=1) {
				curNode = curNode.getLeftNode();
				curNode.printNodeInfo();
			}
			
			while(curNode.getRightType()==1) {
				curNode = curNode.getRightNode();
				curNode.printNodeInfo();
			}
			
			if(curNode.getLeftType()!=1) {
				curNode=curNode.getLeftNode();
			}else {
				curNode=curNode.getRightNode();
			}
			
		}
		
	}
	
	/**
	 * ����ݹ����������
	 * 
	 * @param node ��Ҫ��������ĸ��ڵ�
	 */
	private void midOrderRecListBinaryTree(Node node) {
		if(node==null) {
			return;
		}
		
		Node curNode = node; 
		while(curNode.getLeftType()!=1) {
			curNode = curNode.getLeftNode();
		}
		curNode.printNodeInfo();
		
		while(curNode.getRightType()==1) {
			curNode = curNode.getRightNode();
			curNode.printNodeInfo();
		}
		
		midOrderRecListBinaryTree(curNode.getRightNode());
	}
	
	/**
	 * ����ѭ������������
	 * 
	 * @param node ��Ҫ��������ĸ��ڵ�
	 */
	private void midOrderLoopListBinaryTree(Node node) {
		if(node==null) {
			return;
		}
		
		Node curNode = node; 
		while(curNode!=null) {
			
			while(curNode.getLeftType()!=1) {
				curNode = curNode.getLeftNode();
			}
			
			curNode.printNodeInfo();
			
			while(curNode.getRightType()==1) {
				curNode = curNode.getRightNode();
				curNode.printNodeInfo();
			}
			
			curNode = curNode.getRightNode();
		}
		
	}
	
	/**
	 * ����ѭ������������
	 * 
	 * @param node ��Ҫ��������ĸ��ڵ�
	 */
	private void postOrderLoopListBinaryTree(Node node) {
		if(node==null) {
			return;
		}
		
		Node curNode = node;
		retry:
		while(curNode!=null) {
			while(curNode.getLeftType()!=1) {
				curNode = curNode.getLeftNode();
			}
			
			if(curNode.getRightType()==0) {
				curNode = curNode.getRightNode();
				continue retry;
			}else {
				curNode.printNodeInfo();
				while(curNode.getRightType()==1) {
					curNode = curNode.getRightNode();
					curNode.printNodeInfo();
				}
			}
			
			if(curNode==root) {
				curNode=null;
			}else if(curNode==curNode.getParentNode().getRightNode()){
				curNode = curNode.getParentNode();
			}else if(curNode==curNode.getParentNode().getLeftNode()&&curNode.getParentNode().getRightNode()==null) {
				curNode = curNode.getParentNode();
			}else if(curNode==curNode.getParentNode().getLeftNode()&&curNode.getParentNode().getRightNode()!=null) {
				curNode=curNode.getParentNode().getRightNode();
			}
		}
	}
	
	/**
	 * ����ݹ����������
	 * 
	 * @param node ��Ҫ��������ĸ��ڵ�
	 */
	private void postOrderRecListBinaryTree(Node node) {
		if(node==null) {
			return;
		}
		
		Node curNode = node;
		while(curNode!=null&&!isPostRecListEnd) {
			while(curNode.getLeftType()!=1) {
				curNode = curNode.getLeftNode();
			}
			
			if (curNode.getRightType() == 0) {
				postOrderRecListBinaryTree(curNode.getRightNode());
			} else {
				curNode.printNodeInfo();
				while (curNode.getRightType() == 1) {
					curNode = curNode.getRightNode();
					curNode.printNodeInfo();
				}
			}
			 
			if(curNode==root) {
				curNode=null;
				isPostRecListEnd=true;
			}else if(curNode==curNode.getParentNode().getRightNode()){
				curNode = curNode.getParentNode();
			}else if(curNode==curNode.getParentNode().getLeftNode()&&curNode.getParentNode().getRightNode()==null) {
				curNode = curNode.getParentNode();
			}else if(curNode==curNode.getParentNode().getLeftNode()&&curNode.getParentNode().getRightNode()!=null) {
				postOrderRecListBinaryTree(curNode.getParentNode().getRightNode());
			}
		}
	}
	
	
	public void setRoot(Node root) {
		this.root = root;
	}


	private class Node{
		private int data;
		private Node parentNode;
		private Node leftNode;
		private Node rightNode;
		/**
		 * 1-ǰ���ڵ㣬0-������
		 */
		private int leftType;
		
		/**
		 * 1-��̽ڵ㣬0-������
		 */
		private int rightType;
		
		
		public Node() {
			super();
		}

		public Node(int data) {
			super();
			this.data = data;
		}
		
		
		public void printNodeInfo() {
			System.out.println(this.toString());
		}
		
		
		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getParentNode() {
			return parentNode;
		}

		public void setParentNode(Node parentNode) {
			this.parentNode = parentNode;
		}

		public Node getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node leftNode) {
			if(leftNode!=null&&leftNode.getParentNode()==null) {
				leftNode.setParentNode(this);
			}
			this.leftNode = leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node rightNode) {
			if(rightNode!=null&&rightNode.getParentNode()==null) {
				rightNode.setParentNode(this);
			}
			this.rightNode = rightNode;
		}

		public int getLeftType() {
			return leftType;
		}

		public void setLeftType(int leftType) {
			this.leftType = leftType;
		}

		public int getRightType() {
			return rightType;
		}

		public void setRightType(int rightType) {
			this.rightType = rightType;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", leftNode=" + ((leftNode==null)?"null":leftNode.getData()) + ", rightNode=" + ((rightNode==null)?"null":rightNode.getData()) + ", leftType="
					+ leftType + ", rightType=" + rightType + "]";
		}
		
	}
}
