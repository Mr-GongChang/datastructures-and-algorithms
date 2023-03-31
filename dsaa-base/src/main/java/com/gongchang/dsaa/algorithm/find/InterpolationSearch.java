package com.gongchang.dsaa.algorithm.find;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��ֵ���� ��ֵ���Ҹ��ʺϷֲ��ȽϾ��ȵ�����
 * 
 * ��ֵ��������ֲ��ҵĲ�֮ͬ������ϵ�����ˣ���1/2�����(findValue-arr[left])/(arr[right]-arr[left])
 * 
 * ���ֲ��ҵ�mid���㷽ʽ�ǣ�int mid = left + 1/2 * (right-left); 
 * ��ֵ���ҵ�mid���㷽ʽ�ǣ�int mid = left + (findValue-arr[left])/(arr[right]-arr[left])* (right-left);
 * 
 * @author GongChang
 *
 */
public class InterpolationSearch {

	public static void main(String[] args) {

		Integer[] intArr = { 1, 3, 2, 55, 42, -23, 24, -78 };

		System.out.println("����ǰ�����飺");
		arrPrint(intArr);
		arrSort(intArr);
		System.out.println("���������飺");
		arrPrint(intArr);

		int findValue = 42;
		interpolationSearch(intArr, findValue, MethodInvokeType.RECURSION);
		interpolationSearch(intArr, findValue, MethodInvokeType.LOOP);

	}

	private enum MethodInvokeType {
		RECURSION,

		LOOP;
	}

	private static void interpolationSearch(Integer[] intArr, Integer findValue, MethodInvokeType methodInvokeType) {
		System.out.println("���ҷ�ʽΪ��" + methodInvokeType.name());
		System.out.println("���ҵ������ǣ�" + findValue);

		int index = -1;
		switch (methodInvokeType) {
		case RECURSION:
			index = recursionBinarySearch(intArr, 0, intArr.length - 1, findValue);
			break;
		case LOOP:
			index = loopBinarySearch(intArr, 0, intArr.length - 1, findValue);
			break;
		default:
			System.out.println("��δʵ�ֵĲ��ҷ�ʽ");
			return;
		}

		if (index != -1) {
			System.out.println("�����������ݶ�Ӧ���±�Ϊ��" + index);
		} else {
			System.out.println("û����������Ӧ������");
		}
	}

	private static void arrSort(Integer[] intArr) {
		Arrays.sort(intArr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return 1;
				} else if (o1 < o2) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	private static void arrPrint(Integer[] arr) {
		System.out.println("�����ӡ��ʼ===>");
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i]);
			if (i < length - 1) {
				System.out.print(",");
			} else {
				System.out.println();
			}
		}
		System.out.println("�����ӡ���===<");
		System.out.println();
	}

	private static int recursionBinarySearch(Integer[] arr, int left, int right, int findValue) {
		// �����findValue < arr[left] || findValue > arr[right]����ʡ�ԣ�������±�Խ��
		// ��Ϊ���û���������ж�(findValue - arr[left]) / (arr[right] - arr[left])���ܻ����1���������յ�mid���������±�
		if (left > right || findValue < arr[left] || findValue > arr[right]) {
			return -1;
		}

		int mid = left + (findValue - arr[left]) / (arr[right] - arr[left]) * (right - left);
		if (arr[mid] < findValue) {
			return recursionBinarySearch(arr, mid + 1, right, findValue);
		} else if (arr[mid] > findValue) {
			return recursionBinarySearch(arr, left, mid - 1, findValue);
		} else {
			return mid;
		}
	}

	private static int loopBinarySearch(Integer[] arr, int left, int right, int findValue) {
		// �����findValue < arr[left] || findValue > arr[right]����ʡ�ԣ�������±�Խ��
		// ��Ϊ���û���������ж�(findValue - arr[left]) / (arr[right] - arr[left])���ܻ����1���������յ�mid���������±�
		if (findValue < arr[left] || findValue > arr[right]) {
			return -1;
		}

		while (left <= right) {
			int mid = left + (findValue - arr[left]) / (arr[right] - arr[left]) * (right - left);
			if (arr[mid] < findValue) {
				left = mid + 1;
			} else if (arr[mid] > findValue) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
