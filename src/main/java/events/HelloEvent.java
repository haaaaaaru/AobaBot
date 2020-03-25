package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter
{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] meesageSent = event.getMessage().getContentRaw().split(" ");
        //누군가 디코서버에서 전송한 메시지 저장
        if(!event.getMember().getUser().isBot()) //그 누군가가 봇이 아닌지 체크
        {

            if(meesageSent[0].equals("!안녕")) //첫번째 문자열 체크
            {
                event.getChannel().sendMessage("안녕! " + event.getMember().getAsMention()).queue(); //어느 서버채널에서 보냈는지 확인하고 출력   .queue() 필수
            }
        }


    }
}
