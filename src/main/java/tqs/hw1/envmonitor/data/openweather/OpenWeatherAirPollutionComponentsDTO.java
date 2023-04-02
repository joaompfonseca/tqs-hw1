package tqs.hw1.envmonitor.data.openweather;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OpenWeatherAirPollutionComponentsDTO {
    private Double co;
    private Double nh3;
    private Double no;
    private Double no2;
    private Double o3;
    private Double pm10;
    private Double pm2_5;
    private Double so2;
}
