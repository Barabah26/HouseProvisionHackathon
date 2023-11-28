package ua.edu.ldubgd.HouseProvision.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ldubgd.HouseProvision.domains.BotUser;
import ua.edu.ldubgd.HouseProvision.repositories.BotUserRepository;

import java.util.List;

@Service
public class BotUserDataService {

    private static BotUserRepository botUserRepository;
    @Autowired
    public BotUserDataService(BotUserRepository botUserRepository) {
        this.botUserRepository = botUserRepository;
    }

    public static BotUser getAllInfoAboutUser(String phoneNumber) {

        BotUser botUser=new BotUser();

        List<BotUser> botUsers=botUserRepository.findByPhoneNumber(phoneNumber);

        if (!botUsers.isEmpty()){
            botUser= botUsers.getFirst();
        }
        return botUser;

    }

    public Boolean statusRegistration(String phoneNumber){
        BotUser botUser = new BotUser();

        List<BotUser> botUsers=botUserRepository.findByPhoneNumber(phoneNumber);

        if (!botUsers.isEmpty()){
            botUser= botUsers.getFirst();
        }

        return botUser.isEntered();
    }

    public Boolean statusNumber(String phoneNumber){
        /**
         *повертає fals якщо контакту немає в базі даних
         */

        List<BotUser> botUsers= botUserRepository.findByPhoneNumber(phoneNumber);
//        for (BotUser user: botUsers) {
//            System.out.println(user);
//        }
        return botUsers.isEmpty();
    }
}
