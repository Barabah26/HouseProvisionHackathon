package ua.edu.ldubgd.HouseProvision.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ldubgd.HouseProvision.domains.Cities;
import ua.edu.ldubgd.HouseProvision.domains.ConstructionCostByRegion;
import ua.edu.ldubgd.HouseProvision.repositories.ConstructionCostByRegionRepository;

import java.util.List;

@Service
public class ConstructionCostByRegionDataService {

    private static ConstructionCostByRegionRepository constructionCostByRegionRepository;

    @Autowired
    public ConstructionCostByRegionDataService(ConstructionCostByRegionRepository constructionCostByRegionRepository) {
        this.constructionCostByRegionRepository = constructionCostByRegionRepository;
    }

    public double compensation(String city){

        List<ConstructionCostByRegion> constructionCostByRegionList = constructionCostByRegionRepository.findByCity(city);

        return constructionCostByRegionList.getFirst().getCost();

    }
}
