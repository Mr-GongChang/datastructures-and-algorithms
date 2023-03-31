package com.gongchang.dsaa.algorithm.sort;

import java.util.Arrays;

/**
 * ��������
 * 
 * �������ͣ��ڲ�����
 * 
 * ����˼�룺
 * 	������ֳ���������������֣���ʼ״̬�£��±�0������Ϊ���������һ���֣�ʣ�ڵĲ�����Ϊ���������һ����
 * 	����n��Ԫ�أ������n-1������
 * 	ÿһ�ִ����������ͷ��ȡһ��Ԫ�ز��뵽����������
 * 
 * ʱ�临�Ӷȣ�O(n2)
 * 
 * @author GongChang
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] intArr = {1,3,56,-2,-2,-78,332,-2,42};
		
		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(intArr));
		
		insertionSort1(intArr);
//		insertionSort2(intArr);
		
		System.out.println("�����");
		System.out.println(Arrays.toString(intArr));
	}
	
	/**
	 * ������ʵ�ֲ�������
	 * 
	 * @param intArr ����������
	 */
	private static void insertionSort1(int[] intArr) {
		int tail = intArr.length-1;
		for(int i=1; i<=tail; i++){
			for(int j=i; j-1>=0; j--) {
				if(intArr[j]<intArr[j-1]) {
					// �������д��������˽������ĺ���
					int temp = intArr[j];
					intArr[j] = intArr[j-1];
					intArr[j-1] = temp;
				}
			}
		}
	}
	
	/**
	 * �ƶ���ʵ�ֲ�������
	 * 
	 * @param intArr ����������
	 */
	private static void insertionSort2(int[] intArr) {
		int tail = intArr.length-1;
		for(int i=1; i<=tail; i++){
			int insertValue = intArr[i];
			int insertIndex = i;
			for(int j=i; j-1>=0; j--) {
				if(intArr[j-1]>insertValue) {
					intArr[j] = intArr[j-1];
					insertIndex--;
				}else {
					break;
				}
			}
			if(insertIndex!=i) {
				intArr[insertIndex] = insertValue;
			}
		}
	}
	
}
