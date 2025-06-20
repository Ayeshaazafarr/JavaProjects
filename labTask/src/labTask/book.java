package labTask;

public class book {
	private String title ;
	private String author ; 
	private boolean isIssued ; 

	public book () {
		title = "Triangle Escape ";
		author = "Ayesha Zafar" ;
		isIssued = false ;
	}

	 public void issueBook () {
		 if (!isIssued) {
			 isIssued = true ;
			 System.out.println("The book" + title + "by" + author + "is issued ");
		
		 }else {
			 System.out.println("The book " + title + "is already issued");
		 }
	 }
	 	public void returnBook () {
	 		if (isIssued) {
	 			isIssued = false ;
	 			System.out.println ("The book " + title + "has been returned");
	 		}else {
	 			System.out.println("The book"+  title+ "was not issued");
	 		}
	 	}
	 		public void showStatus() {
	 			if (isIssued) {
	 				System.out.println("The book" + title + " is available");
	 			} else {
	 				System.out.println("The book is "+ title + "issued");
	 			}
	 		}
}