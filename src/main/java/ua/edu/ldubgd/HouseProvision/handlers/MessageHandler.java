package ua.edu.ldubgd.HouseProvision.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.edu.ldubgd.HouseProvision.domains.MenuText;
import ua.edu.ldubgd.HouseProvision.keyboards.Keyboards;
import ua.edu.ldubgd.HouseProvision.messageSender.MessageSender;
import ua.edu.ldubgd.HouseProvision.services.BotUserDataService;
import ua.edu.ldubgd.HouseProvision.services.HouseQueueDataService;
import ua.edu.ldubgd.HouseProvision.services.SendMessageService;

import java.util.List;

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
        if (message.getText().equals("/start")) {
            sendMessageService.sendMessage(message, "старт", Keyboards.phoneKeyboard());

//            if (message.getContact() != null) {
//                // Перевірка на null перед викликом getPhoneNumber()
//                String phoneNumber = message.getContact().getPhoneNumber();
//
//                if (botUserDataService.statusNumber(phoneNumber)) {
//                    sendMessageService.sendMessage(message, "ok");
//                    System.out.println(phoneNumber);
//                } else {
//                    sendMessageService.sendMessage(message, "bad");
//                    System.out.println(phoneNumber);
//                }
//            } else {
//                // Обробка ситуації, коли getContact() повертає null
//                sendMessageService.sendMessage(message, "bad");
//                System.out.println("Phone number is not available");
//            }
        }
        else {
            switch (message.getText()) {
                case "/queue":
//                sendMessageService.sendMessage(message,
//                        houseQueueDataService.getUserQueue(message.));
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
