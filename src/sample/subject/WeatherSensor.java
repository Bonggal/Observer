package sample.subject;

import sample.observer.Observer;

import java.util.ArrayList;

public class WeatherSensor implements Subject {
    ArrayList<Observer> observers = new ArrayList();

    private double temperature = 25.0;
    private double humidity;
    private String pressure = "Normal";

    public void setTemperature(double temperature){
        this.temperature = temperature;
        stateChanged();
    }

    public void setHumidity(double humidity){
        this.humidity = humidity;
        stateChanged();
    }

    public void setPressure(String pressure){
        this.pressure = pressure;
        stateChanged();
    }

    public double getTemperature(){
        return this.temperature;
    }

    public double getHumidity(){
        return  this.humidity;
    }

    public String getPressure(){
        return this.pressure;
    }

    @Override
    public boolean addAsObserver(Observer observer) {
        observers.add(observer);
        return true;
    }

    @Override
    public boolean removeFromObserver(Observer observer) {
        observers.remove(observer);
        return true;
    }

    @Override
    public boolean stateChanged() {
        notifyObserver();
        return true;
    }

    @Override
    public boolean notifyObserver() {
        for(Observer observer: observers){
            observer.update();
        }
        return true;
    }
}