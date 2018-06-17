package com.fitness.caching;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("simple-cache")
public class EvictScheduler {

    @Autowired
    private LocalCacheEvict localCacheEvict;

    @Scheduled(fixedDelayString="${fitness.cacheTTL}")
    public void clearCaches() {
        log.info("Invalidating caches");
        localCacheEvict.evictUserCache();
        localCacheEvict.evictAllUsersCache();
    }
}
