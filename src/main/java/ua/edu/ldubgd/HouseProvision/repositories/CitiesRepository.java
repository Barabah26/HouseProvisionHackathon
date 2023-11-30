package ua.edu.ldubgd.HouseProvision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.ldubgd.HouseProvision.domains.Cities;

import java.util.List;

@Repository
public interface CitiesRepository extends JpaRepository<Cities,Long> {
    List<Cities> findByCities(String city);


}
