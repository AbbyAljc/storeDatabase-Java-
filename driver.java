/**
 * Abigail Schafer S.I. 40094234
 * Comp 249
 * As1
 * Due Feb 1st 2019
 * @author Abby
 *
 *This program creates a platform for someone to input an inventory of their library, and then be able to search through it by
 *price or author, also allowing to add books any time and to change information for a book at any given time. It is password 
 *protected and will sign you out if it suspects you of suspicious behaviour. 
 *
 */	

import java.util.Scanner;

	/**
	 * driver class
	 * @author Abby
	 *
	 */
	public class driver {
	
		public static void main(String[] args) {
			
			Scanner kb = new Scanner(System.in);
			String password = "password";
			int c1 = 0;
			boolean c2 = true;
			Book[] inventory; 
			
			
	/** Larger do while loop for the 4 chances you get to enter your password case 1
	 * 	
	 */
			
	do {
			System.out.println("Welcome to Abigail's Software, bookstore owner! \nPlease enter the maximum amount of books your store can contain:");
			
			int maxBooks = kb.nextInt();
			
			inventory = new Book[maxBooks]; 
			
			
	/** 
	 * do while loop for case 2
	 */
		do {
			System.out.println("\nWhat do you want to do? \n\t 1. Enter new books (password required)\n\t 2. Change information of a "
					+ "book (password required)\n\t 3. Display all books by a specific author\n\t 4. Display all books under a certain a price.\n\t 5. Quit\nPlease enter your choice >");
			
			int userIn1 = kb.nextInt();
			
	/**
	 * Switch statement for the 5 different options the user gets
	 */
			
			switch(userIn1) {
	/**
	 * I've made the program return to main menu after case one, so we can play around with the created
	 * inventory	
	 */
			case 1:{
				c2= false;
				int x = 0;
				String userIn2 = null; 
	
	/**
	* Small do while loop for the first three password entry tries
	*/
				do {
				System.out.println("Please enter password: ");
				userIn2 = kb.next();
				if (userIn2.equalsIgnoreCase(password) == false) {
					if (x<2) {
						System.out.println("\nSorry, wrong password. Try again!");
						x++;
					}
					else if (x==2 & c1 < 3) {
						System.out.println("Sorry, back to home page!\n\n");
							x++;
						}
					else if (x==2 & c1==3) {
						System.out.println("\nProgram detected suspicious activities and will terminate immediately!");
						c2 = true; 
						x++;
					}
				} 
				
					} while (userIn2.equals(password) == false && x<3);
	
	/**
	 * if statement encompassing the entry of chosen number of books
	 */
				if (userIn2.equalsIgnoreCase(password)) {
					System.out.println("How many books do you want to enter?");
					
					
					int numToEnter = kb.nextInt();
					
					
					if (numToEnter < (inventory.length - Book.findNumberOfCreatedBooks(inventory))) {
						for (int i = 1; i<=numToEnter; i++) {
							int k = 0;
		/**
		 * Boolean to indicate we've found an open slot and filled it
		 */
							boolean full = false;
					do { 
						if (inventory[k] == null) {
							inventory[k] = new Book();
							System.out.println("\nFor book #" + (Book.findNumberOfCreatedBooks(inventory)) + "\n\nEnter title: \n");
							kb.nextLine();
							inventory[k].setTitle(kb.nextLine());
							System.out.println("\nEnter author: ");
							inventory[k].setAuthor(kb.nextLine());
							System.out.println("\nEnter ISBN: ");
							inventory[k].setISBN(kb.nextInt());
							System.out.println("\nEnter price: ");
							inventory[k].setPrice(kb.nextDouble());
							
							System.out.println(inventory[k].toString(inventory[k]));
							
							full = true;
							}
							else k++;
						
						} while (full ==false);
						}		
				}
					else
						System.out.println("Sorry, there are only " + (inventory.length -Book.findNumberOfCreatedBooks(inventory)) + " spots left in your library./n");
					break;
				}
			else {
				c1++;
				break;
				}	
			}
		
			case 2:{
	/**
	 * Counter for starting over at main menu after three incorrect passwords
	 */
				int x = 0;
				String userIn2 = null; 
				int choice;
	
	/**
	* Small do while loop for the first three password entry tries
	*/
				do {
				System.out.println("Please enter password: ");
				userIn2 = kb.next();
				if (userIn2.equals(password) == false & x<2)
					System.out.println("\nSorry, wrong password. Try again!");
				else if (userIn2.equals(password) == false & x==2)
					System.out.println("Sorry, back to home page!\n\n");
				x++; } while (userIn2.equals(password) == false && x <3);
				
	/**
	 * if statement for right password
	 * else returns to home page
	 * 
	 * 
	 */
				boolean validIn;
				do {
				if (userIn2.equals(password)) {	
					c2 = true;
					System.out.println("What book would you like to update? Please enter its number, starting at 1:");
					int userIn = kb.nextInt()-1;
					if (userIn < inventory.length & inventory[userIn] != null) {
						System.out.println("Book # " + userIn+1 + "\nAuthor: " + inventory[userIn].getAuthor() + 
							"\nTitle: " + inventory[userIn].getTitle() + "\nISBN: " + inventory[userIn].getISBN() +
							"\nPrice: " + inventory[userIn].getPrice());
					/**
					 * Switch statement for the new menu
					 */
						do {
						System.out.println("\nWhat information would you like to change?\n\t1.\tauthor\n\t2.\ttitle\n\t3.\tISBN"
								+ "\n\t4.\tprice\n\t5.\tQuit\nEnter your choice >\n");
						choice = kb.nextInt();
						
						switch (choice){
						case 1: {
						System.out.println("Enter new author here:");
						kb.nextLine();
							inventory[userIn].setAuthor(kb.nextLine());
						System.out.println("Book # " + (userIn+1) + "\nAuthor: " + inventory[userIn].getAuthor() + 
								"\nTitle: " + inventory[userIn].getTitle() + "\nISBN: " + inventory[userIn].getISBN() +
								"\nPrice: " + inventory[userIn].getPrice());
								break;
						}
						case 2:{
							System.out.println("Enter new title here:");
							kb.nextLine();
							inventory[userIn].setTitle(kb.nextLine());
							System.out.println("Book # " + (userIn+1) + "\nAuthor: " + inventory[userIn].getAuthor() + 
									"\nTitle: " + inventory[userIn].getTitle() + "\nISBN: " + inventory[userIn].getISBN() +
									"\nPrice: " + inventory[userIn].getPrice());
							break;
						}
						case 3: {
							System.out.println("Enter new ISBN here:");
							inventory[userIn].setISBN(kb.nextLong());
							System.out.println("Book # " + (userIn+1) + "\nAuthor: " + inventory[userIn].getAuthor() + 
									"\nTitle: " + inventory[userIn].getTitle() + "\nISBN: " + inventory[userIn].getISBN() +
									"\nPrice: " + inventory[userIn].getPrice());
							c2 = false;
							break;
						}
						case 4: {
							System.out.println("Enter new price here:");
							inventory[userIn].setPrice(kb.nextDouble());
							System.out.println("Book # " + (userIn+1) + "\nAuthor: " + inventory[userIn].getAuthor() + 
									"\nTitle: " + inventory[userIn].getTitle() + "\nISBN: " + inventory[userIn].getISBN() +
									"\nPrice: " + inventory[userIn].getPrice());
							break;
						}
						case 5: {
							c2 = false;
							break;
								}
						default: {
							System.out.println("Not one of the options! Try again.");
						}
							}
						}while (choice!=5);
						validIn = true;
					}
					else {
						System.out.println("Try a different book.");
						validIn=false;
						}
				} 
				else {
					c2 = false;
					break;
				}
				}while (validIn == false);
			
				break;
			} 
	/**
	 * Since it's only used once, I elected not to create a method. I scanned through and created a counter, to check
	 * how big the array of books with said author should be, and then I ran through and added the books, then printed the array. 
	 */
			case 3: {
				System.out.println("Please enter the name of the author you would like to search:");
				kb.nextLine();
				String userIn = kb.nextLine();
				int x = 0;
				for (int i = 0; i<inventory.length; i++) {
					if(inventory[i]!=null && inventory[i].getAuthor().equalsIgnoreCase(userIn))
						x++;
				}
				Book[] byAuthor = new Book[x];
				int k=0;
				for (int i = 0; i<inventory.length; i++) {
					if (inventory[i]!=null && inventory[i].getAuthor().equals(userIn)) {
					byAuthor[k] = inventory[i];
					k++;	
					}
				}
				
				for (int i = 0; i<byAuthor.length;i++) {
					System.out.println(byAuthor[i].toString(byAuthor[i]));
				}
				break;
			}
	/**
	 * for case four it doesn't specify if I need to display all information. However, I could have 
	 * potentially printed the toString(). I chose to only print the author and title.		
	 */
			case 4: {
				System.out.println("Enter your max price:");
				double maxPrice = kb.nextDouble();
				Book[] cheap = Book.findCheaperThan(maxPrice, inventory);
				System.out.println("\nBooks within this budget:\n");
				for(int i = 0; i<cheap.length;i++) {
					System.out.println(cheap[i].toString(cheap[i]));}
				break;
			}
			case 5:{
				System.out.println("Thank you for visiting!");
				c2 = true;
				c1 = 5;
				break;
			}
			default: System.out.println("That was not one of the options.");
			}
		} while (c2 == false);	
	} while (c1<4);
	
	kb.close();
	}
	}
	 