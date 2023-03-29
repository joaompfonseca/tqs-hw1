package tqs.hw1.envmonitor.data.openweather;

import lombok.Data;

@Data
public class OpenWeatherAirPollutionItemDTO {
    private Long dt;
    private OpenWeatherAirPollutionComponentsDTO components;
}
