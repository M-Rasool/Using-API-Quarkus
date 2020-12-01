package tech.donau.crypto.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import tech.donau.crypto.data.Currency;
import tech.donau.crypto.data.MultipartBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@RegisterRestClient(configKey = "config.api.crypto")
@Path("echo")
public interface CurrencyService {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    String sendFile(@MultipartForm MultipartBody body);


}
