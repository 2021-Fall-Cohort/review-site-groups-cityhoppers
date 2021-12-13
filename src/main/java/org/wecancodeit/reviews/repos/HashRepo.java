package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.model.HashPage;

import java.util.Optional;

public interface HashRepo extends CrudRepository<HashPage,Long> {


    Optional<HashPage> findByName(String name);
}
