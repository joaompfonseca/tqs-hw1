package tqs.hw1.envmonitor.data.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenWeatherGeocodingDTO {
    private Double lat;
    private Double lon;
    @JsonProperty("name")
    private String location;
    private String country;
}
