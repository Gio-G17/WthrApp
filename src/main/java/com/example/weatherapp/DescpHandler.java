package com.example.weatherapp;

import java.util.Arrays;
import java.util.List;

public class DescpHandler{

        public static String getWeatherSentence(String weatherCondition) {

            List<String> clearSkyConditions = Arrays.asList("clear sky");
            List<String> fewCloudsConditions = Arrays.asList("few clouds");
            List<String> scatteredCloudsConditions = Arrays.asList("scattered clouds");
            List<String> brokenCloudsConditions = Arrays.asList("broken clouds", "overcast clouds");
            List<String> showerRainConditions = Arrays.asList("shower rain", "light intensity shower rain");
            List<String> rainConditions = Arrays.asList("light rain", "moderate rain", "heavy intensity rain", "very heavy rain", "extreme rain", "freezing rain", "light intensity shower rain", "shower rain", "heavy intensity shower rain", "ragged shower rain");
            List<String> thunderstormConditions = Arrays.asList("thunderstorm with light rain", "thunderstorm with rain", "thunderstorm with heavy rain", "light thunderstorm", "thunderstorm", "heavy thunderstorm", "ragged thunderstorm", "thunderstorm with light drizzle", "thunderstorm with drizzle", "thunderstorm with heavy drizzle");
            List<String> snowConditions = Arrays.asList("light snow", "snow", "heavy snow", "sleet", "light shower sleet", "shower sleet", "light rain and snow", "rain and snow", "light shower snow", "shower snow", "heavy shower snow");
            List<String> atmosphereConditions = Arrays.asList("mist", "smoke", "haze", "sand/dust whirls", "fog", "sand", "dust", "volcanic ash", "squalls", "tornado");

            // Check the weather condition and return the appropriate sentence
            if (clearSkyConditions.contains(weatherCondition)) {
                return "there is a clear sky";
            } else if (fewCloudsConditions.contains(weatherCondition)) {
                return "there are a few clouds";
            } else if (scatteredCloudsConditions.contains(weatherCondition)) {
                return "there are scattered clouds";
            } else if (brokenCloudsConditions.contains(weatherCondition)) {
                return "the sky is mostly cloudy";
            } else if (showerRainConditions.contains(weatherCondition)) {
                return "there are showers of rain";
            } else if (rainConditions.contains(weatherCondition)) {
                return "there is rain";
            } else if (thunderstormConditions.contains(weatherCondition)) {
                return "there is a thunderstorm";
            } else if (snowConditions.contains(weatherCondition)) {
                return "there is snowfall";
            } else if (atmosphereConditions.contains(weatherCondition)) {
                return "there is " + weatherCondition; // If it's a general atmospheric condition
            } else {
                return "unknown weather condition";
            }
        }
}
