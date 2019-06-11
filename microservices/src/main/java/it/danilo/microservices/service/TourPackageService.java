package it.danilo.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.danilo.microservices.domain.TourPackage;
import it.danilo.microservices.repo.TourPackageRepository;

@Service
public class TourPackageService {

	private TourPackageRepository tourPackageRepository;

	@Autowired
	public TourPackageService(TourPackageRepository tourPackageRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public TourPackage createTourPackage(String code, String name) {
		if (!tourPackageRepository.existsById(code)) {
			TourPackage tourPackage = new TourPackage(code, name);
			return this.tourPackageRepository.save(tourPackage);
		}
		return null;
	}

	public Iterable<TourPackage> lookup(){
		return this.tourPackageRepository.findAll();
	}
	
	public Long getTotal() {
		return this.tourPackageRepository.count();
	}
		
}
