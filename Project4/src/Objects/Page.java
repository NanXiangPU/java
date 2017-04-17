package Objects;


import java.io.Serializable;

public class Page extends Object implements Serializable, Comparable<Page>
{
    public static final long serialVersionUID=	-1827677255104766839L;
    String url;
    private int urlID;

    public Page(String url, int urlID){
        this.url=url;
        this.urlID=urlID;
    }

    public int getURLID(){
        return urlID;
    }

    public String getURL(){
        return url;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Page)){
            return false;
        }
        Page kappa = (Page) obj;
        return(kappa.getURL()==this.url||kappa.getURLID()==this.urlID);

    }

    public int compareTo(Page candidate){
        if(urlID<candidate.getURLID()){
            return -1;
        }
        if(urlID==candidate.getURLID()){
            return 0;
        }
        return 1;
    }
}
