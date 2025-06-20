package q2;

interface printable {
	default void print() {
		
	}
}
class book implements printable {
	String book; 
	String author ;
	int issueNumber ; 
	
	 public void print() {
		
		 book = "Book";
		 author = "Unknown";
		 System.out.println("Book name is " +book);
		 System.out.println("Author name is " +author);
		 
		 
	
	}
}
class magazine implements printable {
	public void print() {
		int issueNumber = 23 ;
		System.out.println("issue number" +issueNumber);
	}
}