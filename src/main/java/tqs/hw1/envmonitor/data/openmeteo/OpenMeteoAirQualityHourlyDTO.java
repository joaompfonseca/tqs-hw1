package tqs.hw1.envmonitor.data.openmeteo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OpenMeteoAirQualityHourlyDTO {
    private List<Long> time;
    private List<Double> ammonia;
    private List<Double> carbon_monoxide;
    private List<Double> nitrogen_dioxide;
    private List<Double> ozone;
    private List<Double> pm10;
    private List<Double> pm2_5;
    private List<Double> sulphur_dioxide;

}
