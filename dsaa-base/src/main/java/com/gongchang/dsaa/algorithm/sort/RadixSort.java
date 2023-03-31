package com.gongchang.dsaa.algorithm.sort;

import java.util.Arrays;

/**
 * ��������
 * 
 * �������ͣ��ڲ�����
 * 
 * ����˼�룺
 * 	ȡ���������ֵ�ĳ��ȣ�maxLength����Ϊ�������������ĳ��ȣ�λ��������ǰ�油0��
 * 	�Ӹ�λ��ʼ������ֱ����λ����,һ������maxLength�Σ�
 * 	ÿ�α����У�
 * 		ѭ���������飬ȡ��ÿ��Ԫ�ض�Ӧλ���ϵ�ֵ��Ͱ�ĸ���ȡ�࣬�õ�Ͱ��������Ȼ��Ԫ�طŵ�Ͱ��
 * 		����ѭ�����֮���ٽ�Ͱ���Ԫ�طŻ�ԭ����
 * 
 * ʱ�临�Ӷȣ�O(n*k)��kΪͰ�ĸ���
 * 
 * @author GongChang
 *
 */
public class RadixSort {
	
	public static void main(String[] args) {
		int[] intArr = {1,3,56,2,2,78,332,2,42};
		
		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(intArr));
		
		int[] temp = new int[intArr.length];
		radixSort(intArr);
		
		System.out.println("�����");
		System.out.println(Arrays.toString(intArr));
	}
	
	private static void radixSort(int[] intArr) {
		// �ҵ�����������ֵ
		int max = intArr[0];
		for(int i=1; i<intArr.length; i++) {
			if(intArr[i]>max) {
				max=intArr[i];
			}
		}
		// ����Ͱ
		int[][] bucket = new int[10][intArr.length];
		int[] bucketEleCount = new int[10];
		// ��ȡ���ֵ�ĳ���
		int maxLength=(max+"").length();
		// �������
		for(int i=0,m=1; i<maxLength; i++,m*=10){
			// ��Ͱ
			for(int j=0; j<intArr.length; j++) {
				int bucketIndex = intArr[j]/m%10;
				bucket[bucketIndex][bucketEleCount[bucketIndex]++] = intArr[j];
			}
			// ���Ƶ�ԭ����
			int intArrIndex=0;
			for(int j=0; j<bucket.length; j++){
				if(bucketEleCount[j]>0) {
					for(int k=0; k<bucketEleCount[j]; k++) {
						intArr[intArrIndex++]=bucket[j][k];
					}
				}
				bucketEleCount[j]=0;
			}
		}
		
	}
	
}
