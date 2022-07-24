package pages;

public class Pages {
    private static LoginPage loginPage;

    public static LoginPage getInitialPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
