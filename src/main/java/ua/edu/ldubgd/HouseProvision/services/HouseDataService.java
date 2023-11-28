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

    public static House getHouseById(Long houseId) {
//        написав метод який витягує список  користувачів із бази даних з необхідними
//                телеграм id і statement


        House house = new House();

        List<House> houses = houseRepository.findByHouseId(houseId);

        if (!houses.isEmpty()){
            house= houses.get(houses.size()-1);
        }
        return house;

    }

    public static House getHouseByUserId(Long userId){
        House house = new House();

        List<House> houses = houseRepository.findByBotUserId(userId);

        if (!houses.isEmpty()){
            house= houses.get(houses.size()-1);
        }
        return house;
    }

}
