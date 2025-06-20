package Q2;


public class Main {
 public static void main(String[] args) {
     Student student = new Student();
     student.name = "Alice";
     student.age = 20;
     student.school = "Greenwood High";

     student.introduce();  // Inherited from Person
 }
}