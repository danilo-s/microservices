package it.danilo.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.danilo.microservices.domain.Difficulty;
import it.danilo.microservices.domain.Region;
import it.danilo.microservices.domain.Tour;
import it.danilo.microservices.domain.TourPackage;
import it.danilo.microservices.repo.TourPackageRepository;
import it.danilo.microservices.repo.TourRepository;

@Service
public class TourService {

	private TourRepository tourRepository;
	private TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourService(TourRepository tourRepository,TourPackageRepository tourPackageRepository) {
		this.tourRepository=tourRepository;
		this.tourPackageRepository=tourPackageRepository;
	}
	
	public Tour createTour(String title,String description,String blurb,Integer price,String duration,
			String bullets,String keywords,String tourPackageName, Difficulty difficulty, Region region) {
		
		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
		if (tourPackage == null) {
            throw new RuntimeException("Tour package does not exist: " + tourPackageName);
        }

		Tour tour = new Tour(title, description,blurb, price, duration,
                bullets, keywords, tourPackage, difficulty, region);
				
		return tourRepository.save(tour);
		
	}
	
	public Iterable<Tour> lookup(){
		return tourRepository.findAll();
	}
	
	public Long total() {
		return tourRepository.count();
	}
}