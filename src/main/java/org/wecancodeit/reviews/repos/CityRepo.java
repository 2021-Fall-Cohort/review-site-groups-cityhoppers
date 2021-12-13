package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.model.CityReview;

import java.util.Optional;

public interface CityRepo extends CrudRepository<CityReview, Long> {
    Optional<CityReview> findByName(String name);
//    City Name
//    Region
//
}
