package SpringBoot.demo.repository;

import SpringBoot.demo.model.Brand;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Page<Brand> findAll(Pageable pageable);
}
