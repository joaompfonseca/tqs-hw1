package tqs.hw1.envmonitor.boundary;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tqs.hw1.envmonitor.cache.Cache;
import tqs.hw1.envmonitor.data.cache.CacheStatsDTO;
import tqs.hw1.envmonitor.data.env.EnvDTO;
import tqs.hw1.envmonitor.service.EnvService;
import tqs.hw1.envmonitor.util.Utils;

@RestController
@RequestMapping("/api/cache")
public class CacheRestController {

    private final Cache<String, EnvDTO> cache;

    public CacheRestController(EnvService envService) {
        this.cache = envService.getCache();
    }

    @RequestMapping("/stats")
    public CacheStatsDTO getStats() {
        return Utils.cacheStatsDTOfrom(cache);
    }
}
