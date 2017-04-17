package Objects;

import java.io.*;
import java.util.List;

public class FileUtils {
    public void saveWordTable(List<Word> words, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(fileName));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(words);
        fos.close();
        oos.close();
    }

    public void savePageTable(List<Page> pages, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(fileName));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(pages);
        fos.close();
        oos.close();
    }

    public List<Page> readParsed(String fileName) throws IOException, ClassNotFoundException {
      /* Create output streams for the File and Objects */
        FileInputStream fis = new FileInputStream(new File(fileName));
        ObjectInputStream ois = new ObjectInputStream(fis);

      /* Create a Student object and apply a cast to the read in object */
        List<Page> parsed = (List<Page>) ois.readObject();
        ois.close();
        fis.close();

        return parsed;
    }

    public List<Word> readWords(String fileName) throws IOException, ClassNotFoundException {
        /* Create output streams for the File and Objects */
        FileInputStream fis = new FileInputStream(new File(fileName));
        ObjectInputStream ois = new ObjectInputStream(fis);

      /* Create a Student object and apply a cast to the read in object */
        List<Word> words = (List<Word>) ois.readObject();
        ois.close();
        fis.close();

        return words;
    }
}
