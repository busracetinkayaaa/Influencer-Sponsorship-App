package SpringBoot.demo.controller;

import SpringBoot.demo.model.Brand;
import SpringBoot.demo.service.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping
    public ResponseEntity<Brand> create(@RequestBody Brand brand){
        return ResponseEntity.ok(brandService.saveBrands(brand));
    }
    @GetMapping
    public ResponseEntity<Page<Brand>> getAll(Pageable pageable){
        return ResponseEntity.ok(brandService.findAllBrands(pageable));
    }






}
