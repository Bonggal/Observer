package sample.observer;

import sample.BaseState;
import sample.subject.Subject;
import sample.subject.WeatherSensor;

public class CurrentConditionDisplay implements Observer {
    private Subject weatherSensor;

    private double temperature;
    private double humidity;
    private String pressure;

    public CurrentConditionDisplay(Subject weatherSensor) {
        this.weatherSensor = weatherSensor;
        this.weatherSensor.addAsObserver(this);
    }

    @Override
    public boolean update() {
        WeatherSensor sensor = (WeatherSensor) weatherSensor;
        this.temperature = sensor.getTemperature();
        this.humidity = sensor.getHumidity();
        this.pressure = sensor.getPressure();
        System.out.println(this.toString());
        return true;
    }

    @Override
    public String toString() {
        return "Temperature: " + this.temperature + "\n" +
                "Humidity   : " + this.humidity + "\n" +
                "Pressure   : " + this.pressure + "\n";
    }
}