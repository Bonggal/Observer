package sample.observer;

import sample.subject.Subject;
import sample.subject.WeatherSensor;

public class TemperatureDisplay implements Observer {
    private Subject weatherSensor;

    private double minTemperature;
    private double maxTemperature;

    public TemperatureDisplay(Subject weatherSensor) {
        this.weatherSensor = weatherSensor;
        this.weatherSensor.addAsObserver(this);
        this.minTemperature = ((WeatherSensor)weatherSensor).getTemperature();
        this.maxTemperature = this.minTemperature;
    }

    @Override
    public boolean update() {
        WeatherSensor sensor = (WeatherSensor) weatherSensor;

        if (sensor.getTemperature() >= maxTemperature) {
            maxTemperature = sensor.getTemperature();
        }

        if (sensor.getTemperature() <= minTemperature) {
            minTemperature = sensor.getTemperature();
        }

        System.out.println(this.toString());
        return true;
    }

    @Override
    public String toString() {
        return "Min temperature: " + this.minTemperature + "\n" +
                "Max temperature: " + this.maxTemperature + "\n";
    }
}