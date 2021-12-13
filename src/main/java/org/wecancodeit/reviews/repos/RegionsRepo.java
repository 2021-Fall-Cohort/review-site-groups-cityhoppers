package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.model.Region;

import java.util.Optional;

public interface RegionsRepo extends CrudRepository<Region, Long> {
    Optional<Region> findByRegionNameIgnoreCase(String regionName);
}
