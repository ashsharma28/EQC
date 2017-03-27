/**
 * Created by Ashish Sharma on 19-Mar-17.
 */
public class KeywordCorpusWrapper {
    String[] matchekeywords =null;

    public int[] getKeywordPriority() {
        return keywordPriority;
    }

    public void setKeywordPriority(int[] keywordPriority) {
        this.keywordPriority = keywordPriority;
    }

    int keywordPriority[] = null;

    public String[] getMatchekeywords() {
        return matchekeywords;
    }

    public void setMatchekeywords(String[] matchekeywords) {
        this.matchekeywords = matchekeywords;
    }


    public String[] queryFromDB() {
        //TODO queryFromDB
        return new String[0];
    }



}
