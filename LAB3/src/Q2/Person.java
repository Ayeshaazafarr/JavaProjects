package Q2;

class Person {
    String name;
    int age;

    void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}

// Subclass
class Student extends Person {
    String school;
}
