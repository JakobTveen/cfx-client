package dk.itveen;

import cfx.service.HelloService;
import io.quarkiverse.cxf.annotation.CXFClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/cxf/hello-client")
public class CxfClientRestResource {

    @CXFClient("myHello")
    HelloService helloService;

    @GET
    @Path("/say")
    @Produces(MediaType.TEXT_PLAIN)
    public String say(@QueryParam("who") String who) {
        return helloService.hello(who);
    }

}
