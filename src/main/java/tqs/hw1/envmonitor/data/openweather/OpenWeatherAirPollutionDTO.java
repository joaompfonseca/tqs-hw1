package tqs.hw1.envmonitor.data.openweather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherAirPollutionDTO {
    private List<OpenWeatherAirPollutionItemDTO> list;
}
