package ua.edu.ldubgd.HouseProvision.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.edu.ldubgd.HouseProvision.domains.MenuText;
import ua.edu.ldubgd.HouseProvision.keybords.Keyboard;
import ua.edu.ldubgd.HouseProvision.messageSender.MessageSender;
import ua.edu.ldubgd.HouseProvision.services.BotUserDataService;
import ua.edu.ldubgd.HouseProvision.services.HouseQueueDataService;
import ua.edu.ldubgd.HouseProvision.services.SendMessageService;

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
                        sendMessageService.sendMessage(message, "Виберіть інформацію, яка вам потрібна ⤵", Keyboard.chooseDocuments());
                        break;
                    case "Компенсація за піднайом(найом)":
                        sendMessageService.sendMessage(message, MenuText.DOCUMENTS1,Keyboard.chooseDocuments());
                        break;
                    case "Компенсація за належне їм для Отримання  жиле приміщення":
                        sendMessageService.sendMessage(message, MenuText.DOCUMENTS2,Keyboard.chooseDocuments());
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
                        sendMessageService.sendMessage(message, "Виберіть тип компенсації:⤵\uFE0F", Keyboard.chooseCompensation());
                        break;
                    case "Розрахунок компенсації за піднайом(найом)":
                        sendMessageService.sendMessage(message, "Місячна компенсація ");
                        sendMessageService.sendMessage(
                                message,
                                Double.toString(
                                        botUserDataService.compensationInMonth(message.getChatId())));
                        break;
                    case "Розрахунок компенсації за належне їм для отримання  жиле приміщення":
                        sendMessageService.sendMessage(message, "Місячна компенсація ");
                        sendMessageService.sendMessage(
                                message,
                                Double.toString(
                                        botUserDataService.secondCompensationInMonth(message.getChatId())));
                        break;
                    case "/documents":
                        sendMessageService.sendMessage(message, "Виберіть інформацію, яка вам потрібна ⤵", Keyboard.chooseDocuments());
                        break;
                    case "Компенсація за піднайом(найом)":
                        sendMessageService.sendMessage(message, MenuText.DOCUMENTS1,Keyboard.chooseDocuments());
                        break;
                    case "Компенсація за належне їм для Отримання  жиле приміщення":
                        sendMessageService.sendMessage(message, MenuText.DOCUMENTS2,Keyboard.chooseDocuments());
                        break;
                    default:
                        sendMessageService.sendMessage(message, "Вви ввели невірну команду" + "☹\uFE0F");
                        break;
                }
            }
        }
    }
}