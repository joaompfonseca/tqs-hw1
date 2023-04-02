package tqs.hw1.envmonitor.data.openweather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherAirPollutionItemDTO {
    private Long dt;
    private OpenWeatherAirPollutionComponentsDTO components;
}
