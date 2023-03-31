package com.gongchang.dsaa.algorithm.sort;

import java.util.Arrays;

/**
 * ��������
 * 
 * �������ͣ��ڲ�����
 * 
 * ����˼�룺
 * 	��һ������ͨ��һ���м�λ�õ�ֵmidValue�ֳ����������֣�����ν���
 * 	ÿ�ν����Ǵ���߲��ֵ������ҵ�һ�����ڵ���midValue��ֵ�����ұ߲��ֵ������ҵ�һ��С�ڵ���midValue��ֵ�����ҵ�������ֵ����
 * 	������ν���֮��midValue��ߵĶ��Ǵ��ڵ�������ֵ��midValue�ұߵĶ���С�ڵ�������ֵ
 * 
 * 	Ȼ����������������ֱ���Ϊ�µ��������ִ������Ĳ�����֪�����鲻���ٷ�
 * 
 * ʱ�临�Ӷȣ�O(n2)
 * 
 * @author GongChang
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] intArr = {1,3,56,-2,-2,-78,332,-2,42};
		
		System.out.println("����ǰ��");
		System.out.println(Arrays.toString(intArr));
		
		quickSort1(intArr, 0, intArr.length-1);
		
		System.out.println("�����");
		System.out.println(Arrays.toString(intArr));
	}
	
	private static void quickSort1(int[] intArr, int left, int right) {
		if(left==right) {
			return;
		}
		
		int midValue = intArr[left+(right-left)/2];
		int start = left;
		int end = right;
		while(start<end) {
			while(intArr[start]<midValue) {
				start++;
			}
			while(intArr[end]>midValue) {
				end--;
			}
			
			if(start==end) {
				break;
			}
			
			if(intArr[start]!=intArr[end]) {
				int temp = intArr[end];
				intArr[end] = intArr[start];
				intArr[start] = temp;
			}
			
			if(intArr[start]==midValue) {
				end--;
			}
			if(intArr[end]==midValue) {
				start++;
			}
		}
		
		if(left<end) {
			quickSort1(intArr, left, end-1);
		}
		if(right>start) {
			quickSort1(intArr, start+1, right);
		}
	}
	
}
