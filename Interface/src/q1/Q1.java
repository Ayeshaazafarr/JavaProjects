package q1;

import java.util.Scanner;


interface Shape {
  double area();
}



class Circle implements Shape {
 double radius;

 Circle(double r) {
     radius = r; 
 }

 public double area() {
     return Math.PI * radius * radius;
 }
}


class Rectangle implements Shape {
 double length, width;

 Rectangle(double l, double w) {
     length = l; // no 'this'
     width = w;
 }

 public double area() {
     return length * width;
 }
}

