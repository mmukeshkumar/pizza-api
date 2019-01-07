package com.fastspring.api.pizza.respository;

import com.fastspring.api.pizza.model.Promotion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Long> {


    @Query("SELECT promotion FROM Promotion promotion WHERE promotion.promotionCode=(:pPromotionCode)")
    List<Promotion> findByPromotionCode(@Param("pPromotionCode") String promotionCode);


}
