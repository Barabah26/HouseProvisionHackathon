package ua.edu.ldubgd.HouseProvision.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.edu.ldubgd.HouseProvision.domains.MenuText;
import ua.edu.ldubgd.HouseProvision.keyboards.Keyboards;
import ua.edu.ldubgd.HouseProvision.messageSender.MessageSender;
import ua.edu.ldubgd.HouseProvision.services.BotUserDataService;
import ua.edu.ldubgd.HouseProvision.services.HouseQueueDataService;
import ua.edu.ldubgd.HouseProvision.services.SendMessageService;

@Component
public class MessageHandler implements Handler<Message>{
    private SendMessageService sendMessageService;
    private MessageSender messageSender;
    private BotUserDataService botUserDataService;

    private HouseQueueDataService houseQueueDataService;

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Autowired
    public void setHouseQueueDataService(HouseQueueDataService houseQueueDataService) {
        this.houseQueueDataService = houseQueueDataService;
    }
    
    @Autowired
    public void setBotUserDataService(BotUserDataService botUserDataService) {
        this.botUserDataService = botUserDataService;
    }

    @Autowired
    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(Message message) {
        if(message.hasText()){
            String textFromUser=message.getText();
            if(botUserDataService.statusTelegramId(message.getChatId())){
                switch (textFromUser) {
                case "/start":
                    sendMessageService.sendMessage(message, "старт");
                    break;
                case "/documents":
                    sendMessageService.sendMessage(message, MenuText.DOCUMENTS);
                    break;
                default:
                    sendMessageService.sendMessage(message, "Ви не авторизований користувач");
                    break;
            }
            }else {
                switch (textFromUser) {
                    case "/start":
                        sendMessageService.sendMessage(message, "старт");
                        break;
                    case "/queue":
                        sendMessageService.sendQueue(message);
                        break;
                    case "/register":
                        sendMessageService.sendRegister(message);
                        break;
                    case "/compensation":
                        break;
                    case "/documents":
                        sendMessageService.sendMessage(message, MenuText.DOCUMENTS);
                        break;
                    default:
                        sendMessageService.sendMessage(message, "Вибачте, ви ввели невірну команду");
                        break;
                }
            }

        }

        }
}
