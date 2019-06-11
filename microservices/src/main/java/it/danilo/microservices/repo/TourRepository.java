package it.danilo.microservices.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.danilo.microservices.domain.Tour;

public interface TourRepository extends PagingAndSortingRepository<Tour,Integer>{
	
    Page<Tour> findByTourPackageCode(String code,Pageable pageable);

}
