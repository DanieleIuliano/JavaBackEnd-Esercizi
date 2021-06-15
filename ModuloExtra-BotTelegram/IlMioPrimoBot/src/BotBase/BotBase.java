package BotBase;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;

public class BotBase extends Bot {

    public BotBase(String token) {
        super(token);
    }

    @Override
    public void textMessage(Message message) {

        String userUtente = message.getFrom().getUserName();
        MessageToSend risposta;

        switch (messaggioRicevuto(message)){

            case ERRORE:

                MessageToSend mts = new MessageToSend(message.getFrom().getId(), "Errore, messaggio non valido");
                sendMessage(mts);
                break;

            case SALUTA:

                if(checkUsername(message)){

                    MessageToSend messageBenvenuto = new MessageToSend(message.getFrom().getId(), "Ciao: " + message.getFrom().getFirstName());
                    sendMessage(messageBenvenuto);
                    return;

                }

                else {

                    MessageToSend messageBenvenuto = new MessageToSend(message.getFrom().getId(), userUtente);
                    sendMessage(messageBenvenuto);

                }
                break;

            case MONOPATTINO:

                risposta = new MessageToSend(message.getFrom().getId(), "Esercizio Facile");
                sendMessage(risposta);
                break;

            case SCOOTER:

                risposta = new MessageToSend(message.getFrom().getId(), "Esercizio Medio");
                sendMessage(risposta);
                break;

            case MOTO:

                risposta = new MessageToSend(message.getFrom().getId(), "Esercizio Difficile");
                sendMessage(risposta);
                break;

            case TASTIERA:

                List<List<KeyboardButton>> tastiera = keyboardTelegram();
                ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(tastiera);
                replyKeyboard.setResizeKeyboard(true);
                risposta = new MessageToSend(message.getFrom().getId(), "Ecco la tastiera");
                risposta.setReplyMarkup(replyKeyboard);
                sendMessage(risposta);
                return;

        }

    }
    public TipoMessaggio messaggioRicevuto(Message message){

        if(message.getText().equalsIgnoreCase("Ciao"))

            return TipoMessaggio.SALUTA;

        if(message.getText().equalsIgnoreCase("Tastiera"))

            return TipoMessaggio.TASTIERA;

        if(message.getText().equalsIgnoreCase("\uD83D\uDEF4"))

            return TipoMessaggio.MONOPATTINO;

        if(message.getText().equalsIgnoreCase("\uD83D\uDEF5"))

            return TipoMessaggio.SCOOTER;

        if(message.getText().equalsIgnoreCase("\uD83C\uDFCD"))

            return TipoMessaggio.MOTO;

        return TipoMessaggio.ERRORE;

    }

    // metodo che controlla se ha un nickname
    public boolean checkUsername(Message message) {
        if (message.getChat().getUserName() == null) return false;
        else return true;
    }


    public List<List<KeyboardButton>> keyboardTelegram(){

        List<List<KeyboardButton>> keyboard = new ArrayList<>();
        List<KeyboardButton> line = new ArrayList<>();
        line.add(new KeyboardButton("\uD83D\uDEF4"));
        line.add(new KeyboardButton("\uD83D\uDEF5"));
        line.add(new KeyboardButton("\uD83C\uDFCD"));
        keyboard.add(line);
        return keyboard;
    }

    @Override
    public void audioMessage(Message message) {

    }

    @Override
    public void videoMessage(Message message) {

    }

    @Override
    public void voiceMessage(Message message) {

    }

    @Override
    public void stickerMessage(Message message) {

    }

    @Override
    public void documentMessage(Message message) {

    }

    @Override
    public void photoMessage(Message message) {

    }

    @Override
    public void contactMessage(Message message) {

    }

    @Override
    public void locationMessage(Message message) {

    }

    @Override
    public void venueMessage(Message message) {

    }

    @Override
    public void newChatMemberMessage(Message message) {

    }

    @Override
    public void newChatMembersMessage(Message message) {

    }

    @Override
    public void leftChatMemberMessage(Message message) {

    }

    @Override
    public void newChatTitleMessage(Message message) {

    }

    @Override
    public void newChatPhotoMessage(Message message) {

    }

    @Override
    public void groupChatPhotoDeleteMessage(Message message) {

    }

    @Override
    public void groupChatCreatedMessage(Message message) {

    }

    @Override
    public void inLineQuery(InlineQuery inlineQuery) {

    }

    @Override
    public void chose_inline_result(ChosenInlineResult chosenInlineResult) {

    }

    @Override
    public void callback_query(CallbackQuery callbackQuery) {

    }

    @Override
    public void gameMessage(Message message) {

    }

    @Override
    public void videoNoteMessage(Message message) {

    }

    @Override
    public void pinnedMessage(Message message) {

    }

    @Override
    public void preCheckOutQueryMessage(PreCheckoutQuery preCheckoutQuery) {

    }

    @Override
    public void shippingQueryMessage(ShippingQuery shippingQuery) {

    }

    @Override
    public void invoiceMessage(Message message) {

    }

    @Override
    public void successfulPaymentMessage(Message message) {

    }

    @Override
    public void routine() {

    }
}
