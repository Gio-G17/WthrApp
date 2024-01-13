package com.example.weatherapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;


import org.json.JSONObject;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class WeatherApp extends Application {
    private static final String API_KEY = "45d627b8cfdc51966b67c7ab619c5b71";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String IMAGE_BASE_URL = "file:///C:/Users/giorg/IdeaProjects/WeatherApp/src/main/resources/weather-icons/";
    private static final String IMAGE_BASE_URL2 = "file:///C:/Users/giorg/IdeaProjects/WeatherApp/src/main/resources/weather-icons/02d.png";



    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {


        //Stage
        primaryStage.setTitle("Weather App");
        primaryStage.getIcons().add(new Image(IMAGE_BASE_URL2));


        //Grid
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: white;");

        //grid.setGridLinesVisible(true);

        //Scene
        Scene scene = new Scene(grid, 600, 300);
        primaryStage.setScene(scene);


        primaryStage.show();


        //Top Column
        Label cityLabel = new Label("Right now in ");
        cityLabel.setStyle("-fx-font-size: 15px");
        cityLabel.setPrefWidth(200);
        cityLabel.setAlignment(Pos.CENTER_RIGHT);

        TextField cityTextField = new TextField();
        cityTextField.setAlignment(Pos.CENTER);
        cityTextField.setStyle("-fx-background-color: transparent; -fx-font-size: 15px; -fx-font-weight: bold;");
        cityTextField.setPrefWidth(200);

        BorderStroke borderStroke = new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                null,
                new BorderWidths(0, 0, 1, 0)  // Only bottom border with a width of 1
        );

        cityTextField.setBorder(new Border(borderStroke));


        Label weatherCon = new Label();
        weatherCon.setStyle("-fx-font-size: 15px");
        weatherCon.setAlignment(Pos.CENTER_LEFT);


        //Mid Column
        ImageView weatherImageView = new ImageView();
        weatherImageView.setFitWidth(150); // Set a width (adjust as needed)
        weatherImageView.setFitHeight(150); // Set a height (adjust as needed);


        Label temperatureLabel = new Label();
        temperatureLabel.setStyle("-fx-font-size: 40px; -fx-alignment: center; -fx-font-weight: bold;");

        ImageView windIcon = new ImageView(new Image("file:///C:/Users/giorg/IdeaProjects/WeatherApp/src/main/resources/general-icons/wind.png"));
        windIcon.setFitHeight(20);
        windIcon.setFitWidth(20);
        Label windSpeedLabel = new Label();
        windSpeedLabel.setStyle("-fx-font-size: 15px; ");

        ImageView rainIcon = new ImageView(new Image("file:///C:/Users/giorg/IdeaProjects/WeatherApp/src/main/resources/general-icons//rain.png"));
        rainIcon.setFitHeight(20);
        rainIcon.setFitWidth(20);
        Label rainLabel = new Label();
        rainLabel.setStyle("-fx-font-size: 15px; ");

        ImageView humidityIcon = new ImageView(new Image("file:///C:/Users/giorg/IdeaProjects/WeatherApp/src/main/resources/general-icons//humid.png"));
        humidityIcon.setFitHeight(20);
        humidityIcon.setFitWidth(20);
        Label humidityLabel = new Label();
        humidityLabel.setStyle("-fx-font-size: 15px; ");

        //Bott Column
        Label sunriseLabel = new Label();
        sunriseLabel.setStyle("-fx-font-size: 15px; ");
        sunriseLabel.setAlignment(Pos.CENTER_RIGHT);

        Label sunsetLabel = new Label();
        sunsetLabel.setStyle("-fx-font-size: 15px;");
        sunsetLabel.setAlignment(Pos.CENTER_LEFT);

        Label timezone = new Label();


        // Boxes

        HBox cityLabelBox = new HBox(cityLabel);
        cityLabelBox.setPrefWidth(250);
        cityLabelBox.setAlignment(Pos.CENTER);

        HBox cityTextBox = new HBox(cityTextField);
        cityTextBox.setPrefWidth(250);
        cityTextBox.setAlignment(Pos.CENTER);

        HBox weatherCondition = new HBox(weatherCon);
        weatherCondition.setPrefWidth(250);
        weatherCondition.setAlignment(Pos.CENTER_LEFT);

        HBox IconBox = new HBox(weatherImageView);
        IconBox.setPrefWidth(250);
        IconBox.setAlignment(Pos.CENTER);

        HBox TempBox = new HBox(temperatureLabel);
        TempBox.setPrefWidth(250);
        TempBox.setAlignment(Pos.CENTER);

        HBox windBox = new HBox(windIcon,windSpeedLabel);
        windBox.setSpacing(10);

        HBox rainBox = new HBox(rainIcon,rainLabel);
        rainBox.setSpacing(10);

        HBox humidBox = new HBox(humidityIcon,humidityLabel);
        humidBox.setSpacing(10);


        VBox vComp = new VBox(windBox, rainBox, humidBox);
        vComp.setAlignment(Pos.CENTER_LEFT);
        vComp.setSpacing(20);

        HBox hComp = new HBox(vComp);
        hComp.setPrefWidth(250);
        hComp.setAlignment(Pos.CENTER);

        HBox rise = new HBox(sunriseLabel);
        rise.setAlignment(Pos.CENTER_RIGHT);

        HBox set = new HBox(sunsetLabel);
        set.setAlignment(Pos.CENTER_LEFT);

        //Grid

        grid.add(cityLabelBox,0,0);

        grid.add(cityTextBox,1,0);

        grid.add(weatherCondition,2,0);

        // For weatherImageView
        GridPane.setHalignment(weatherImageView, HPos.CENTER);
        GridPane.setValignment(weatherImageView, VPos.CENTER);
        grid.add(weatherImageView, 0, 1);

        // For temperatureLabel
        GridPane.setHalignment(temperatureLabel, HPos.CENTER);
        GridPane.setValignment(temperatureLabel, VPos.CENTER);
        grid.add(temperatureLabel, 1, 1);


        grid.add(hComp,2,1);

        GridPane.setHalignment(sunriseLabel, HPos.RIGHT);
        grid.add(sunriseLabel,0,2);

        GridPane.setHalignment(sunsetLabel, HPos.LEFT);
        grid.add(sunsetLabel,2,2);



        //Filling Labels based on inputted city

        cityTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            String city = newValue.trim();
            if (!city.isEmpty()) {
                String[] weatherInfo = getWeatherInfo(city);
                weatherCon.setText(DescpHandler.getWeatherSentence(weatherInfo[1]));
                temperatureLabel.setText(weatherInfo[2]);
                windSpeedLabel.setText(weatherInfo[5]);
                rainLabel.setText(weatherInfo[4]);
                humidityLabel.setText(weatherInfo[3]);
                displayWeatherImage(weatherInfo, weatherImageView);
                sunriseLabel.setText(weatherInfo[6]);
                sunsetLabel.setText(weatherInfo[7]);
                timezone.setText(weatherInfo[8]);
            } else {
                // Clear the labels if the city name is empty
                temperatureLabel.setText("");
                windSpeedLabel.setText("");
                rainLabel.setText("");
                humidityLabel.setText("");
                sunriseLabel.setText("");
                sunsetLabel.setText("");
                timezone.setText("");
            }
        });

    }



    private String[] getWeatherInfo(String city) {
        String apiUrl = API_URL + "?q=" + city + "&appid=" + API_KEY;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream = connection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            StringBuilder response = new StringBuilder();

            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }

            scanner.close();
            inputStream.close();
            connection.disconnect();

            JSONObject jsonResponse = new JSONObject(response.toString());

            System.out.print(jsonResponse);

            String cityName = jsonResponse.getString("name");
            String weatherDescription = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");
            double temperatureKelvin = jsonResponse.getJSONObject("main").getDouble("temp");
            double temperatureCelsius = Math.round(temperatureKelvin - 273.15);
            int humidity = jsonResponse.getJSONObject("main").getInt("humidity");

            // Check if "rain" field is present
            double rainPercentage = 0;
            if (jsonResponse.has("rain") && jsonResponse.getJSONObject("rain").has("1h")) {
                rainPercentage = jsonResponse.getJSONObject("rain").getDouble("1h");
            }

            double windSpeed = jsonResponse.getJSONObject("wind").getDouble("speed");
            long sunriseTime = jsonResponse.getJSONObject("sys").getLong("sunrise");
            long sunsetTime = jsonResponse.getJSONObject("sys").getLong("sunset");
            long timeZone = jsonResponse.optLong("timezone", -1);


            // Convert sunrise and sunset times to readable format
            String sunriseTimeString = convertUnixTimestampToTime(sunriseTime);
            String sunsetTimeString = convertUnixTimestampToTime(sunsetTime);

            System.out.println(jsonResponse);

            return new String [] {

                    "City: " + cityName,
                    weatherDescription,
                    temperatureCelsius + " °C",
                    humidity + "%",
                    rainPercentage + " mm/h",
                    windSpeed + " m/s",
                    "Sunrise: " + sunriseTimeString,
                    "Sunset: " + sunsetTimeString,
                    String.valueOf(timeZone)
            };

        } catch (IOException e) {
            e.printStackTrace();

            return new String[]{"Error fetching weather information."};
        }
    }

    //Sunrise - Sunset Conversions
    private String convertUnixTimestampToTime(long timestamp) {
        Date date = new Date(timestamp * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }

    // Hour based on timezone to use in method to see whether it is day time
    public static int getHourForTimeZoneOffset(String timeZoneOffsetString) {
        // Parse the time zone offset string to an integer
        int timeZoneOffsetSeconds = Integer.parseInt(timeZoneOffsetString);
        // Create an OffsetDateTime with the given time zone offset
        OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneOffset.ofTotalSeconds(timeZoneOffsetSeconds));
        // Extract and return the hour
        return offsetDateTime.getHour();
    }

    private boolean isDayTime(long currentHour) {
        if (currentHour >= 6 && currentHour < 18) {
            return true;
        } else {
            return false;
        }
    }

    //Displays weather image based on weather description and whether it is day or night
    private void displayWeatherImage(String[] weatherInfoArr, ImageView imageView) {

        if (weatherInfoArr.length >= 3) {
            String weatherDescription = weatherInfoArr[1];
            String iconCode = weatherInfoArr[2].substring("Icon: ".length());

            LocalDateTime currentDateTime = LocalDateTime.now();
            String imagePath = ImageHandler.getImage(weatherDescription, iconCode, isDayTime(getHourForTimeZoneOffset(weatherInfoArr[8])));
            System.out.println(getHourForTimeZoneOffset(weatherInfoArr[8]));

            if (imagePath != null) {
                try {
                    // Use the correct path with the IMAGE_BASE_URL
                    Image image = new Image( IMAGE_BASE_URL + imagePath);
                    imageView.setImage(image);
                    System.out.println("Image displayed successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Exception Message: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Invalid weather information format");
        }
    }

}

