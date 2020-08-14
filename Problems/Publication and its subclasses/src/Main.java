class Publication {

    private final String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        return getType() + ": " + getDetails();
    }

    public String getType() {
        return "Publication";
    }

    public String getDetails() {
        return title;
    }

}

class Newspaper extends Publication {
// Newspaper (source - Sport news): Football results

    private final String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    public String getType() {
        return "Newspaper (source - " + source + ")";
    }

}

class Article extends Publication {
// Article (author - Dr James Smith): Why the Sun is hot

    private final String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getType() {
        return "Article (author - " +  author + ")";
    }

}

class Announcement extends Publication {
// Announcement (days to expire - 30): Will sell a house

    private final int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    public String getType() {
        return "Announcement (days to expire - " + daysToExpire + ")";
    }

}
