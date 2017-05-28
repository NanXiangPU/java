package Objects;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Search implements Serializable{

    public static class SearchThread implements Runnable {

        private Thread t;
        private String[] wordsQuery;
        private Map<String, List<Integer>> wordMapping;
        private Map<Integer, String> pageMapping;
        private Map<String, Integer> resMap;

        public SearchThread(String s, String[] wordsQuery, Map<String, List<Integer>> wordMapping, Map<Integer, String> pageMapping, Map<String, Integer> resMap) {
            this.t = new Thread(s);
            this.wordsQuery = wordsQuery;
            this.wordMapping = wordMapping;
            this.pageMapping = pageMapping;
            this.resMap = resMap;
        }

        public Thread getT() {
            return t;
        }

        public void setT(Thread t) {
            this.t = t;
        }

        public String[] getWordsQuery() {
            return wordsQuery;
        }

        public void setWordsQuery(String[] wordsQuery) {
            this.wordsQuery = wordsQuery;
        }

        public Map<String, List<Integer>> getWordMapping() {
            return wordMapping;
        }

        public void setWordMapping(Map<String, List<Integer>> wordMapping) {
            this.wordMapping = wordMapping;
        }

        public Map<Integer, String> getPageMapping() {
            return pageMapping;
        }

        public void setPageMapping(Map<Integer, String> pageMapping) {
            this.pageMapping = pageMapping;
        }

        public Map<String, Integer> getResMap() {
            return resMap;
        }

        public void setResMap(Map<String, Integer> resMap) {
            this.resMap = resMap;
        }

        @Override
        public void run() {
            for (String word : wordsQuery) {
                List<Integer> list = wordMapping.get(word);
                if (list == null || list.size() == 0) {
                    continue;
                }
                for (Integer i : list) {
                    String url = pageMapping.get(i);
                    if (!resMap.containsKey(url)) {
                        resMap.put(url, 1);
                    } else {
                        resMap.put(url, resMap.get(url) + 1);
                    }
                }
            }
        }
    }

    private String wordsFile;
    private String pageFile;
    private final int threadNum = 5;


    public Search(String wordsFile, String pageFile) {
        this.wordsFile = wordsFile;
        this.pageFile = pageFile;
    }

    public String getWordsFile() {
        return wordsFile;
    }

    public void setWordsFile(String wordsFile) {
        this.wordsFile = wordsFile;
    }

    public String getPageFile() {
        return pageFile;
    }

    public void setPageFile(String pageFile) {
        this.pageFile = pageFile;
    }


    public List<Result> executeQuery(String query) throws IOException, ClassNotFoundException, InterruptedException {
        String[] wordsQuery = query.split(" ");

        FileUtils f = new FileUtils();
        List<Page> parsed = f.readParsed("parsed.txt");
        List<Word> words = f.readWords("words.txt");


        Map<Integer, Integer> map = new HashMap<>();
        Map<String, List<Integer>> wordMapping = new HashMap<>();
        Map<Integer, String> pageMapping = new HashMap<>();

        for (Word word : words) {
            if (!wordMapping.containsKey(word.getWord())) {
                List<Integer> list = word.getList();
                wordMapping.put(word.getWord(), list);
            }
        }

        for (Page p : parsed) {
            if (!pageMapping.containsKey(p.getURLID())) {
                pageMapping.put(p.getURLID(), p.getURL());
            }
        }

        List<Result> res = new ArrayList<>();
        Map<String, Integer> resMap = Collections.synchronizedMap(new HashMap<String, Integer>());

        /*
         * single thread implementation
         */
        /*
        for (String word : wordsQuery) {
            List<Integer> list = wordMapping.get(word);
            if (list == null || list.size() == 0) {
                continue;
            }
            for (Integer i : list) {
                String url = pageMapping.get(i);
                if (!resMap.containsKey(url)) {
                    resMap.put(url, 1);
                } else {
                    resMap.put(url, resMap.get(url) + 1);
                }
            }
        }
        */


        int residue = wordsQuery.length % 5;
        int chuckSize = wordsQuery.length / threadNum;
        for (int i = 0; i < threadNum; ++i) {
            SearchThread sThread;
            sThread = new SearchThread("Thread " + i, Arrays.copyOfRange(wordsQuery, i * chuckSize, (i + 1) * chuckSize), wordMapping, pageMapping, resMap);
            System.out.println("Created thread " + i);
            System.out.println("Thread " + i + " is running");
            Thread t = new Thread(sThread);
            t.start();
            t.join();
        }
        int finished = chuckSize * threadNum;
        if (residue != 0) {
            for (int i = 0; i < residue; ++i) {
                SearchThread sThread;
                sThread = new SearchThread("Thread " + i, Arrays.copyOfRange(wordsQuery, finished + i, finished + i + 1), wordMapping, pageMapping, resMap);
                System.out.println("Created thread " + i);
                System.out.println("Thread " + i + " is running");
                Thread t = new Thread(sThread);
                t.start();
                t.join();
            }
        }

        for (String key : resMap.keySet()) {
            Result r = new Result(key, resMap.get(key));
            res.add(r);
        }

        Collections.sort(res, new Comparator<Result>() {
            @Override
            public int compare(Result a, Result b) {
               return b.getScore() - a.getScore();
           }
        });

        return res;
    }

}
