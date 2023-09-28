package attornatus.teste.javajr.service;

import attornatus.teste.javajr.domain.entities.City;
import attornatus.teste.javajr.repository.CityRepository;
import attornatus.teste.javajr.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City findCityByID(Long id){
        return cityRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Error: City not found."));
    }
}
