package ua.edu.ldubgd.HouseProvision.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.edu.ldubgd.HouseProvision.messageSender.MessageSender;
import ua.edu.ldubgd.HouseProvision.services.HouseQueueDataService;
import ua.edu.ldubgd.HouseProvision.services.SendMessageService;

import java.util.List;

@Component
public class MessageHandler implements Handler<Message>{
    private SendMessageService sendMessageService;
    private MessageSender messageSender;
    private static final String DOCUMENTS = EmojiParser.parseToUnicode("Перелік необхідних документів для отримання грошової " +
            "компенсації за піднайм(найм) житлових приміщень:\n\n" +
            "1\uFE0F⃣" + "Рапорт\n\n"
    + "2\uFE0F⃣" +"Копії документів, що посвідчують особу та підтверджують громадянство України військовослужбовця та членів його сім’ї;\n"
    + "3\uFE0F⃣" + "Копії документів, що засвідчують реєстрацію в Державному реєстрі фізичних осіб - платників податків (крім осіб, які через свої релігійні переконання відмовляються від прийняття реєстраційного номера облікової картки платника податків та повідомили про це відповідному контролюючому органу і мають відмітку в паспорті) військовослужбовця та членів його сім’ї;\n\n"
    + "4\uFE0F⃣" + "Інформацію (витяг, інформаційну довідку) з Державного реєстру речових прав на нерухоме майно та бюро технічної інвентаризації про нерухоме майно, яке належить військовослужбовцю та членам його сім’ї;\n"
    + "5\uFE0F⃣" + "Копії довідок про реєстрацію місця проживання (перебування), видані органом реєстрації, на військовослужбовця та кожного члена його сім’ї, який проживає разом з ним (військовослужбовці військових частин, які дислокувалися в населених пунктах, на території яких органи державної влади тимчасово не здійснюють свої повноваження, і які переміщені з місць попередньої дислокації, подають довідку про склад сім’ї, видану командиром (начальником) цієї військової частини (підрозділу);\n\n"
    + "6\uFE0F⃣" + "Копії свідоцтв про державну реєстрацію актів цивільного стану (про шлюб, розірвання шлюбу, про народження тощо), інших документів, що підтверджують родинні стосунки;\n\n"
    + "7\uFE0F⃣" + "Належним чином завірену копію довідки про забезпечення житлом з попереднього місця проходження військової служби, видану квартирно-експлуатаційним органом (службою) Міноборони, Національної гвардії, відповідним підрозділом СБУ, розвідувальними органами, Держприкордонслужби, Держспецзв’язку, Держспецтрансслужби, МОН, ДКА, Управління державної охорони (крім осіб, які прибули з тимчасово окупованої території України та населених пунктів, на території яких органи державної влади тимчасово не здійснюють свої повноваження)");


//    private final Cache<BotUser> cache;

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }
    private HouseQueueDataService houseQueueDataService;

    @Autowired
    public void setHouseQueueDataService(HouseQueueDataService houseQueueDataService) {
        this.houseQueueDataService = houseQueueDataService;
    }

    @Autowired
    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

//    public MessageHandler(Cache<BotUser> cache) {
//        this.cache = cache;
//
//    }



    @Override
    public void choose(Message message) {
        switch (message.getText()) {
            case "/start":
                sendMessageService.sendMessage(message, "импмрп");
                break;
            case "/queue":
//                sendMessageService.sendMessage(message,
//                        houseQueueDataService.getUserQueue(message.));
//
                break;
            case "/register":
                break;
            case "/compensation":
                break;
            case "/documents":
                sendMessageService.sendMessage(message, DOCUMENTS);
                break;
        }

    }
}
