package ru.sberbank.edu;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

    private WeatherInfo(Builder builder) {
        this.city = builder.city;
        this.shortDescription = builder.shortDescription;
        this.description = builder.description;
        this.temperature = builder.temperature;
        this.feelsLikeTemperature = builder.feelsLikeTemperature;
        this.windSpeed = builder.windSpeed;
        this.pressure = builder.pressure;
        if (builder.expiryTime == null) {
            this.expiryTime = LocalDateTime.now();
        } else {
            this.expiryTime = builder.expiryTime;
        }
    }

    @JsonProperty("name")
    private String city;

    /**
     * Short weather description
     * Like 'sunny', 'clouds', 'raining', etc
     */
    private String shortDescription;

    /**
     * Weather description.
     * Like 'broken clouds', 'heavy raining', etc
     */
    private String description;

    /**
     * Temperature.
     */
    private double temperature;

    /**
     * Temperature that fells like.
     */
    private double feelsLikeTemperature;

    /**
     * Wind speed.
     */
    private double windSpeed;

    /**
     * Pressure.
     */
    private double pressure;

    /**
     * Expiry time of weather info.
     * If current time is above expiry time then current weather info is not actual!
     */
    private LocalDateTime expiryTime;

    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("wind")
    private Wind wind;

    public WeatherInfo() {
    }

    public void setWeather(List<Weather> weather) {
        this.shortDescription = weather.get(0).main;
        this.description = weather.get(0).description;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    @JsonGetter
    public String getCity() {
        return city;
    }

    /**
     * Gets short description.
     *
     * @return the short description
     */
    @JsonGetter
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    @JsonGetter
    public String getDescription() {
        return description;
    }

    /**
     * Gets temperature.
     *
     * @return the temperature
     */
    @JsonGetter
    public double getTemperature() {
        return temperature;
    }

    /**
     * Gets feels like temperature.
     *
     * @return the feels like temperature
     */
    @JsonGetter
    public double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    /**
     * Gets wind speed.
     *
     * @return the wind speed
     */
    @JsonGetter
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * Gets pressure.
     *
     * @return the pressure
     */
    @JsonGetter
    public double getPressure() {
        return pressure;
    }

    /**
     * Gets expiry time.
     *
     * @return the expiry time
     */
    @JsonGetter
    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" + "city='" + city + '\'' + ", shortDescription='" + shortDescription + '\''
                + ", description='" + description + '\'' + ", temperature=" + temperature + ", feelsLikeTemperature="
                + feelsLikeTemperature + ", windSpeed=" + windSpeed + ", pressure=" + pressure + ", expiryTime="
                + expiryTime + '}';
    }

    public class Main {

        /**
         * The Temp.
         */
        @JsonProperty("temp")
        public double temp;
        /**
         * The Feels like.
         */
        @JsonProperty("feels_like")
        public double feelsLike;
        /**
         * The Pressure.
         */
        @JsonProperty("pressure")
        public double pressure;

        /**
         * Gets temp.
         *
         * @return the temp
         */
        @JsonGetter
        public double getTemp() {
            return temp;
        }

        /**
         * Gets feels like.
         *
         * @return the feels like
         */
        @JsonGetter
        public double getFeelsLike() {
            return feelsLike;
        }

        /**
         * Gets pressure.
         *
         * @return the pressure
         */
        @JsonGetter
        public double getPressure() {
            return pressure;
        }

        /**
         * Sets temp.
         *
         * @param temp the temp
         */
        public void setTemp(double temp) {
            WeatherInfo.this.temperature = temp;
        }

        /**
         * Sets feels like.
         *
         * @param feelsLike the feels like
         */
        public void setFeelsLike(double feelsLike) {
            WeatherInfo.this.feelsLikeTemperature = feelsLike;
        }

        /**
         * Sets pressure.
         *
         * @param pressure the pressure
         */
        public void setPressure(double pressure) {
            WeatherInfo.this.pressure = pressure;
        }
    }

    public static class Weather {

        /**
         * Instantiates a new Weather.
         */
        public Weather() {

        }

        @JsonProperty("main")
        private String main;
        @JsonProperty("description")
        private String description;

        /**
         * Gets main.
         *
         * @return the main
         */
        @JsonGetter
        public String getMain() {
            return main;
        }

        /**
         * Gets description.
         *
         * @return the description
         */
        @JsonGetter
        public String getDescription() {
            return description;
        }

    }

    /**
     * The type Wind.
     */
    public class Wind {

        /**
         * The Speed.
         */
        @JsonProperty("speed")
        public double speed;

        /**
         * Gets speed.
         *
         * @return the speed
         */
        @JsonGetter
        public double getSpeed() {
            return speed;
        }

        /**
         * Sets speed.
         *
         * @param speed the speed
         */
        public void setSpeed(double speed) {
            WeatherInfo.this.windSpeed = speed;
        }
    }

    /**
     * The type Builder.
     */
    public static class Builder {

        private String city;
        private String shortDescription;
        private String description;
        private double temperature;
        private double feelsLikeTemperature;
        private double windSpeed;
        private double pressure;
        private LocalDateTime expiryTime;

        /**
         * Build weather info.
         *
         * @return the weather info
         */
        public WeatherInfo build() {
            return new WeatherInfo(this);
        }

        /**
         * Sets city.
         *
         * @param city the city
         * @return the city
         */
        public Builder setCity(String city) {
            this.city = city;

            return this;
        }

        /**
         * Sets short description.
         *
         * @param shortDescription the short description
         * @return the short description
         */
        public Builder setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;

            return this;
        }

        /**
         * Sets description.
         *
         * @param description the description
         * @return the description
         */
        public Builder setDescription(String description) {
            this.description = description;

            return this;
        }

        /**
         * Sets temperature.
         *
         * @param temperature the temperature
         * @return the temperature
         */
        public Builder setTemperature(double temperature) {
            this.temperature = temperature;

            return this;
        }

        /**
         * Sets feels like temperature.
         *
         * @param feelsLikeTemperature the feels like temperature
         * @return the feels like temperature
         */
        public Builder setFeelsLikeTemperature(double feelsLikeTemperature) {
            this.feelsLikeTemperature = feelsLikeTemperature;

            return this;
        }

        /**
         * Sets wind speed.
         *
         * @param windSpeed the wind speed
         * @return the wind speed
         */
        public Builder setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;

            return this;
        }

        /**
         * Sets pressure.
         *
         * @param pressure the pressure
         * @return the pressure
         */
        public Builder setPressure(double pressure) {
            this.pressure = pressure;

            return this;
        }

        /**
         * Sets expiry time.
         *
         * @param expiryTime the expiry time
         * @return the expiry time
         */
        public Builder setExpiryTime(LocalDateTime expiryTime) {
            this.expiryTime = expiryTime;

            return this;
        }
    }
}
