package com.example.parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ParserTask {
    @Autowired
    private News news1;

    public String parseNews() {
        String url = "https://weather.rambler.ru/v-almaty/?ysclid=ld2zoaiui7979768920";

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();
            Elements news = doc.getElementsByClass("HhSR MBvM");
            for (Element el: news) {
                String title = el.ownText();
                    news1.setTitle(title);
                System.out.println(news1.getTitle());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return news1.getTitle();
    }
}
