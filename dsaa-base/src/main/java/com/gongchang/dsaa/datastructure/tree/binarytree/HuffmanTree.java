package com.gongchang.dsaa.datastructure.tree.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * �����������ֽкշ��������������������Ŷ�������
 * 
 * 1.��������������n��Ȩֵ��Ϊn��Ҷ�ӽڵ㣬����һ�Ŷ�������ʹ�����Ĵ�Ȩ·�����ȴﵽ��С�����������ǹ�������
 * 2.�ڵ��·�����Ӹ��ڵ㵽��ĳ������ڵ��ͨ·����ĳ������ڵ��·��
 * 3.�ڵ��·�����ȣ����������ڵ�֮���·������Ϊ1���Ӹ��ڵ㵽Ҷ�ӽڵ��߹���·������֮�;��ǽڵ��·������
 * 4.�ڵ��Ȩ����ĳ���ڵ㸳��һ��ĳ�ֺ����ֵ�����ֵ���Ǹýڵ��Ȩ
 * 5.�ڵ�Ĵ�Ȩ·�����ȣ��ڵ��Ȩֵ*�ڵ�·������
 * 6.���Ĵ�Ȩ·�����ȣ�����Ҷ�ӽڵ�Ĵ�Ȩ·�����ȵĺͣ�����WPL��weighted path length��
 * 
 * ������1��6�е�������֪�����Ź���������ȨֵԽ��Ľڵ������ڵ�Խ����������������WPL��С����
 * 
 * ���ݲ�ͬ������ʽ��������ɵĹ������������ǲ�һ����
 * ����Ϊ��������Ľڵ��п��ܴ��ڴ�С��ͬ�Ľڵ㣬�������򷽷��Ĳ�ͬ�����ڵ��λ�ÿ��ܲ�һ������������Ҳ��һ������
 * ����WPL��һ���ģ�������Сֵ��
 * 
 * ����������������ͨѶ������ѹ������
 * 
 * @author GongChang
 *
 */
public class HuffmanTree {

	public static void main(String[] args) {
		int[] intArr = {1,3,2,7};
		HuffmanTree huffmanTree = new HuffmanTree();
		huffmanTree.buildHuffmanTree(intArr);
		huffmanTree.preOrderTraversal();
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
	
	private void buildHuffmanTree(int[] intArr) {
		List<Node> nodeList = new ArrayList<Node>();
		for (int i : intArr) {
			nodeList.add(new Node(i));
		}
		
		while(nodeList.size()>1) {
			Collections.sort(nodeList);
			
			Node leftNode = nodeList.get(0);
			Node rightNode = nodeList.get(1);
			Node parentNode = new Node(leftNode.getData()+rightNode.getData());
			parentNode.setLeftNode(leftNode);
			parentNode.setRightNode(rightNode);
			
			nodeList.remove(0);
			nodeList.remove(0);
			nodeList.add(parentNode);
		}
		
		setRoot(nodeList.get(0));
	}
	
	private class Node implements Comparable<Node>{

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
		public int compareTo(Node node) {
			return this.data-node.data;
		}
		
	}
}
