/**
 * Abigail Schafer S.I. 40094234
 * Comp 249
 * As1
 * Due Feb 1st 2019
 * @author Abby
 *
 */
public class Book {

	private String title; private String author; private long ISBN;private double price;
//	static int numBooks = 0;

/**
 * Basic Constructor
 * @param title String for title of this book
 * @param author String for author of this book
 * @param ISBN long for the ISBN number of the book
 * @param price double to contain the price of the book
 */
	public Book(String title, String author, long ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
//		numBooks++;
	}
/**
 * Default constructor
 */
	public Book () {
		title = "Unknown";
		author = "Unknown";
		ISBN = 0;
		price = 0;
//		numBooks++; 
	}

/**
 * Setter for Title
 * @param title to change/set the title of this book
 */
	
	public void setTitle(String title) {
		this.title = title;
	}

/**
 * Setter for Author
 * @param author to change/set the author of this book
 */
	
	public void setAuthor(String author) {
		this.author = author;
	}
/**
 * Setter for ISBN
 * @param ISBN to change/set ISBN of this book
 */
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
/**
 * Setter for price
 * @param price to change/set price
 */
	public void setPrice(double price) {
		this.price = price;
	}

/**
 * Getter for Title
 * @return Title
 */
	public String getTitle() {
		return title;
	}
/**
 * Getter for Author
 * @return author 
 */
	public String getAuthor() {
		return author;
	}
/**
 * Getter for ISBN
 * @return getter 
 */
	public long getISBN() {
		return ISBN;
	}
/**
 * Getter for Price
 * @return price
 */
	public double getPrice() {
		return price; 
	}
/**
 * toString with param. 
 * @param book
 * @return toString
 */
	public String toString(Book book) {
		return "\nAuthor: " + book.getAuthor() + 
				"\nTitle: " + book.getTitle() + "\nISBN: " + book.getISBN() +
				"\nPrice: " + book.getPrice();
	}
/**
 * To find number of created books
 * @param books Array to know which books to look amongst
 * @return the number of books which have been created 
 */
	static int findNumberOfCreatedBooks(Book[] books) {
		int numBooks = 0;
		for (int i = 0; i<books.length; i++) {
			if (books[i] != null)
				numBooks++;
		}
		return numBooks;
	}
/**
 * To determine the books which are cheaper than a certain price
 * @param price The max price
 * @param books The array of books to look amongst
 * @return the array of books which are cheaper than the given price
 */
	static Book[] findCheaperThan(double price, Book[] books) {
		int x = 0;
		int r = 0;
		for (int i = 0; i<books.length; i++) {
			if (books[i]!=null && books[i].getPrice() <= price)
				x++;
		}
		Book[] cheaperThan = new Book[x];
		for(int k = 0; k<books.length; k++) {
			if (books[k]!=null && books[k].getPrice() <= price) {
				cheaperThan[r] = books[k];
				r++;
			}
		}
		return cheaperThan; 
	}
/**
 * To check if two books are equal to one another.
 * @param otherBook
 * @return wheather or not the books are equal 
 */
	public boolean equals(Book otherBook) {
		if ((ISBN == otherBook.ISBN) & (price == otherBook.price)) 
			return true;
		else
			return false;
	}
}
