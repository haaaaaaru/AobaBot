package com.haru301.events;


import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandBase extends ListenerAdapter
{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        Member messageSender = event.getMember(); //누가 보냈는지
        String[] messageSent = event.getMessage().getContentRaw().split(" "); //누가 보낸 메시지 배열저장

        GuildMessageReceived message = new GuildMessageReceived(); //인스턴스생성




        message.commandEvent(event, messageSender, messageSent);
    }


    //util
    public static String sitejoin(String glue, String anime)
    {
        return glue + anime;
    }

    //util
    public static String arrayJoin(String glue, String array[]) {
        String result = "";

        for (int i = 2; i < array.length; i++) {
            result += array[i];
            if (i < array.length - 1) result += glue;
        }
        return result;
    }
}
