package com.gongchang.dsaa.algorithm.recursion;

/**
 * �ݹ�
 * 
 * �ݹ�����ڷ����е��÷���������ջ�����������ʹ�õݹ���Ǵ����ü��
 * ʹ�õĵݹ�ĵط��кܶ࣬���磺��������ϣ�����򣬹鲢���򣬶��ֲ��ң���ӡ���⣬�׳����⣬��ŵ�����⣬�˻ʺ��
 * �ݹ�������ŵݹ��˳��������ƽ���������������ڴ����
 * 
 * @author zhangjifu
 *
 */
public class Recursion {

	public static void main(String[] args) {
		Recursion recursion = new Recursion();
		recursion.recursion(10);
	}
	
	public void recursion(int value){
		// �ݹ��˳�����
		if(value<=0){
			System.out.println("==============");
			return;
		}
		
		value--;
		System.out.println(value);
		
		recursion(value);
		
		System.out.println(value);
	}
}
