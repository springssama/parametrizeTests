package guru.qa;

public enum GoogleSearchResults {
    ALL(0, "QA.GURU"),
    VIDEOS(1, "Qa Guru");

    public final int chapter;
    public final String result;

    GoogleSearchResults(int chapter, String result) {
        this.chapter = chapter;
        this.result = result;
    }


}
