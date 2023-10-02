package org.example.Browser;

import java.util.List;

public interface BrowserInterface {
    public void seePage(Page pagina);
    public void newPage();
    public String reloadPage(Page pagina);
    public void seeAllPages(List<Page> paginas);
    public void removePage();
}
