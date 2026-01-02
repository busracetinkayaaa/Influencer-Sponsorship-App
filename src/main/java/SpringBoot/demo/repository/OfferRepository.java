package SpringBoot.demo.repository;

import SpringBoot.demo.model.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface OfferRepository extends JpaRepository<Offer,Long> {

    Page<Offer> findByInfluencer_id(Long influencerId,Pageable page);

    Page<Offer> findByBrand_id(Long brandId,Pageable pageable);
}
