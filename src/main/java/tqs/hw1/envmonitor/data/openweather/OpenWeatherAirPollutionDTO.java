package tqs.hw1.envmonitor.data.openweather;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OpenWeatherAirPollutionDTO {
    private List<OpenWeatherAirPollutionItemDTO> list;
}
