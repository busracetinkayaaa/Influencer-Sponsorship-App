package SpringBoot.demo.service;

import SpringBoot.demo.exception.InsufficientBudgetException;
import SpringBoot.demo.exception.ResourceNotFoundException;
import SpringBoot.demo.model.Brand;
import SpringBoot.demo.model.Influencer;
import SpringBoot.demo.model.Offer;
import SpringBoot.demo.repository.BrandRepository;
import SpringBoot.demo.repository.InfluencerRepository;
import SpringBoot.demo.repository.OfferRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final BrandRepository brandRepository;
    private final InfluencerRepository influencerRepository;

    public OfferService(OfferRepository offerRepository, BrandRepository brandRepository, InfluencerRepository influencerRepository) {
        this.offerRepository = offerRepository;
        this.brandRepository = brandRepository;
        this.influencerRepository = influencerRepository;
    }
    @Transactional
    public Offer createOffer(Long influencer_id,Long brand_id,double moneyAmount){
        Influencer influencer=influencerRepository.findById(influencer_id).orElseThrow(()-> new ResourceNotFoundException("Influencer bulunamadı."));
        Brand brand= brandRepository.findById(brand_id).orElseThrow(()-> new ResourceNotFoundException("Marka bulunamadı."));

        Offer offer = new Offer();
        offer.setInfluencer(influencer);
        offer.setBrand(brand);

        if(influencer.getFollowers()<10.000 || influencer.getEngagementRate()<2.0){
            throw new IllegalStateException("Bu influencer markanın minimum kriterlerini (10k takipçi / %2 etkileşim) karşılamıyor.");
        }

        offer.setMoneyAmount(moneyAmount);
        offer.setAccepted(false);
        return offerRepository.save(offer);
    }

    @Transactional
    public Offer acceptOffer(Long offer_id){
        Offer offer = offerRepository.findById(offer_id).orElseThrow(()-> new ResourceNotFoundException("Teklif bulunamadı"));

        if(offer.isAccepted()){
            throw new InsufficientBudgetException("Teklif zaten kabul edilmiş");
        }

        Brand brand= offer.getBrand();
        if(brand.getBudget()< offer.getMoneyAmount()){
            throw new InsufficientBudgetException("Markanın bütçesi:"+ offer.getBrand().getBudget()+ "teklif için yetersiz");
        }

        brand.setBudget(brand.getBudget()-offer.getMoneyAmount());
        offer.setAccepted(true);

        Influencer influencer=offer.getInfluencer();
        influencer.setTotalEarnings(influencer.getTotalEarnings()+offer.getMoneyAmount());

        brandRepository.save(brand);
        influencerRepository.save(influencer);

        return offerRepository.save(offer);

    }


    public Page<Offer> findOffers(Long influencer_id, Long brand_id, Pageable pageable){
        if(influencer_id!=null){
            return offerRepository.findByInfluencer_id(influencer_id,pageable);
        }
        else if(brand_id!=null){
            return offerRepository.findByBrand_id(brand_id,pageable);
        }
        return offerRepository.findAll(pageable);
    }





}
