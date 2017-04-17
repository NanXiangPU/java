package Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;
import java.text.ParseException;

public class Parser implements Serializable{

    public Parser(){}

    public Document getDocument(String url)
            throws ParseException {
        Document d = null;
        if (url == null) {
            throw new ParseException("getDocument() failed. String url is null.", 0);
        }

        if (url.equals("")) {
            throw new ParseException("getDocument() failed. String url is empty.", 1);
        }
        try {
            d = Jsoup.connect(url).get();
        }catch (Exception e) {
            throw new ParseException("getDocument() failed. Connection failed.", 2);
        }
        if (d == null) {
            throw new ParseException("getDocument() failed: Document is null.", 3);
        }
        return d;
    }


    public Elements getLinks(Document doc) throws ParseException{
        if(doc == null){
            throw new ParseException("getLinks() failed. Document parameter is null.", 4);
        }
        Elements links = doc.select("a[href]");
        return links;
    }

    public String getBody(Document doc) throws ParseException{
        if(doc==null){
            throw new ParseException("getBody() failed. Document parameter is null.", 5);
        }
        Element body = doc.body();
        String content = body.text();
        return content;
    }
}