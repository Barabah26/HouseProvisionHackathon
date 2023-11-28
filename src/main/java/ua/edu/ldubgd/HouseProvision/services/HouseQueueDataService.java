package ua.edu.ldubgd.HouseProvision.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public HouseQueue getUserQueue(Long userId) {
//        написав метод який витягує список  користувачів із бази даних з необхідними
//                телеграм id і statement


        HouseQueue houseQueue = new HouseQueue();

        List<HouseQueue> houseQueues = houseQueueRepository.findByUserId(userId);

        if (!houseQueues.isEmpty()){
            houseQueue = houseQueues.getFirst();
        }
        return houseQueue;

    }

}
