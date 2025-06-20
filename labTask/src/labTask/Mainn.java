package labTask;

public class Mainn  {

public static void main(String[] args) {
    TemperatureConverter temp = new TemperatureConverter();
    temp.setCelsius(25);
    temp.showTemperature();
    System.out.println("Temperature in Fahrenheit: " + temp.toFahrenheit() + "°F");
    temp.setFahrenheit(77);
    temp.showTemperature();
    System.out.println("Temperature in Celsius: " + temp.toCelsius() + "°C");
}
}

