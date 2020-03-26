import com.clickntap.vimeo.Vimeo;
import com.clickntap.vimeo.VimeoResponse;
import events.CommandBase;
import events.GuildMessageReceived;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import java.io.File;

import static net.dv8tion.jda.api.entities.Activity.playing;

public class Bot
{
    public static void main(String args[]) throws Exception
    {
        JDA builder = new JDABuilder("NjkyMjI5MjcxODcxMTYwMzUy.XnsPIw.U4byf0w5k92qpb-9re8p2yEKGDk").build();
        //저 token을 자기 봇 토큰으로 변경할것
        builder.getPresence().setStatus(OnlineStatus.IDLE);
        builder.getPresence().setActivity(playing("!아오바 도움말 | "));

        builder.addEventListener(new CommandBase()); //커맨드 register
    }
}
