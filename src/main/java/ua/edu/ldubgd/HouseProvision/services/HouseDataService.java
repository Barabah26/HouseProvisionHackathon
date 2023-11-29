package ua.edu.ldubgd.HouseProvision.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ldubgd.HouseProvision.domains.House;
import ua.edu.ldubgd.HouseProvision.repositories.HouseRepository;

import java.util.List;

@Service
public class HouseDataService {

    private static HouseRepository houseRepository;

    @Autowired
    public HouseDataService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public static House getHouseByTelegramId(Long userId){
        House house = new House();

        List<House> houses = houseRepository.findByTelegramId(userId);

        if (!houses.isEmpty()){
            house= houses.get(houses.size()-1);
        }
        return house;
    }

    public Boolean statusTelegramId(Long telegramId) {
        List<House> houses = houseRepository.findByTelegramId(telegramId);
        return !houses.isEmpty();
    }


}
