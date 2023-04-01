package tqs.hw1.envmonitor.data.openmeteo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenMeteoAirQualityDTO {
    private OpenMeteoAirQualityHourlyDTO hourly;
}
