package it.danilo.microservices.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.danilo.microservices.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage,String>{
	
	TourPackage findByName(@Param("name")String name);

}
