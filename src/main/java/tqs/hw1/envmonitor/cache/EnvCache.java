package tqs.hw1.envmonitor.cache;

import tqs.hw1.envmonitor.data.env.EnvDTO;

public class EnvCache extends Cache<String, EnvDTO> {
    private static EnvCache instance;
    private EnvCache(Long ttl, Integer capacity) {
        super(ttl, capacity);
    }

    public static EnvCache getInstance(Long ttl, Integer capacity) {
        if (instance == null) {
            instance = new EnvCache(ttl, capacity);
        }
        return instance;
    }
}
