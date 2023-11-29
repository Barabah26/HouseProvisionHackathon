package ua.edu.ldubgd.HouseProvision.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ldubgd.HouseProvision.domains.BotUser;
import ua.edu.ldubgd.HouseProvision.domains.House;
import ua.edu.ldubgd.HouseProvision.repositories.BotUserRepository;

import java.util.List;

@Service
public class BotUserDataService {

    private BotUserRepository botUserRepository;

    @Autowired
    public BotUserDataService(BotUserRepository botUserRepository) {
        this.botUserRepository = botUserRepository;
    }

    public BotUser getAllInfoAboutUser(String phoneNumber) {

        BotUser botUser = new BotUser();

        List<BotUser> botUsers = botUserRepository.findByPhoneNumber(phoneNumber);

        if (!botUsers.isEmpty()) {
            botUser = botUsers.get(0);
        }
        return botUser;

    }

    public BotUser getAllInfoAboutUser(Long telegramId) {

        BotUser botUser = new BotUser();

        List<BotUser> botUsers = botUserRepository.findByTelegramId(telegramId);

        if (!botUsers.isEmpty()) {
            botUser = botUsers.get(0);
        }
        return botUser;

    }

    public double compensationInMonth(Long telegramId) {
        BotUser botUser = getAllInfoAboutUser(telegramId);
        House house = HouseDataService.getHouseByTelegramId(telegramId);

        double compensation = 0;
        if (house.getLocation().equals("Київ")) {
            compensation = 3800.0;
        } else {
            compensation = 2850.0;
        }

        if (botUser.getFamilyMembers() >= 3) {
            compensation = compensation * 1.5;
        }

        return compensation;
    }

    public int timeOfCompensation(Long telegramId){
        House house = HouseDataService.getHouseByTelegramId(telegramId);

        double compensation = compensationInMonth(telegramId);



        return (int) Math.ceil((house.getCost()/compensation)/12) ;
    }

    public Boolean statusNumber(String phoneNumber) {
        /**
         *повертає fals якщо контакту немає в базі даних
         */

        List<BotUser> botUsers = botUserRepository.findByPhoneNumber(phoneNumber);
//        for (BotUser user: botUsers) {
//            System.out.println(user);
//        }
        return botUsers.isEmpty();
    }

    public Boolean statusTelegramId(Long telegramId) {
        List<BotUser> botUsers = botUserRepository.findByTelegramId(telegramId);
        return botUsers.isEmpty();
    }


}
