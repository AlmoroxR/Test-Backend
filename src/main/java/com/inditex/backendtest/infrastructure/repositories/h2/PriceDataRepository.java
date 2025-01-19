package com.inditex.backendtest.infrastructure.repositories.h2;

import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceDataRepository extends JpaRepository<PriceEntity, String> {

    Optional<List<PriceEntity>> findPricesByProductId(int productId);

    @Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId AND :date BETWEEN p.startDate AND p.endDate")
    Optional<List<PriceEntity>> findPricesByProductIdAndBrandIdAndDateBetweenStartDateAndEndDate(
            @Param("productId") int productId, @Param("brandId") int brandId, @Param("date") Date date);
}
