import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ouo {
    public static void main(String[] args) throws IOException {
        try {
            String URL_1 = "https://ck101.com";
            String URL_2 = "";
            String URL_board = "";
            Document index_2 = new Document("");

            Document index_1 = Jsoup.connect(URL_1).get();
            System.out.println(index_1.title());
            Element head = index_1.select("div.channel_title_h1").first();
            System.out.println("======="+head.text()+"======="); //channel_menu sticky_position_with_15

            Elements boards = index_1.select("div.indexWp_page__left a");
            for(Element w : boards){
                String sum_boards_text = w.text();
                URL_board = URL_1 + w.attr("href");
                System.out.println("<"+sum_boards_text +"  "+URL_board+">");
            }
            Elements headline = index_1.select("div.article_container");
            Element table = headline.select("table").last();
            Elements tbody = table.select("tbody");
            System.out.println();
            System.out.println("============<最新看板>============");
            System.out.println();
             Elements tr = tbody.select("tr");
                    for (Element y : tr) {
                        Elements td = y.select("td a");
                        URL_2 = URL_1 + td.attr("href");

                        System.out.println(URL_2);
                        index_2 = Jsoup.connect(URL_2).get();
                        System.out.println(index_2.title());
                        Element views = index_2.select("div.views").first();
                        Element replys = index_2.select("div.replys").first();
                        System.out.println("===>" + views.text() + "  " + replys.text());
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
