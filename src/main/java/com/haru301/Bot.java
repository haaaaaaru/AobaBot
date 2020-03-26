package com.haru301;

import com.haru301.events.CommandBase;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import static net.dv8tion.jda.api.entities.Activity.playing;

public class Bot
{
    public static void main(String args[]) throws Exception
    {
        JDA builder = new JDABuilder("NjkyMjI5MjcxODcxMTYwMzUy.Xnw35Q.-txsZcXexEFzLDgN0Lu4iHHTE4I").build();
        //저 token을 자기 봇 토큰으로 변경할것
        builder.getPresence().setStatus(OnlineStatus.IDLE);
        builder.getPresence().setActivity(playing("!아오바 도움말 | "));

        builder.addEventListener(new CommandBase()); //커맨드 register
    }
}
