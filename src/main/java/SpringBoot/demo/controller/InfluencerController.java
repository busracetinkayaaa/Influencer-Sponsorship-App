package SpringBoot.demo.controller;

import SpringBoot.demo.model.Influencer;
import SpringBoot.demo.service.InfluencerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }
@PostMapping
    public ResponseEntity<Influencer> create(@RequestBody Influencer influencer){
        return ResponseEntity.ok(influencerService.saveInfluencers(influencer));
    }
    @GetMapping
    public ResponseEntity<Page<Influencer>> findAllInfluencers(Pageable pageable){
        return ResponseEntity.ok(influencerService.findAllInfluencers(pageable));
    }


}
