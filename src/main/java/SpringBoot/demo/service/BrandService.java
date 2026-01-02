package SpringBoot.demo.service;

import SpringBoot.demo.model.Brand;
import SpringBoot.demo.repository.BrandRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand saveBrands(Brand brand){
        return brandRepository.save(brand);
    }

    public Page<Brand> findAllBrands(Pageable pageable){
        return brandRepository.findAll(pageable);
    }
}
