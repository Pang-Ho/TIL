package test2;

public class BookDTO {
	private int isbn, price;
	private String title, author, pubblisher, desc;
		
	public BookDTO(int isbn, String title, String author, String publisher, int price, String desc){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pubblisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	public String toString() {
		return isbn + "\tび" + title + "\tび" + author + "び" + pubblisher + "\tび" + price + "\tび" + desc ;
	}

}
