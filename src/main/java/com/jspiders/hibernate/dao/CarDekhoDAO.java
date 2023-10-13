package com.jspiders.hibernate.dao;
import java.util.Scanner;
public class CarDekhoDAO {
	//private static CarDekhoMenu =new CarDekhoMenu();
	private static boolean  loop=true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		CarOperations obj=new CarOperations();
		do
		{
			System.out.println("----------------------------------------------");
			System.out.println("*****welcome to the CarDekhoApplication*****");
			System.out.println("----------------------Menu--------------------\n1. Add a new Car Detail\n2. Delete a car\n3. Update car details\n4. Search\n5. Display\n6. Exit\n----------------------");
			System.out.println("Enter Your Choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Add a new Car:");
				obj.add();
				System.out.println("---------------------------------------------------");
			break;
			case 2:
				System.out.println("Delete car Record:");
				obj.delete();
				System.out.println("---------------------------------------------------");
			break;
			case 3:
				System.out.println("Update the Car Details:");
				obj.update();
				System.out.println("---------------------------------------------------");
			break;
			case 4:
				System.out.println("Search Car Detail:");
				System.out.println("---------------------------------------------------");
				obj.search();
				System.out.println("---------------------------------------------------");
			break;
			case 5:
				System.out.println("Display Car Details:");
				System.out.println("---------------------------------------------------");
				obj.displayAll();
				System.out.println("---------------------------------------------------");
			break;
			case 6:
				loop=false;
				System.out.println("Thank You...");
			break;
			default:
				System.out.println("Invalid Choice!!!");
				break;
			}
		}while(loop);
	}
}
