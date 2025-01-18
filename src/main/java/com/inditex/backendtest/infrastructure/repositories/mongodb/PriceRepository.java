package com.inditex.backendtest.infrastructure.repositories.mongodb;

import com.inditex.backendtest.infrastructure.entities.mongodb.PriceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface PriceRepository extends MongoRepository<PriceEntity, String> {

    @Query("{ 'brandId' : ?0, 'productId' : ?1, 'startDate' : { $lte: ?2 }, 'endDate' : { $gte: ?2 } }")
    Optional<PriceEntity> findByBrandIdAndProductIdAndDateBetween(int brandId, int productId, Date date);
}
