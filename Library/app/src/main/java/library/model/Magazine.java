package library.model;

public class Magazine extends Publication {
    private final int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getInfo() {
        return String.format("Magazine: %s by %s (%d), Issue #: %d", title, author, year, issueNumber);
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}
