package com.gongchang.dsaa.algorithm.sort;

import java.util.Arrays;

/**
 * ������
 * 
 * �������ͣ��ڲ�����
 * 
 * ����˼�룺
 * 	ѭ��n�Σ�ÿ�ι���һ���ѣ�Ȼ�󽫶Ѷ���Ԫ�غ�β��δ���������Ԫ�ؽ���
 * 	�Ӵ�С����͹����󶥶ѣ�ÿ�ν��Ѷ���Ԫ�������ƶ�
 * 	��С��������͹���С���ѣ�ÿ�ν��Ѷ���Ԫ�������ƶ�
 * 
 * ʱ�临�Ӷȣ�O(nlogn)
 * 
 * @author GongChang
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] intArr = {1,5,2,7,8};
		System.out.println("=======================ԭ����");
		System.out.println(Arrays.toString(intArr));
		
		HeapSort heapSort = new HeapSort();
		
		heapSort.heapSort(intArr, true);
		System.out.println("=======================�Ӵ�С����");
		System.out.println(Arrays.toString(intArr));
		
		heapSort.heapSort(intArr, false);
		System.out.println("=======================��С��������");
		System.out.println(Arrays.toString(intArr));
	}
	
	/**
	 * �����򷽷�
	 * 
	 * @param intArr ����������
	 * @param bool true-�Ӵ�С�� false-��С����
	 */
	private void heapSort(int[] intArr, Boolean bool) {
		if(bool) {
			buildBigTopHeap(intArr);
			for(int i=intArr.length-1; i>0; i--) {
				int temp = intArr[i];
				intArr[i] = intArr[0];
				intArr[0] = temp;
				buildBigTopHeap(intArr, 0, i);
			}
		}else {
			buildSmallTopHeap(intArr);
			for(int i=intArr.length-1; i>0; i--) {
				int temp = intArr[i];
				intArr[i] = intArr[0];
				intArr[0] = temp;
				buildSmallTopHeap(intArr, 0, i);
			}
		}
	}
	
	private void buildBigTopHeap(int[] intArr) {
		int intArrLength = intArr.length;
		for(int i=intArrLength/2-1; i>=0; i--) {
			buildBigTopHeap(intArr, i, intArrLength);
		}
	}
	
	private void buildBigTopHeap(int[] intArr, int startIndex, int arrLength) {
		int temp = intArr[startIndex];
		for(int m=2*startIndex+1; m<arrLength; m=2*m+1) {
			// �Ƚ����ҽڵ�Ĵ�С��ѡ���ϴ��
			if(m+1<arrLength&&intArr[m]<intArr[m+1]) {
				m=m+1;
			}
			// �����÷���ʱ��˵�ֵ�Ƚϣ������������ƣ���С�ڵ�����˵���ҵ��˶���ֵ����ʵλ�ã�����ѭ��
			if(temp<intArr[m]) {
				intArr[startIndex] = intArr[m];
				startIndex = m;
			}else {
				break;
			}
		}
		// �����˵�ֵ���Ƶ���ȷ��λ����
		intArr[startIndex] = temp;
	}
	
	private void buildSmallTopHeap(int[] intArr) {
		int intArrLength = intArr.length;
		for(int i=intArrLength/2-1; i>=0; i--) {
			buildSmallTopHeap(intArr, i, intArrLength);
		}
	}
	
	private void buildSmallTopHeap(int[] intArr, int startIndex, int arrLength) {
		int temp = intArr[startIndex];
		for(int m=2*startIndex+1; m<arrLength; m=2*m+1) {
			// �Ƚ����ҽڵ�Ĵ�С��ѡ����С��
			if(m+1<arrLength&&intArr[m]>intArr[m+1]) {
				m=m+1;
			}
			// �����÷���ʱ��˵�ֵ�Ƚϣ���С�������ƣ������ڵ�����˵���ҵ��˶���ֵ����ʵλ�ã�����ѭ��
			if(temp>intArr[m]) {
				intArr[startIndex] = intArr[m];
				startIndex = m;
			}else {
				break;
			}
		}
		// �����˵�ֵ���Ƶ���ȷ��λ����
		intArr[startIndex] = temp;
	}
	
}
