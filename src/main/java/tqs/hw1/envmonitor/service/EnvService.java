package tqs.hw1.envmonitor.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import tqs.hw1.envmonitor.cache.EnvCache;
import tqs.hw1.envmonitor.data.env.EnvDTO;
import tqs.hw1.envmonitor.external.ExternalAPI;

@Service
public class EnvService {

    private final ExternalAPI externalAPI;
    private final EnvCache cache;

    public EnvService(ExternalAPI externalAPI, Environment env) {
        this.externalAPI = externalAPI;
        this.cache = EnvCache.getInstance(env.getProperty("cache.ttl", Long.class), env.getProperty("cache.capacity", Integer.class));
    }

    public EnvDTO getCurrentEnv(String location) {
        EnvDTO res = null;
        if ((res = cache.get("current:" + location)) == null) {
            res = externalAPI.getCurrentEnv(location);
            cache.put(location, res);
        }
        return res;
    }

    public EnvDTO getForecastEnv(String location) {
        EnvDTO res = null;
        if ((res = cache.get("forecast:" + location)) == null) {
            res = externalAPI.getForecastEnv(location);
            cache.put(location, res);
        }
        return res;
    }

}
