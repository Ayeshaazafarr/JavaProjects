package labTask;

public class passwordManager {
	private String password;

	public passwordManager () {
		password = "123" ; 
	}
	public void changePassword () {
		password = "newpassword" ; 
		System.out.println("Password has been successfully changed ") ; 
		
	}
	public void validatePassword () {
		if(password.equals("newpassword")) {
			System.out.print("Password entered is correct.");
		}else {
			System.out.println("Password is Incorrect . ") ; 
		}
	}
}
 