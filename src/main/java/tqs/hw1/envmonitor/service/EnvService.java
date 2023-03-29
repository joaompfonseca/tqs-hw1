package tqs.hw1.envmonitor.service;

import org.springframework.stereotype.Service;
import tqs.hw1.envmonitor.data.env.EnvDTO;
import tqs.hw1.envmonitor.external.ExternalAPI;

@Service
public class EnvService {

    private final ExternalAPI externalAPI;

    public EnvService(ExternalAPI externalAPI) {
        this.externalAPI = externalAPI;
    }

    public EnvDTO getCurrentEnv(String location) {
        return externalAPI.getCurrentEnv(location);
    }

    public EnvDTO getForecastEnv(String location) {
        return externalAPI.getForecastEnv(location);
    }

}
