package com.jspiders.hibernate.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.jspiders.hibernate.dao.CarDekhoDAO;
import com.jspiders.hibernate.dto.CarInfo;
public class CarOperations {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("CarInfo");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	CarInfo c = new CarInfo();
	List<CarInfo> CarList = new ArrayList<CarInfo>();
	Scanner sc = new Scanner(System.in);
	// Add car details
	public void add() {
		openConnection();
		entityTransaction.begin();
		// Scanner sc=new Scanner(System.in);
		System.out.println("How many cars do you want to add?");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			CarInfo obj = new CarInfo();
			System.out.println("Enter Car Id: ");
			int c_id = sc.nextInt();
			obj.setC_id(c_id);
			System.out.println("Enter Car name: ");
			String c_name = sc.next();
			obj.setC_name(c_name);
			System.out.println("Enter Model: ");
			String model = sc.next();
			obj.setModel(model);
			System.out.println("Enter Brand of Car: ");
			String brand = sc.next();
			obj.setBrand(brand);
			System.out.println("Enter Fuel type: ");
			String fuel = sc.next();
			obj.setFuel(fuel);
			System.out.println("Enter price of car");
			Double price = sc.nextDouble();
			obj.setPrice(price);
			entityManager.persist(obj);
			System.out.println("Car info Added successfully");
		}
		entityTransaction.commit();
		closeConnection();
	}
	public void delete() {
		openConnection();
		entityTransaction.begin();
		System.out.println("Enter Car Id for Removing the car");
		int r_id = sc.nextInt();
		CarInfo car = entityManager.find(CarInfo.class, r_id);
		if (car != null) {
			entityManager.remove(car);
			System.out.println("Car info deleted.");
		} else {
			System.out.println("Car id does Not Exists!");
		}
		entityTransaction.commit();
		closeConnection();
	}
	public void update() {
		openConnection();
		entityTransaction.begin();
		System.out.println("Enter Car Id for Updating Record");
		int u_id = sc.nextInt();
		CarInfo car = entityManager.find(CarInfo.class, u_id);
		System.out.println("1.Update Name:/n2.Update Model:/n3.Update Brand:/4.Update Fuel:/n5.Update Price");
		System.out.println("Enter Your choice?");
		int ch = sc.nextInt();
		if (car != null) {
			switch (ch) {
			case 1:
				System.out.println("Enter New Car Name");
				car.setC_name(sc.next());
				break;
			case 2:
				System.out.println("Enter New Car Model");
				car.setModel(sc.next());
				break;
			case 3:
				System.out.println("Enter New Car Brand");
				car.setBrand(sc.next());
				break;
			case 4:
				System.out.println("Enter New Car Fuel");
				car.setFuel(sc.next());
				break;
			case 5:
				System.out.println("Enter New Car Price");
				car.setPrice(sc.nextDouble());
				break;
			default:
				System.out.println("Invalid Choice!");
				break;
			}
			entityManager.persist(car);
			System.out.println("Car info Updated Successfully");
		} else {
			System.out.println("Car id does Not Exists!");
		}
		entityTransaction.commit();
		closeConnection();
	}
	public void search() {
		openConnection();
		entityTransaction.begin();
		System.out.println("Enter Car Id for Searching Record");
		int u_id = sc.nextInt();
		CarInfo car = entityManager.find(CarInfo.class, u_id);
		if (car != null) {
			System.out.println("Id" + "\t" + "Name" + "\t" + "Model" + "\t" + "Brand" + "\t\t" + "Fuel" + "\t" + "Price");
			System.out.println(car.getC_id() + "\t" + car.getC_name() + "\t" + car.getModel() + "\t" + car.getBrand()
					+ "\t" + car.getFuel() + "\t" + car.getPrice());
		} else {
			System.out.println("Car info not Found!");
		}
		entityTransaction.commit();
		closeConnection();
	}
	public void displayAll() {
		openConnection();
		entityTransaction.begin();
//		Query query= entityManager.createQuery("SELECT car FROM car_info car");
//		@SuppressWarnings("unchecked")
//		List<CarInfo> carList=query.getResultList();
//		List<Car> carList=entityManager.createQuery("SELECT a FROM car_info a", Car.class).getResultList();

		Query query = entityManager.createQuery("SELECT c FROM CarInfo c", CarInfo.class);
//		        query.setParameter("modelName", modelName);
		@SuppressWarnings("unchecked")
		List<CarInfo> carList = query.getResultList();

		System.out.println("Id" + "\t" + "Name" + "\t" + "Model" + "\t" + "Brand" + "\t\t" + "Fuel" + "\t" + "Price");

		for (CarInfo car : carList) {
			System.out.println(car.getC_id() + "\t" + car.getC_name() + "\t" + car.getModel() + "\t" + car.getBrand()
					+ "\t" + car.getFuel() + "\t" + car.getPrice());
		}
		entityTransaction.commit();
		closeConnection();
	}
}