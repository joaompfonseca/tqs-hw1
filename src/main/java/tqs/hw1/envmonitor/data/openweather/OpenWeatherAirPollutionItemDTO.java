package tqs.hw1.envmonitor.data.openweather;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenWeatherAirPollutionItemDTO {
    private Long dt;
    private OpenWeatherAirPollutionComponentsDTO components;
}
