package test2;

public class BookDTO {
	private int isbn, price;
	private String title, author, pubblisher, detail;
		
	public BookDTO(int isbn, String title, String author, String publisher, int price, String detail){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pubblisher = publisher;
		this.price = price;
		this.detail = detail;
	}
	public String toString() {
		return isbn + "\tび" + title + "\tび" + author + "び" + pubblisher + "\tび" + price + "\tび" + detail ;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubblisher() {
		return pubblisher;
	}
	public void setPubblisher(String pubblisher) {
		this.pubblisher = pubblisher;
	}
	public String getDetail() {
		return detail;
	}
	public void setDesc(String detail) {
		this.detail = detail;
	}

}
