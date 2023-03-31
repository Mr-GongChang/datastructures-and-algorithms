package com.gongchang.dsaa.algorithm.sort;

import java.util.Arrays;

/**
 * ϣ�������ֽ�����С��������
 * 
 * �������ͣ��ڲ�����
 * 
 * ����˼�룺
 * 	���ֱ�Ӳ��������������Сֵ�ں��棬�ƶ�����������⡣
 * 	���磺����arr = {2,3,4,5,6,7,8,9,1}��
 * 	ĳһʱ�̵���������23456789�����������1��������Ҫ��������е�1���뵽������У��������ƶ�������ܴ�
 * 	������arr������������ǳ��������ƶ������Ŀ�����������ԡ�
 * 
 * ʱ�临�Ӷȣ�O(n^s)<1s<2
 * 
 * @author GongChang
 *
 */
public class ShellsSort {

	public static void main(String[] args) {
		int[] intArr = {1,3,56,-2,-2,-78,332,-2,42};
		
		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(intArr));
		
		shellsSort1(intArr);
//		shellsSort2(intArr);
		
		System.out.println("�����");
		System.out.println(Arrays.toString(intArr));
	}
	
	/**
	 * ������ʵ��ϣ������
	 * 
	 * @param intArr
	 */
	private static void shellsSort1(int[] intArr) {
		int tail = intArr.length-1;
		
		int gap = intArr.length/2;
		while(gap>0) {
			for(int i=gap; i<=tail; i++){
				for(int j=i; j-gap>=0; j-=gap) {
					if(intArr[j]<intArr[j-gap]) {
						// �������д��������˽������ĺ���
						int temp = intArr[j];
						intArr[j] = intArr[j-gap];
						intArr[j-gap] = temp;
					}
				}
			}
			gap = gap/2;
		}
	}
	
	/**
	 * �ƶ���ʵ��ϣ������
	 * 
	 * @param intArr
	 */
	private static void shellsSort2(int[] intArr) {
		int tail = intArr.length-1;
		
		int gap = intArr.length/2;
		while(gap>0) {
			for(int i=gap; i<=tail; i++){
				int insertValue = intArr[i];
				int insertIndex = i;
				for(int j=i; j-gap>=0; j-=gap) {
					if(intArr[j-gap]>insertValue) {
						intArr[j] = intArr[j-gap];
						insertIndex-=gap;
					}else {
						break;
					}
				}
				if(insertIndex!=i) {
					intArr[insertIndex] = insertValue;
				}
			}
			
			gap = gap/2;
		}
	}
	
}
