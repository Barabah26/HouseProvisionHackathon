package ua.edu.ldubgd.HouseProvision.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ldubgd.HouseProvision.domains.BotUser;
import ua.edu.ldubgd.HouseProvision.domains.House;
import ua.edu.ldubgd.HouseProvision.domains.HouseQueue;
import ua.edu.ldubgd.HouseProvision.repositories.HouseQueueRepository;
import ua.edu.ldubgd.HouseProvision.repositories.HouseRepository;

import java.util.List;

@Service
public class HouseQueueDataService {

    private static HouseQueueRepository houseQueueRepository;

    @Autowired
    public HouseQueueDataService(HouseQueueRepository houseQueueRepository) {
        this.houseQueueRepository=houseQueueRepository;

    }

    public HouseQueue getUserQueue(Long telegramId) {

        HouseQueue houseQueue = new HouseQueue();

        List<HouseQueue> houseQueues = houseQueueRepository.findByTelegramId(telegramId);

        if (!houseQueues.isEmpty()){
            houseQueue = houseQueues.get(houseQueues.size()-1);
        }
        return houseQueue;

    }
    public Boolean statusTelegramId(Long telegramId) {
        List<HouseQueue> houseQueues = houseQueueRepository.findByTelegramId(telegramId);
        return !houseQueues.isEmpty();
    }

}
