import events.HelloEvent;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Bot
{
    public static void main(String args[]) throws Exception
    {
        JDA builder = new JDABuilder("NjkyMjA2NDMwNjc3MTA2NzM5.Xnrjxw.YY9dTI6fpoiXkcR-gGf99XG_fWk").build();

        builder.addEventListener(new HelloEvent());
    }
}
