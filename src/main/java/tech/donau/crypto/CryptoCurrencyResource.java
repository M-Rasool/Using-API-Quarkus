package tech.donau.crypto;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import tech.donau.crypto.data.Currency;
import tech.donau.crypto.service.CurrencyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/crypto")
public class CryptoCurrencyResource {

    @Inject
    @RestClient
    CurrencyService currencyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Currency> hello(@QueryParam("id") String id) {
        return currencyService.getCurrency(id);
    }
}