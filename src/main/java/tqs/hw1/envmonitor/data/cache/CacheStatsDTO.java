package tqs.hw1.envmonitor.data.cache;

import lombok.Data;

@Data
public class CacheStatsDTO {
    private Long ttl;
    private Integer capacity;
    private Integer nRequests;
    private Integer nHits;
    private Integer nMisses;
    private Integer nItems;
}
