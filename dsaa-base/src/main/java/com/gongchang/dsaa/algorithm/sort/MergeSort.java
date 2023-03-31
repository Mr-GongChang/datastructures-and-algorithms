package com.gongchang.dsaa.algorithm.sort;

import java.util.Arrays;

/**
 * �鲢����
 * 
 * �������ͣ��ڲ�����
 * 
 * ����˼�룺
 * 	����˼��+��·�鲢
 * 
 * 	ʲô����·�鲢�����������������飨�����򣩣��ֱ������ȡ��һ��ֵ���Ƚϴ�С���ĸ�ֵС�ͽ��ĸ�ֵ�ŵ��������ǰ�棬Ȼ���ƶ�СԪ�������ָ��
 * 	
 * 	�֣��鲢����ĺ����ǲ���鲢��������붼������ģ�Ϊ��ʵ�����Ŀ�ģ���ԭʼ����ݹ��ֳ�ֻ����һ��Ԫ�ص����飬ֻ����һ��Ԫ��
 * 	�Σ��ӵݹ��˳���ʼ���ݣ�ÿ����һ��ִ��һ����·�鲢��Ȼ�󽫹鲢��Ľ�����Ƶ�ԭ�����Ӧ������
 * 
 * ʱ�临�Ӷȣ�O(nlogn)
 * 
 * @author GongChang
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] intArr = {1,3,56,-2,-2,-78,332,-2,42};
		
		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(intArr));
		
		int[] temp = new int[intArr.length];
		mergeSort(intArr, 0, intArr.length-1, temp);
		
		System.out.println("�����");
		System.out.println(Arrays.toString(intArr));
	}
	
	private static void mergeSort(int[] intArr, int left, int right, int[] temp) {
		// �ݹ��˳�����
		if(left==right) {
			return;
		}
		// ��
		int midIndex = left+(right-left)/2;
		mergeSort(intArr, left, midIndex, temp);
		mergeSort(intArr, midIndex+1, right, temp);
		
		// ��
		int tempIndex = 0;
		int leftStart = left;
		int rightStart = midIndex+1;
		while(leftStart<=midIndex&&rightStart<=right) {
			if(intArr[leftStart]<intArr[rightStart]) {
				temp[tempIndex++]=intArr[leftStart++];
			}else {
				temp[tempIndex++]=intArr[rightStart++];
			}
		}
		while(leftStart<=midIndex) {
			temp[tempIndex++]=intArr[leftStart++];
		}
		while(rightStart<=right) {
			temp[tempIndex++]=intArr[rightStart++];
		}
		for(int i=left,j=0; i<=right; i++,j++) {
			intArr[i] = temp[j];
		}
	}
}
