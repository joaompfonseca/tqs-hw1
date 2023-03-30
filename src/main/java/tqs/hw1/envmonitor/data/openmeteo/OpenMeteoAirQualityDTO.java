package tqs.hw1.envmonitor.data.openmeteo;

import lombok.Data;

@Data
public class OpenMeteoAirQualityDTO {
    private OpenMeteoAirQualityHourlyDTO hourly;
}
