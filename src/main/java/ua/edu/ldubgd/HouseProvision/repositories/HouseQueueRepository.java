package ua.edu.ldubgd.HouseProvision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.ldubgd.HouseProvision.domains.House;
import ua.edu.ldubgd.HouseProvision.domains.HouseQueue;

import java.util.List;

@Repository
public interface HouseQueueRepository extends JpaRepository<HouseQueue, Long> {
    List<HouseQueue> findByTelegramId(Long telegramId);


}
