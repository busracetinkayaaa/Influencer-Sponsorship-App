package SpringBoot.demo.repository;

import SpringBoot.demo.model.Influencer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InfluencerRepository extends JpaRepository<Influencer,Long> {

    Page<Influencer> findAll(Pageable pageable);
}
