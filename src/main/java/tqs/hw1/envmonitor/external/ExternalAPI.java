package tqs.hw1.envmonitor.external;

import org.springframework.stereotype.Service;
import tqs.hw1.envmonitor.data.env.EnvDTO;
import tqs.hw1.envmonitor.data.openweather.OpenWeatherAirPollutionDTO;
import tqs.hw1.envmonitor.data.openweather.OpenWeatherGeocodingDTO;
import tqs.hw1.envmonitor.external.openweather.OpenWeatherAirPollutionAPI;
import tqs.hw1.envmonitor.external.openweather.OpenWeatherGeocodingAPI;
import tqs.hw1.envmonitor.util.Utils;

import java.util.List;

@Service
public class ExternalAPI {

    private final OpenWeatherGeocodingAPI openWeatherGeocodingAPI;
    private final OpenWeatherAirPollutionAPI openWeatherAirPollutionAPI;

    public ExternalAPI(OpenWeatherGeocodingAPI openWeatherGeocodingAPI, OpenWeatherAirPollutionAPI openWeatherAirPollutionAPI) {
        this.openWeatherGeocodingAPI = openWeatherGeocodingAPI;
        this.openWeatherAirPollutionAPI = openWeatherAirPollutionAPI;
    }

    public EnvDTO getCurrentEnv(String location) {
        // Get coordinates from OpenWeather Geocoding API
        List<OpenWeatherGeocodingDTO> geoDataList = openWeatherGeocodingAPI.getCoordinates(location);
        if (geoDataList.isEmpty()) {
            return null;
        }
        OpenWeatherGeocodingDTO geoData = geoDataList.get(0);

        // Try to get from OpenWeather Air Pollution API
        try {
            OpenWeatherAirPollutionDTO envData = openWeatherAirPollutionAPI.getCurrent(geoData.getLat(), geoData.getLon());
            return Utils.from(geoData, envData);
        } catch (Exception e) {
            // Next API
        }
        // Try to get from Weatherbit Air Quality API
        return null;
    }

    public EnvDTO getForecastEnv(String location) {
        // Get coordinates from OpenWeather Geocoding API
        List<OpenWeatherGeocodingDTO> geoDataList = openWeatherGeocodingAPI.getCoordinates(location);
        if (geoDataList.isEmpty()) {
            return null;
        }
        OpenWeatherGeocodingDTO geoData = geoDataList.get(0);

        // Try to get from OpenWeather Air Pollution API
        try {
            OpenWeatherAirPollutionDTO envData = openWeatherAirPollutionAPI.getForecast(geoData.getLat(), geoData.getLon());
            return Utils.from(geoData, envData);
        } catch (Exception e) {
            // Next API
        }
        // Try to get from Weatherbit Air Quality API
        return null;
    }
}
