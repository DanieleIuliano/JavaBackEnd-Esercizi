import BotBase.BotBase;
import BotListaSpesa.BotListaSpesa;
import BotRandomMedia.BotRandomMedia;
import com.botticelli.bot.Bot;
import com.botticelli.messagereceiver.MessageReceiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Main {

    public static String filePath;

    public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, UnknownHostException, SocketException
    {
        filePath = "C:\\Users\\Coldfierz\\Desktop\\Classroom java Developer Webtreeschool\\Repositori-esercizi-Github\\JavaBackEnd-Esercizi\\ModuloExtra-BotTelegram\\IlMioPrimoBot\\token.txt";
        File tokenFile = new File(filePath);
        String token = "";
        try (Scanner s = new Scanner(tokenFile))
        {
            while (s.hasNext())
            {
                token = s.nextLine();
            }
        }

        Bot bot = new BotListaSpesa(token);
        MessageReceiver mr = new MessageReceiver(bot, 500, 1);
        mr.ignoreEditedMessages();
        mr.start();

    }
}
