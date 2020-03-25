package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter
{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] meesageSent = event.getMessage().getContentRaw().split(" ");
        //누군가 디코서버에서 전송한 메시지 저장

        if(meesageSent[0].equalsIgnoreCase("!hello"))
        {
            event.getChannel().sendMessage("Hi").queue(); //어느 서버채널에서 보냈는지 확인하고 출력   .queue() 필수
        }
    }
}
