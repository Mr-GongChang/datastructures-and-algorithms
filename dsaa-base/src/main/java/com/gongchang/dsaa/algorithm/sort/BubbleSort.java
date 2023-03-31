package com.gongchang.dsaa.algorithm.sort;

import java.util.Arrays;

/**
 * ð������
 * 
 * �������ͣ��ڲ�����
 * 
 * ����˼�룺
 * 	����n��Ԫ�أ������n-1������
 * 	ÿһ�������У�������ͷ����ʼ�Ƚ���������Ԫ�صĴ�С�����ϴ��ֵ���󻻣�����ÿ�����򶼻�ѱ�����������ֵ���������ֲ�����������������
 * 	ע�⣺ÿ�������в�������������С = ���������в�������������С-1
 * 
 * ʱ�临�Ӷ�O(n2)
 * 
 * @author GongChang
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] intArr = {1,3,56,-2,-2,-78,332,-2,42};
		
		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(intArr));
		
		bubbleSort(intArr);
		
		System.out.println("�����");
		System.out.println(Arrays.toString(intArr));
		
	}
	
	private static void bubbleSort(int[] intArr) {
		int temp;
		int tail = intArr.length-1;
		for(int i=0; i<=tail-1; i++) {
			Boolean isComplete = true;
			for(int j=0; j<tail-i; j++) {
				if(intArr[j]>intArr[j+1]) {
					temp = intArr[j];
					intArr[j] = intArr[j+1];
					intArr[j+1] = temp;
					
					isComplete = false;
				}
			}
			// �Ż�������������Ѿ�������ľͲ����ٽ�����һ��ѭ����
			if(isComplete){
				return;
			}
		}
	}
	
}
