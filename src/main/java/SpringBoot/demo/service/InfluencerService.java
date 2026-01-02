package SpringBoot.demo.service;

import SpringBoot.demo.model.Influencer;
import SpringBoot.demo.repository.InfluencerRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@Service
public class InfluencerService {
private final InfluencerRepository influencerRepository;

    public InfluencerService(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    public Influencer saveInfluencers(Influencer influencer){

        return influencerRepository.save(influencer);
    }

    public Page<Influencer> findAllInfluencers(Pageable pageable){ // burayı page ile güncelleyebilirim
        return influencerRepository.findAll(pageable);
    }
}
