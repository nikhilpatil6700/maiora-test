package com.maiora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


//foodItem class
class FoodItem{
	private int id;
	private String foodName;
	private double price;
	
	public FoodItem() {
		
	}
	
	
	public FoodItem(int id, String foodName, double price) {
		
		this.id = id;
		this.foodName = foodName;
		this.price = price;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "FoodMenu [id=" + id + ", foodName=" + foodName + ", price=" + price + "]";
	}
	
}

//menu class
class Menu{
	
	private HashMap<Integer,FoodItem> foodItem=new HashMap<Integer, FoodItem>();

	public Menu(){
		
	}
	
	public Menu(HashMap<Integer, FoodItem> foodMenu) {
		
		this.foodItem = foodMenu;
	}


	public HashMap<Integer, FoodItem> getFoodMenu() {
		return foodItem;
	}

	public void setFoodMenu(HashMap<Integer, FoodItem> foodMenu) {
		this.foodItem = foodMenu;
	}

	//add food to menu
	public void addFood(FoodItem food) {
		foodItem.put(food.getId(),food);
		System.out.println("food added successfully");
	}
	
	//display menu
	public void displayMenu() {
		
		
		if(foodItem.isEmpty()) {
			System.out.println("food not available");
		}else {
			System.out.println("Food list:-");
			for (FoodItem item : foodItem.values()) {
				System.out.println(item);
			}

		}
	}
	
	
	//get food by id
	public FoodItem getFoodById(int id) {
		FoodItem food = foodItem.get(id);
		return food;
	}
	
}

//add to Cart class
class Cart{
	List<FoodItem> foodList=new ArrayList<>();
	FoodItem item;
	
	public Cart() {
	
	}
	
	public List<FoodItem> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<FoodItem> foodList) {
		this.foodList = foodList;
	}



	public FoodItem getItem() {
		return item;
	}



	public void setItem(FoodItem item) {
		this.item = item;
	}



	public Cart(List<FoodItem> foodList, FoodItem item) {
		this.foodList = foodList;
		this.item = item;
	}

	//add foods to cart
	public void addFoodToCart(FoodItem foodItem) {
		System.out.println("enter food id to add your cart");
		foodList.add(foodItem);
		System.out.println("added successfully!!");
	}
	
	//show cart food
	public void displayCart() {
		for (FoodItem foodItem : foodList) {
			System.out.println(foodItem);
		}
	}
}

//order class
class Order{
	
	private List<Cart> foodItem= new ArrayList<>();

	public Order() {
		
	}
		
	public Order(List<Cart> foodItem) {
		this.foodItem = foodItem;
	}
	
	public List<Cart> getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(List<Cart> foodItem) {
		this.foodItem = foodItem;
	}

	//adding food to order
	public void addfoodToOrder(Cart cart) {
		if(cart!=null) {
		foodItem.add(cart);
		System.out.println("food ordered!!");
		}
		else {
			System.out.println("not found");
		}
	}
	
	
	// displaying full summary
	public void displaySummary() {
		if(!foodItem.isEmpty()) {
			double totalPrice=0;
			double finalPrice=0;
			for(Cart cart:foodItem)
			for (FoodItem item: cart.getFoodList()) {
				 double perFoodPrice = item.getPrice();
				System.out.println("food: "+ item.getFoodName()+" "+ "price: "+perFoodPrice);
				
				
				totalPrice=totalPrice+perFoodPrice;
				finalPrice= totalPrice+(totalPrice*23)/100;
			}
			System.out.println("bill:- "+ totalPrice+" || gst:- 18% || delevery tax:- 5%");
			System.out.println("final bill: " +finalPrice);
		}
		else {
			System.out.println("food not ordered, please order your food!!");
		}
	}
	
	public void feedback() {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter your feedback here-");
		String message = sc.nextLine();
		//System.out.println(message);
		System.out.println("thank you for your feedback!!");
	}
	

}

//main method class
public class FoodPortal {

	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("welcome to FoodPortal app!!");
		
		Menu menu=new Menu();
		Order order=new Order();
		Cart cart=new Cart();
		int choice;
		do {
			
			System.out.println("enter 1 to add food");
			System.out.println("enter 2 to display food");
			System.out.println("enter 3 for add to cart");
			System.out.println("enter 4 to show carts item");
			System.out.println("enter 5 to order food");
			System.out.println("enter 6 to show order details");
			System.out.println("enter 7 to feedback");
			System.out.println("enter 0 to exist");
			choice=sc.nextInt();
			
			switch (choice) {
			//add food 
			case 1: {
				System.out.println("enter food id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("enter food name");
				String foodname = sc.nextLine();
				System.out.println("enter food price");
				double price = sc.nextDouble();
				FoodItem foodItem=new FoodItem(id, foodname, price);
				menu.addFood(foodItem);
				break;
			}
			
			//display menu 
			case 2: {
				menu.displayMenu();
				break;
			}
		
			
			//order food by id
			case 3: {
				System.out.println("enter food id to add food in to cart");
				int id = sc.nextInt();
				FoodItem food = menu.getFoodById(id);
				cart.addFoodToCart(food);
				break;
			}
			
			case 4:{
				cart.displayCart();
				break;
			}
			
			case 5:{
				
				order.addfoodToOrder(cart);
				break;
			}
			
			//displaying overall summary
			case 6: {
				
				order.displaySummary();
				break;
			}
			
			case 7:{
				order.feedback();
				break;
			}
			
			default:
				 System.out.println("thank you for coming :)");
			}
			
			
		} while (choice!=0);
	}
	
}


