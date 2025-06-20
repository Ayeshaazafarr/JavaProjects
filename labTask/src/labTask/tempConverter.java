package labTask;

class TemperatureConverter {
   
    private double temperature;

    
    public void setCelsius(double value) {
        temperature = value;
    }

    
    public void setFahrenheit(double value) {
        temperature = (value - 32) * 5 / 9;
    }

    
    public double toFahrenheit() {
        return (temperature * 9 / 5) + 32;
    }

  
    public double toCelsius() {
        return temperature;
    }
    public void showTemperature() {
        System.out.println("Stored temperature: " + temperature + "°C");
    }
}