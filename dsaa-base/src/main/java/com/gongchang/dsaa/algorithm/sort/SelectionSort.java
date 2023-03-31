package com.gongchang.dsaa.algorithm.sort;

import java.util.Arrays;


/**
 * ѡ������
 * 
 * �������ͣ��ڲ�����
 * 
 * ����˼�룺
 * 	����n��Ԫ�أ������n-1������
 * 	ÿһ�������н�����ֵ�ƶ������뱾������������β��
 * 
 * ʱ�临�Ӷ�O(n2)
 * 
 * @author GongChang
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] intArr = {1,3,56,-2,-2,-78,332,-2,42};
		
		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(intArr));
		
		selectionSort1(intArr);
		selectionSort2(intArr);
		
		System.out.println("�����");
		System.out.println(Arrays.toString(intArr));
	}
	
	/**
	 * ����ʵ��ѡ������
	 * 
	 * @param intArr ����������
	 */
	private static void selectionSort1(int[] intArr){
		int tail = intArr.length-1;
		for(int i=0; i<=tail-1; i++) {
			int subTail = tail-i;
			int maxIndex = 0;
			for(int j=1; j<=tail-i; j++) {
				if(intArr[j]>intArr[maxIndex]) {
					maxIndex = j;
				}
			}
			// �����Ż����ܣ�������ֵ�����ڱ��������β�����򲻽��н��������¿�ʼ��һ��ѭ�����ɣ����򽻻�λ��
			if(maxIndex!=subTail) {
				int temp = intArr[maxIndex];
				intArr[maxIndex] = intArr[subTail];
				intArr[subTail] = temp;
			}
		}
	}
	
	/**
	 * ǰ��ʵ��ѡ������
	 * 
	 * @param intArr ����������
	 */
	private static void selectionSort2(int[] intArr) {
		int tail = intArr.length-1;
		for(int i=0; i<=tail; i++) {
			int minIndex = i;
			for(int j=i+1; j<=tail; j++) {
				if(intArr[j]<intArr[minIndex]) {
					minIndex = j;
				}
			}
			if(minIndex!=i) {
				int temp = intArr[minIndex];
				intArr[minIndex] = intArr[i];
				intArr[i] = temp;
			}
		}
	}
	
}
