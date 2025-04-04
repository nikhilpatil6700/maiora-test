package com.maiora;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter hours");
		int hours = sc.nextInt();
		System.out.println("enter rate");
		int rate = sc.nextInt();
		calculateSalary(hours,rate);
	}
	
	public static void calculateSalary(int hours,int rate) {
		double salary=0;
		double finalSalary=0;
		if(hours<=160) {
			salary=hours*rate;
			finalSalary=salary-(salary*0.10);
		}
		else if(hours>160) {
			int extraHours=hours-160;
			double extraWorkSalary=rate*extraHours*1.5;
			salary=160*rate+extraWorkSalary;
			finalSalary=salary-(salary*0.10);			
		}
		
		System.out.println(finalSalary);
	}
}
