import events.HelloEvent;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Bot
{
    public static void main(String args[]) throws Exception
    {
        JDABuilder builder = new JDABuilder((AccountType.BOT));
        builder.setToken("NjkyMjA2NDMwNjc3MTA2NzM5.XnrKLg.atIpvd4DNYS1-_IP8EhjRcftop4");
        JDA jda =  builder.build();
        jda.addEventListener(new HelloEvent());
    }
}