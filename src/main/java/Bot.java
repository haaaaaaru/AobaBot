import events.HelloEvent;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Bot
{
    public static void main(String args[]) throws Exception
    {
        JDA builder = new JDABuilder("NjkyMjA2NDMwNjc3MTA2NzM5.Xnrf7g.w9CRdkoj8V5CIDc64wOxuKhDPP4").build();

        builder.addEventListener(new HelloEvent());
    }
}
