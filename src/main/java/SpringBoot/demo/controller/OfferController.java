package SpringBoot.demo.controller;

import SpringBoot.demo.dto.OfferRequest;
import SpringBoot.demo.model.Offer;
import SpringBoot.demo.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

@PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody OfferRequest request){
        Offer offer=offerService.createOffer(
                request.getInfluencer_id(),
                request.getBrand_id(),
                request.getMoneyAmount()
        );

        return ResponseEntity.ok(offer);
}

@GetMapping
    public ResponseEntity<Page<Offer>> getAllOffers(@RequestParam(name = "influencer_id",required = false) Long influencer_id,
                                                    @RequestParam(name = "brand_id",required = false) Long brand_id,Pageable pageable){

        Page<Offer> offer =offerService.findOffers(influencer_id,brand_id,pageable);
        return ResponseEntity.ok(offer);
}
@PatchMapping("/{offer_id}")
    public ResponseEntity<Offer> acceptOffer(@PathVariable Long offer_id){
        return ResponseEntity.ok(offerService.acceptOffer(offer_id));
}

}
