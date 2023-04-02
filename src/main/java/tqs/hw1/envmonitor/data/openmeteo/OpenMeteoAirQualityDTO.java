package tqs.hw1.envmonitor.data.openmeteo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenMeteoAirQualityDTO {
    private OpenMeteoAirQualityHourlyDTO hourly;
}
