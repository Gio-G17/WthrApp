package com.example.weatherapp;

import java.util.Arrays;
import java.util.List;

public class ImageHandler {
    public static String getImage(String description, String iconCode, boolean isDay) {
        System.out.println("Description: " + description);
        System.out.println("Icon Code: " + iconCode);
        description = description.toLowerCase();

        // Group similar conditions together
        List<String> clearSkyConditions = Arrays.asList("clear sky");
        List<String> fewCloudsConditions = Arrays.asList("few clouds");
        List<String> scatteredCloudsConditions = Arrays.asList("scattered clouds");
        List<String> brokenCloudsConditions = Arrays.asList("broken clouds", "overcast clouds");
        List<String> showerRainConditions = Arrays.asList("shower rain", "light intensity shower rain");
        List<String> rainConditions = Arrays.asList("light rain", "moderate rain", "heavy intensity rain", "very heavy rain", "extreme rain", "freezing rain", "light intensity shower rain", "shower rain", "heavy intensity shower rain", "ragged shower rain");
        List<String> thunderstormConditions = Arrays.asList("thunderstorm with light rain", "thunderstorm with rain", "thunderstorm with heavy rain", "light thunderstorm", "thunderstorm", "heavy thunderstorm", "ragged thunderstorm", "thunderstorm with light drizzle", "thunderstorm with drizzle", "thunderstorm with heavy drizzle");
        List<String> snowConditions = Arrays.asList("light snow", "snow", "heavy snow", "sleet", "light shower sleet", "shower sleet", "light rain and snow", "rain and snow", "light shower snow", "shower snow", "heavy shower snow");
        List<String> atmosphereConditions = Arrays.asList("mist", "smoke", "haze", "sand/dust whirls", "fog", "sand", "dust", "volcanic ash", "squalls", "tornado");

        // Check for day and night
        String dayNightSuffix = isDay ? "d" : "n";

        // Check for specific conditions and return the corresponding icon
        if (clearSkyConditions.contains(description)) {
            return "01" + dayNightSuffix + ".png";
        } else if (fewCloudsConditions.contains(description)) {
            return "02" + dayNightSuffix + ".png";
        } else if (scatteredCloudsConditions.contains(description)) {
            return "03" + dayNightSuffix + ".png";
        } else if (brokenCloudsConditions.contains(description)) {
            return "04" + dayNightSuffix + ".png";
        } else if (showerRainConditions.contains(description)) {
            return "09d.png";  // Using the same icon for various shower rain conditions
        } else if (rainConditions.contains(description)) {
            return "10" + dayNightSuffix + ".png";
        } else if (thunderstormConditions.contains(description)) {
            return "11" + dayNightSuffix + ".png";  // Using the same icon for various thunderstorm conditions
        } else if (snowConditions.contains(description)) {
            return "13" + dayNightSuffix + ".png";
        } else if (atmosphereConditions.contains(description)) {
            return "50" + dayNightSuffix + ".png";  // Using the same icon for various atmosphere conditions
        }

        return "/com/example/weatherapp/general-icons/default.png"; // Default image if no match is found
    }

}
