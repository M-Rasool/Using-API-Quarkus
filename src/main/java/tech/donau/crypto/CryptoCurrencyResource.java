package tech.donau.crypto;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import tech.donau.crypto.data.Currency;
import tech.donau.crypto.data.MultipartBody;
import tech.donau.crypto.service.CurrencyService;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.util.Collection;

@Path("/echo")
public class CryptoCurrencyResource {

    @Inject
    @RestClient
    CurrencyService currencyService;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String echoFile(String body) {
        return body;
    }


    @POST
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String callEcho() {
        final MultipartBody multipartBody = new MultipartBody();
        multipartBody.setFile(new ByteArrayInputStream("Hello World".getBytes()));
        multipartBody.setName("hello.txt");
        return currencyService.sendFile(multipartBody);
    }

}