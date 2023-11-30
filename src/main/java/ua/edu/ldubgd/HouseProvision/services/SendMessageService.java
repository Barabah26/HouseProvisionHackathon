package ua.edu.ldubgd.HouseProvision.services;

import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ua.edu.ldubgd.HouseProvision.domains.BotUser;
import ua.edu.ldubgd.HouseProvision.domains.House;
import ua.edu.ldubgd.HouseProvision.domains.HouseQueue;
import ua.edu.ldubgd.HouseProvision.messageSender.MessageSender;

@Service
public class SendMessageService {
    private final MessageSender messageSender;
    private BotUserDataService botUserDataService;
    private HouseDataService houseDataService;
    private HouseQueueDataService houseQueueDataService;

    public SendMessageService(HouseQueueDataService houseQueueDataService ,MessageSender messageSender, BotUserDataService botUserDataService, HouseDataService houseDataService) {
        this.messageSender = messageSender;
        this.houseDataService = houseDataService;
        this.botUserDataService = botUserDataService;
        this.houseQueueDataService = houseQueueDataService;
    }

    /**
     * Надсилає просте текстове повідомлення до чату з вказаним текстом.
     *
     * @param messageFromUser Об'єкт, що представляє отримане повідомлення від користувача.
     * @param text    Текст повідомлення для надсилання.
     */
    public void sendMessage(Message messageFromUser, String text) {
        // Створення об'єкту SendMessage для надсилання текстового повідомлення
        SendMessage message = SendMessage.builder()
                .text(text)
                .chatId(String.valueOf(messageFromUser.getChatId()))
                .build();

        // Надсилання повідомлення за допомогою messageSender.sendMessage()
        messageSender.sendMessage(message);
    }

    /**
     * Надсилає текстове повідомлення до чату з клавіатурою відповіді.
     *
     * @param messageFromUser Об'єкт, що представляє отримане повідомлення від користувача.
     * @param text            Текст повідомлення для надсилання.
     * @param replyKeyboard   Об'єкт з клавіатурою відповіді (звичайна клавіатура з кнопками).
     */
    public void sendMessage(Message messageFromUser, String text, ReplyKeyboardMarkup replyKeyboard) {
        // Створення об'єкту SendMessage для надсилання текстового повідомлення з клавіатурою відповіді
        SendMessage message = SendMessage.builder()
                .text(text)
                .chatId(String.valueOf(messageFromUser.getChatId()))
                .replyMarkup(replyKeyboard)
                .build();
        messageSender.sendMessage(message);
    }

    public void sendRegister(Message message) {
        if (houseDataService.statusTelegramId(message.getChatId())) {
            House house = houseDataService.getHouseByTelegramId(message.getChatId());
            sendMessage(message, house.toString());
        } else {
            sendMessage(message, EmojiParser.parseToUnicode("На жаль, ваші дані відсутні у реєстрі" + "\uD83D\uDE14"));
        }
    }

    public void sendQueue(Message message) {
        if (houseQueueDataService.statusTelegramId(message.getChatId())) {
            HouseQueue houseQueue = houseQueueDataService.getUserQueue(message.getChatId());
            sendMessage(message, houseQueue.toString());
            System.out.println(message.getChatId().toString());
        } else {
            sendMessage(message, EmojiParser.parseToUnicode("На жаль, ваші дані відсутні у черзі" + "\uD83D\uDE14"));
        }

    }

}