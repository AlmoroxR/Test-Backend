package com.inditex.backendtest.infrastructure.repositories.mongodb;

import com.inditex.backendtest.infrastructure.entities.mongodb.PriceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PriceRepository extends MongoRepository<PriceEntity, String> {

    @Query("{'productId' : ?1}")
    Optional<List<PriceEntity>> findByProductId(int productId);
}
