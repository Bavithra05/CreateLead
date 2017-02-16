package wrappers;


public interface Wrappers {
void clickByLink(String link);
void clickByXPath(String xpath);
void loginUsername(String id, String username);
void loginPassword(String id, String password);
void launchBrowser(String url,String browser);
void enterById(String id,String val);
void clickByName(String name);
void quitBrowser();

}
