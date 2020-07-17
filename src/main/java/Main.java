import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.net.URLEncoder;
import java.util.List;

class Main{
    public static void main(String args[]){

       WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = "https://index.hu/techtud/";
            HtmlPage page = client.getPage(searchUrl);

            List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("(//*[@id=\"ajanlok\"]/li)") ;
            if(items.isEmpty()){
                System.out.println("No items found !");
            }else{

                for(HtmlElement htmlItem : items){
                    HtmlElement titleElement = ((HtmlElement) htmlItem.getFirstByXPath(".//h1/a[@class='cim']")) ;

                    String title = titleElement == null ? "Nincs cim" : titleElement.asText();
                    System.out.println(title);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}