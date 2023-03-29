package tqs.hw1.envmonitor.external;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${openweather.name}", url = "${openweather.url}")
public class OpenWeatherAPI {
}
