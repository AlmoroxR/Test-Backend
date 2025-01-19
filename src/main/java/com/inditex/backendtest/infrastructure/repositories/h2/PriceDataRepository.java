package com.inditex.backendtest.infrastructure.repositories.h2;

import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriceDataRepository extends JpaRepository<PriceEntity, String> {

    Optional<List<PriceEntity>> findByProductId(int productId);
}
