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
    private ConstructionCostByRegionDataService constructionCostByRegionDataService;

    @Autowired
    public BotUserDataService(BotUserRepository botUserRepository, ConstructionCostByRegionDataService constructionCostByRegionDataService, CitiesDataService citiesDataService) {
        this.botUserRepository = botUserRepository;
        this.constructionCostByRegionDataService = constructionCostByRegionDataService;
        this.citiesDataService = citiesDataService;
    }

    private CitiesDataService citiesDataService;


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

        double compensation = 2589.0;

        if (botUser.getCity().equals("Київ")) {
            compensation = compensation*2;
        } else if(!citiesDataService.cityIsEmpty(botUser.getCity())){
            compensation = compensation*1.5;
        }

        if (botUser.getFamilyMembers() >= 3) {
            compensation = compensation * 1.5;
        }
        return compensation;
    }

    public double secondCompensationInMonth(Long telegramId) {
        BotUser botUser = getAllInfoAboutUser(telegramId);

        double compensation =  (13.65*botUser.getFamilyMembers()+17)
                *constructionCostByRegionDataService.compensation(botUser.getCity());

        return Math.ceil(compensation);

    }

    public Boolean statusTelegramId(Long telegramId) {
        List<BotUser> botUsers = botUserRepository.findByTelegramId(telegramId);
        return botUsers.isEmpty();
    }




}
