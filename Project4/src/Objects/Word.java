package Objects;

import java.io.Serializable;
import java.util.*;


public class Word extends Object implements Serializable
{
    public static final long serialVersionUID= -3696191086353573895L;
    private List<Integer> list = new ArrayList<>();
    private String word;

    public Word(String word, int urlID){
        this.word=word;
        list.add(urlID);
    }

    public void addURLID(int urlID){
        list.add(urlID);
    }

    public String getWord(){
        return word;
    }

    public List<Integer> getList(){
        return list;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Word)){
            return false;
        }
        Word greyFaceNoSpace = (Word) obj;
        return greyFaceNoSpace.getWord().equals(word);
    }
}