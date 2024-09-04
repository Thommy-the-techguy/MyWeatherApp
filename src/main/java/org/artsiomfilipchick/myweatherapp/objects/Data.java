package org.artsiomfilipchick.myweatherapp.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.artsiomfilipchick.myweatherapp.interfaces.Observer;
import org.artsiomfilipchick.myweatherapp.interfaces.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data implements Subject {
    private final List<Observer> observers;
    private String timezone;
    @JsonProperty("hourly")
    private Hourly hourly;


    public Data() {
        observers = new ArrayList<>();
    }

    public Data(String timezone, List<Date> time, Hourly hourly) {
        observers = new ArrayList<>();
        this.timezone = timezone;
        this.hourly = hourly;
    }


    public String getTimezone() {
        return timezone;
    }

    public Hourly getHourly() {
        return hourly;
    }


    public void setTimezone(String timezone) {
        this.timezone = timezone;
        dataChanged();
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
        dataChanged();
    }


    public void dataChanged() {
        notifyObservers();
    }


    @Override
    public String toString() {
        return "Data{" +
                "timezone='" + timezone + '\'' +
                ", hourly=" + hourly +
                '}';
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


    public final class Hourly {
        @JsonProperty("time")
        private List<Date> time;
        @JsonProperty("temperature_2m")
        private List<Float> temperature;

        public Hourly() {
            this.time = new ArrayList<>();
            this.temperature = new ArrayList<>();
        }

        public Hourly(List<Date> time, List<Float> temperature) {
            this.time = time;
            this.temperature = temperature;
        }

        public List<Date> getTime() {
            return time;
        }

        public List<Float> getTemperature() {
            return temperature;
        }

        public void setTime(List<Date> time) {
            this.time = time;
        }

        public void setTemperature(List<Float> temperature) {
            this.temperature = temperature;
        }

        @Override
        public String toString() {
            return "Hourly{" +
                    "time=" + time +
                    ", temperature=" + temperature +
                    '}';
        }
    }
}
