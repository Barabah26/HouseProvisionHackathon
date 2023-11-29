package ua.edu.ldubgd.HouseProvision.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.edu.ldubgd.HouseProvision.domains.MenuText;
import ua.edu.ldubgd.HouseProvision.messageSender.MessageSender;
import ua.edu.ldubgd.HouseProvision.services.BotUserDataService;
import ua.edu.ldubgd.HouseProvision.services.HouseQueueDataService;
import ua.edu.ldubgd.HouseProvision.services.SendMessageService;

import java.awt.*;

@Component
public class MessageHandler implements Handler<Message> {
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
        if (message.hasText()) {
            String textFromUser = message.getText();
            if (botUserDataService.statusTelegramId(message.getChatId())) {
                switch (textFromUser) {
                    case "/start":
                        sendMessageService.sendMessage(message, MenuText.START_MESSAGE);
                        sendMessageService.sendMessage(message, "На жаль, Ваші дані відсутні в системі, " +
                                "тому ви не можете використовувати весь функціонал чат-боту" + "☹\uFE0F");
                        break;
                    case "/documents":
                        sendMessageService.sendMessage(message, MenuText.DOCUMENTS);
                        break;

                    case "/queue":
                    case "/register":
                    case "/compensation":
                        sendMessageService.sendMessage(message, "Ви не авторизований користувач" + "☹\uFE0F");
                        break;

                    default:
                        sendMessageService.sendMessage(message, "Ви ввели невірну команду" + "☹\uFE0F");

                        break;
                }
            } else {
                switch (textFromUser) {
                    case "/start":
                        sendMessageService.sendMessage(message, MenuText.START_MESSAGE);
                        sendMessageService.sendMessage(message, "Для того щоб отримати відповідь на потрібне вам " +
                                "питання скористайтеся кнопкою 'Меню'" + "\uD83D\uDC47");
                        break;
                    case "/queue":
                        sendMessageService.sendQueue(message);
                        break;
                    case "/register":
                        sendMessageService.sendRegister(message);
                        break;
                    case "/compensation":
                        sendMessageService.sendMessage(message, "місячна компенсація");
                        sendMessageService.sendMessage(message,
                                Double.toString(botUserDataService.compensationInMonth(message.getChatId())));

                        sendMessageService.sendMessage(message, "орієнтовний час окуплення квартири ");
                        sendMessageService.sendMessage(message, Integer.toString(botUserDataService.timeOfCompensation(message.getChatId())));

                        break;
                    case "/documents":
                        sendMessageService.sendMessage(message, MenuText.DOCUMENTS);
                        break;
                    default:
                        sendMessageService.sendMessage(message, "Вви ввели невірну команду" + "☹\uFE0F");
                        break;
                }
            }

        }

    }
}
