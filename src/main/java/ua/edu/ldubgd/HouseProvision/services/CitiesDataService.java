package ua.edu.ldubgd.HouseProvision.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ldubgd.HouseProvision.domains.BotUser;
import ua.edu.ldubgd.HouseProvision.domains.Cities;
import ua.edu.ldubgd.HouseProvision.repositories.CitiesRepository;

import java.util.List;

@Service
public class CitiesDataService {

    private static CitiesRepository citiesRepository;

    @Autowired
    public CitiesDataService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }




    public boolean cityIsEmpty(String city) {


        List<Cities> citiesList = citiesRepository.findByCities(city);

        return citiesList.isEmpty();


    }
}
