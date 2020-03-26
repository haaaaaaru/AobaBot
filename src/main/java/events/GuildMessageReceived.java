package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.IOException;

public class GuildMessageReceived extends CommandBase
{
    protected void commandEvent(GuildMessageReceivedEvent event, Member messageSender, String[] m)
    {
        EmbedBuilder eb = new EmbedBuilder();

        if(event.getMember().getUser().isBot()) //그 누군가가 봇이 아닌지 체크
        {
            return;
        }

        if (m[0].equals("!아오바"))
        {
            if (m.length <= 1) //!아오바만 했을경우
            {
                event.getChannel().sendMessage("...?").queue();
                return;
            }

            switch (m[1])
            {
                case "안녕":
                    event.getChannel().sendMessage("안녕! " + messageSender.getAsMention()).queue();
                    return;
                case "도움말":
                    eb.setTitle("명령어 목록");
                    eb.setColor(Color.yellow);
                    eb.addField("명령어 목록", "!아오바 도움말", false);
                    eb.addField("", "!아오바 애니", false);
                    eb.addField("", "!아오바 안녕", false);
                    eb.setFooter("Made by Haru301|!!@3979");
                    event.getChannel().sendMessage(eb.build()).queue();

                    return;
                case "아키히코":
                    event.getChannel().sendMessage("작작해라 " + messageSender.getAsMention()).queue();
                    return;
                case "애니":
                    if (m.length == 2)
                    {
                        event.getChannel().sendMessage(messageSender.getAsMention() + " 보고싶으신 애니와 회차수를 뒤에 입력해주세요!").queue();
                        event.getChannel().sendMessage("`Ex. !아오바 애니 뉴게임 1화`   ").queue();
                        return;
                    }
                    if (m.length > 2)
                    {
                        String anime = arrayJoin("+", m);
                        String url = sitejoin("https://panogas.com/?cat=2&s=", anime);
                        Document doc = null;
                        String link1 = null;
                        String name1 = null;

                        String photolink1 = null;

                        String infotext = null;

                        String infotextfinal = null;

                        try
                        {
                            doc = Jsoup.connect(url).get();
                            Elements links = doc.select("a[href]");
                            int linktrash = 0;

                            for (Element link : links)
                            {
                                if (linktrash == 0)
                                {
                                    link1 = link.attr("href");
                                    name1 = link.text();
                                    linktrash++;
                                }
                            }

                            Elements imags = doc.getElementsByTag("img");

                            for (Element src : imags)
                            {
                                photolink1 = src.attr("abs:src");
                            }

                            //여기까지가 검색후 화면 정리
                            //이제부터 들어갔을때

                            url = link1;
                            doc = Jsoup.connect(url).get();
                            Elements texts = doc.select("div").select(".hrecipe").select(".infomation");
                            infotext = texts.text();
                            /*for (Element text : texts)
                            {
                                infotext = text.attr()
                            }*/
                            if (infotext.contains("Info ::"))
                            {
                                int idx = infotext.indexOf("o :: ") + 5;

                                infotextfinal = infotext.substring(idx);
                                //System.out.println(infotextfinal);
                            }
                            else
                            {
                                infotextfinal = "없음";
                            }

                        }catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                        if (link1 == "https://panogas.com" || photolink1 == null)
                        {
                            event.getChannel().sendMessage(messageSender.getAsMention() + " 해당 애니를 찾을수 없네요.. 제목에 유의해서 검색해주세요!").queue();
                            return;
                        }else
                        {
                            eb.setAuthor("::  검색 결과  ::");
                            eb.setTitle(name1, link1);
                            eb.setColor(Color.yellow);
                            eb.setThumbnail(photolink1);
                            eb.addField("제목", name1, true);
                            eb.addField("줄거리" , infotextfinal, false);
                            eb.setFooter("Made by Haru301|!!@3979");
                            event.getChannel().sendMessage(eb.build()).queue();
                            event.getChannel().sendMessage("`Tip: 원하시는 결과가 나오지 않았을경우 검색어, 띄어쓰기를 조정해보세요!`").queue();

                            //System.out.println(name1);
                            //System.out.println(link1);
                            //System.out.println(photolink1);
                        }
                    }
                    return;

            }
        }


    }


}
