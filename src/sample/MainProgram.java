package sample;

import sample.observer.TemperatureDisplay;
import sample.observer.CurrentConditionDisplay;
import sample.observer.Observer;
import sample.subject.WeatherSensor;

public class MainProgram {
    public static void main(String[] args) {
        WeatherSensor weatherSensor = new WeatherSensor();
        Observer currentConditionDisplay = new CurrentConditionDisplay(weatherSensor);
        Observer temperatureDisplay = new TemperatureDisplay(weatherSensor);

        weatherSensor.setHumidity(10.0);
        weatherSensor.setPressure("High");
        weatherSensor.setTemperature(26);
        weatherSensor.setTemperature(26);
    }
}