package tqs.hw1.envmonitor.util;

import tqs.hw1.envmonitor.data.env.EnvComponentsDTO;
import tqs.hw1.envmonitor.data.env.EnvDTO;
import tqs.hw1.envmonitor.data.env.EnvItemDTO;
import tqs.hw1.envmonitor.data.openweather.OpenWeatherAirPollutionDTO;
import tqs.hw1.envmonitor.data.openweather.OpenWeatherAirPollutionItemDTO;
import tqs.hw1.envmonitor.data.openweather.OpenWeatherGeocodingDTO;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static EnvDTO from(OpenWeatherGeocodingDTO geoData, OpenWeatherAirPollutionDTO envData) {
        EnvDTO env = new EnvDTO();
        env.setLocation(geoData.getLocation());
        env.setCountry(geoData.getCountry());
        List<EnvItemDTO> envItems = new ArrayList<>();
        for (OpenWeatherAirPollutionItemDTO item : envData.getList()) {
            EnvItemDTO envItem = new EnvItemDTO();
            envItem.setDt(item.getDt());
            EnvComponentsDTO envComponents = new EnvComponentsDTO();
            envComponents.setCo(item.getComponents().getCo());
            envComponents.setNh3(item.getComponents().getNh3());
            envComponents.setNo(item.getComponents().getNo());
            envComponents.setNo2(item.getComponents().getNo2());
            envComponents.setO3(item.getComponents().getO3());
            envComponents.setPm10(item.getComponents().getPm10());
            envComponents.setPm2_5(item.getComponents().getPm2_5());
            envComponents.setSo2(item.getComponents().getSo2());
            envItem.setComponents(envComponents);
            envItems.add(envItem);
        }
        env.setItems(envItems);
        return env;
    }
}
