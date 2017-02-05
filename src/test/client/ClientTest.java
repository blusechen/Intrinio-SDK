package client;

import domain.Company;
import domain.CompanyCompact;
import domain.Security;
import domain.SecurityCompact;
import org.junit.Test;
import tags.StockExchangeTags;

import java.util.Optional;

/**
 * Created by Bruce on 2/4/2017.
 */
public class ClientTest {
    private String user = "USER_HERE";
    private String pass = "PASS_HERE";
    private IntrinioClient ic = new IntrinioClient(this.user, this.pass);

    @Test
    public void testGetCompanyInfo(){
        Optional<Company> result = this.ic.getCompanyInformation("AAPL");
        if(result.isPresent()){
            System.out.println(result.get().toString());
        }else{
            System.out.println("No company found");
        }

    }

    @Test
    public void testCompanySearchQuery(){
        Optional<CompanyCompact[]> result = this.ic.searchCompanies("alphabet");
        if(result.isPresent()){
            CompanyCompact[] companies = result.get();
            for(CompanyCompact c: companies){
                System.out.println(c.toString());
            }
        }else{
            System.out.println("No companies found");
        }
    }

    @Test
    public void testGetSecurityInfo(){
        Optional<Security> result = this.ic.getSecurityInformation("AAPL");
        if(result.isPresent()){
            System.out.println(result.get().toString());
        }else{
            System.out.println("No company found");
        }

    }

    @Test
    public void testSecuritySearchQuery() {
        Optional<SecurityCompact[]> result = this.ic.searchSecuritiesByQuery("apple");
        if (result.isPresent()) {
            SecurityCompact[] securites = result.get();
            for (SecurityCompact c : securites) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("No companies found");
        }
    }

    @Test
    public void testSecuritySearchExchange() {
        Optional<SecurityCompact[]> result = this.ic.searchSecuritiesByExchange(StockExchangeTags.NASDAQ);
        if (result.isPresent()) {
            SecurityCompact[] securites = result.get();
            for (SecurityCompact c : securites) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("No companies found");
        }
    }
}
