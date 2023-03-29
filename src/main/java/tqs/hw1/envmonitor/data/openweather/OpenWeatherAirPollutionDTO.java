package tqs.hw1.envmonitor.data.openweather;

import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherAirPollutionDTO {
    private List<OpenWeatherAirPollutionItemDTO> list;
}
