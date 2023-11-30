package ua.edu.ldubgd.HouseProvision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.ldubgd.HouseProvision.domains.Cities;
import ua.edu.ldubgd.HouseProvision.domains.ConstructionCostByRegion;

import java.util.List;

@Repository
public interface ConstructionCostByRegionRepository extends JpaRepository<ConstructionCostByRegion, Long> {
    List<ConstructionCostByRegion> findByCity(String city);

}
