package Objects;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Crawler implements Serializable {
    private Parser ps;
    private Map<String, Integer> urlMapping;
    private List<Page> parsed;
    private List<Word> words;
    private String url;
    private FileUtils fu;

    public FileUtils getFu() {
        return fu;
    }

    public void setFu(FileUtils fu) {
        this.fu = fu;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    private int limit;

    public Crawler(String url, int limit) {
        this.ps = new Parser();
        this.urlMapping = new HashMap<>();
        this.url = url;
        this.limit = limit;
        this.parsed = new ArrayList<>();
        this.words = new ArrayList<>();
        this.fu = new FileUtils();
    }

    public List<Page> getParsed() {
        return parsed;
    }

    public void setParsed(List<Page> parsed) {
        this.parsed = parsed;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Parser getPs() {
        return ps;
    }

    public void setPs(Parser ps) {
        this.ps = ps;
    }

    public Map<String, Integer> getUrlMapping() {
        return urlMapping;
    }

    public void setUrlMapping(Map<String, Integer> urlMapping) {
        this.urlMapping = urlMapping;
    }

    public void crawl() throws ParseException, IOException {
        Map<String, List<Integer>> map = new HashMap<>();

        Document d = this.ps.getDocument(url);
        Elements links = this.ps.getLinks(d);
        if (links.size() > limit) {
            System.out.println("Too many links");
            return;
        }
        int num = 1;
        for (Element e : links) {
            if (isValidUrl(e.attr("abs:href")) && !urlMapping.containsKey(e.attr("abs:href"))) {
                urlMapping.put(e.attr("abs:href"), num++);
                Page p = new Page(e.attr("abs:href"), urlMapping.get(e.attr("abs:href")));
                this.parsed.add(p);
                Document tmp = this.ps.getDocument(e.attr("abs:href"));
                String body = this.ps.getBody(tmp);
                String[] words = body.split(" ");
                for (String word : words) {
                    if (!map.containsKey(word)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(urlMapping.get(e.attr("abs:href")));
                        map.put(word, list);
                    } else {
                        List<Integer> list = map.get(word);
                        list.add(urlMapping.get(e.attr("abs:href")));
                    }
                }
            }
        }

        for (String word : map.keySet()) {
            List<Integer> list = map.get(word);
            Word w = new Word(word, list.get(0));
            for (int i = 1; i < list.size(); ++i) {
                w.addURLID(list.get(i));
            }
            this.words.add(w);
        }

        String pageFile = "parsed.txt";
        String wordsFile = "words.txt";
        this.fu.savePageTable(this.parsed, pageFile);
        this.fu.saveWordTable(this.words, wordsFile);
    }

    public boolean isValidUrl(String url) {
        return !url.toLowerCase().endsWith(".pdf") && (url.startsWith("http://") || url.startsWith("https://"));
    }

    public static void main(String[] args) throws ParseException, IOException {
        String url = "https://cs.purdue.edu";
        int limit = 250;
        Crawler c = new Crawler(url, limit);
        c.crawl();
    }
}
