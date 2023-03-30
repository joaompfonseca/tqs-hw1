package tqs.hw1.envmonitor.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tqs.hw1.envmonitor.cache.EnvCache;
import tqs.hw1.envmonitor.data.cache.CacheStatsDTO;
import tqs.hw1.envmonitor.util.Utils;

@RestController
@RequestMapping("/api/cache")
public class CacheRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final EnvCache cache;

    public CacheRestController(Environment env) {
        this.cache = EnvCache.getInstance(env.getProperty("cache.ttl", Long.class), env.getProperty("cache.capacity", Integer.class));
    }

    @RequestMapping("/stats")
    public CacheStatsDTO getStats() {
        logger.info("GET /api/cache/stats");
        return Utils.cacheStatsDTOfrom(cache);
    }
}
