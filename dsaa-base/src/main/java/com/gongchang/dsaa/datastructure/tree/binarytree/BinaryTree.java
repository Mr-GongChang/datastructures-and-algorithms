package com.gongchang.dsaa.datastructure.tree.binarytree;


/**
 * ������
 * 
 * �������Ǻ��������ӽڵ����
 * �ڵ㣬���ڵ㣬���ڵ㣬�ӽڵ㣬Ҷ�ӽڵ㣬·����Ȩ���㣬�������߶ȣ�����������ɭ�֣���
 * 
 * ��������������Ҷ�ӽڵ������һ�㣬�ڵ�������2^n-1(nΪ����)
 * ��ȫ��������Ҷ�ӽڵ������һ��͵����ڶ��㣬������һ����������������ڶ����ұ�����
 * �����������ڵ��������н���
 * 
 * ������Ҳ����ʹ������洢�����i�Ǹ��ڵ���±꣬��2i+1�����ӽڵ㣬2i+2�����ӽڵ�
 * 
 * @author GongChang
 *
 */
public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.buildBinaryTree();
		
		System.out.println("ǰ�����");
		binaryTree.preOrderTraversal();
		
		System.out.println("�������");
		binaryTree.midOrderTraversal();
		
		System.out.println("�������");
		binaryTree.postOrderTraversal();
		
		System.out.println("ǰ�����");
		System.out.println(binaryTree.preOrderSearch(3));;
		System.out.println("�������");
		System.out.println(binaryTree.midOrderSearch(3));;
		System.out.println("�������");
		System.out.println(binaryTree.postOrderSearch(1));;
		
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
	
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void preOrderTraversal() {
		if(root==null) {
			System.out.println("������Ϊ�գ����ܽ���ǰ�����");
		}else {
			root.preOrderTraversal();
		}
	}
	
	public void midOrderTraversal() {
		if(root==null) {
			System.out.println("������Ϊ�գ����ܽ����������");
		}else {
			root.midOrderTraversal();
		}
	}
	
	public void postOrderTraversal() {
		if(root==null) {
			System.out.println("������Ϊ�գ����ܽ��к������");
		}else {
			root.postOrderTraversal();
		}
	}
	
	public Node preOrderSearch(int findValue){
		if(root==null) {
			System.out.println("������Ϊ�գ����ܽ���ǰ�����");
			return null;
		}else {
			return root.preOrderSearch(findValue);
		}
			
	}
	
	public Node midOrderSearch(int findValue){
		if(root==null) {
			System.out.println("������Ϊ�գ����ܽ����������");
			return null;
		}else {
			return root.midOrderSearch(findValue);
		}
			
	}
	
	public Node postOrderSearch(int findValue){
		if(root==null) {
			System.out.println("������Ϊ�գ����ܽ��к������");
			return null;
		}else {
			return root.postOrderSearch(findValue);
		}
			
	}


	private class Node{
		
		private int data;
		
		private Node leftNode;
		
		private Node rightNode;
		
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
		private void preOrderTraversal() {
			this.printNodeInfo();
			
			if(leftNode!=null) {
				leftNode.preOrderTraversal();
			}
			
			if(rightNode!=null) {
				rightNode.preOrderTraversal();
			}
		}
		
		private void midOrderTraversal() {
			if(leftNode!=null) {
				leftNode.midOrderTraversal();
			}
			
			this.printNodeInfo();
			
			if(rightNode!=null) {
				rightNode.midOrderTraversal();
			}
		}
		
		private void postOrderTraversal() {
			if(leftNode!=null) {
				leftNode.postOrderTraversal();
			}
			
			if(rightNode!=null) {
				rightNode.postOrderTraversal();
			}
			
			this.printNodeInfo();
		}
		
		private Node preOrderSearch(int findValue) {
			if(this.getData()==findValue) {
				return this;
			}
			
			Node result = null;
			if(leftNode!=null) {
				result = leftNode.preOrderSearch(findValue);
				if(result!=null) {
					return result;
				}
			}
			
			if(rightNode!=null) {
				result = rightNode.preOrderSearch(findValue);
			}
			return result;
		}
		
		private Node midOrderSearch(int findValue) {
			Node result = null;
			if(leftNode!=null) {
				result = leftNode.midOrderSearch(findValue);
				if(result!=null) {
					return result;
				}
			}
			
			if(this.getData()==findValue) {
				return this;
			}
			
			if(rightNode!=null) {
				result = rightNode.midOrderSearch(findValue);
			}
			return result;
		}
		
		private Node postOrderSearch(int findValue) {
			Node result = null;
			if(leftNode!=null) {
				result = leftNode.postOrderSearch(findValue);
				if(result!=null) {
					return result;
				}
			}
			
			if(rightNode!=null) {
				result = rightNode.postOrderSearch(findValue);
				if(result!=null) {
					return result;
				}
			}
			
			if(this.getData()==findValue) {
				return this;
			}
			return null;
		}

		private void printNodeInfo() {
			System.out.println(this.getData());
		}
		
		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}

		
		@Override
		public String toString() {
			return "Node [data=" + data + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
		}
		
	}
	
}
