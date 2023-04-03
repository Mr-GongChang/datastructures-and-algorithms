package com.gongchang.dsaa.datastructure.tree.binarytree;

import java.util.Arrays;

/**
 * �������ǿ���ʹ����������ʾ�ģ�һ�Ŷ��������մ��ϵ��£������ҵ�˳���ʶ�������е���������ô�������¹���
 * ���ڵ������Ϊiʱ�����ӽڵ�������ǣ�2*i+1�����ӽڵ�������ǣ�2*i+2
 * ע�������±��0��ʼ����
 * 
 * ����һ����ȫ������
 * 
 * �ѹ����߼��������һ����Ҷ�ӽڵ㿪ʼ�������������¶��ϣ����һ����Ҷ�ӽڵ���±��ǣ�intArr.length/2-1
 * 
 * �󶥶ѣ����ڵ��ֵ���ڵ����ӽڵ��ֵ
 * С���ѣ����ڵ��ֵС�ڵ����ӽڵ��ֵ
 * 
 * 
 * @author GongChang
 *
 */
public class Heap {

	public static void main(String[] args) {
		int[] intArr = {1,5,2,7,8};
		System.out.println("=======================ԭ����");
		System.out.println(Arrays.toString(intArr));
		
		Heap bigOrSmallTopHeap = new Heap();
		
		bigOrSmallTopHeap.buildBigTopHeap(intArr);
		System.out.println("=======================�󶥶�");
		System.out.println(Arrays.toString(intArr));
		
		bigOrSmallTopHeap.buildSmallTopHeap(intArr);
		System.out.println("=======================С����");
		System.out.println(Arrays.toString(intArr));
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
