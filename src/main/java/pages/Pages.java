package pages;

public class Pages {
    private static InitialPage initialPage;

    public static InitialPage getInitialPage() {
        if (initialPage == null) {
            initialPage = new InitialPage();
        }
        return initialPage;
    }
}
