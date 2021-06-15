package BotRandomMedia;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.*;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.Random;

public class BotRandomMedia extends Bot {

    ArrayList<String> listaImmagini = new ArrayList<>();
    ArrayList<String> listaVoice = new ArrayList<>();
    ArrayList<String> listaStickerz = new ArrayList<>();


    public BotRandomMedia(String token) {
        super(token);
    }

    @Override
    public void textMessage(Message message) {
    }

    @Override
    public void audioMessage(Message message) {

    }

    @Override
    public void videoMessage(Message message) {

    }

    @Override
    public void voiceMessage(Message message) {
        listaVoice.add(message.getVoice().getFileID());
        Random rand = new Random();
        int index = rand.nextInt(listaVoice.size()-1);
        sendVoicebyReference(new VoiceReferenceToSend(message.getFrom().getId(), listaVoice.get(index)));
    }

    @Override
    public void stickerMessage(Message message) {
        listaStickerz.add(message.getSticker().getFileID());
        Random rand = new Random();
        int index = rand.nextInt(listaStickerz.size()-1);
        sendStickerbyReference(new StickerReferenceToSend(message.getFrom().getId(), listaStickerz.get(index)));
    }

    @Override
    public void documentMessage(Message message) {

    }

    @Override
    public void photoMessage(Message message) {
        listaImmagini.add(message.getPhoto().get(0).getFileID());
        Random rand = new Random();
        int index = rand.nextInt(listaImmagini.size()-1);
        sendPhotobyReference(new PhotoReferenceToSend(message.getFrom().getId(), listaImmagini.get(index)));
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
