package ua.edu.ldubgd.HouseProvision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.ldubgd.HouseProvision.domains.House;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    List<House> findByHouseId(Long houseId);

    List<House> findByBotUserId(Long userId);

}
