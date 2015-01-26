package com.tony.examples.cxf;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.tony.examples.cxf.protocol.HelloRequest;
import com.tony.examples.cxf.protocol.HelloResponse;
import com.tony.examples.cxf.provider.ServiceExceptionMapper;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.transport.local.LocalConduit;
import org.apache.cxf.transport.local.LocalTransportFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Test Example by CXF WebClient(Proxy Direct Dispatch)
 *
 * https://cwiki.apache.org/confluence/display/CXF20DOC/JAXRS+Testing
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestServiceTest_4 {

    private final static String ENDPOINT_ADDRESS = "local://svc";
    private static Server server;

    @BeforeClass
    public static void initialize() throws Exception {
        startServer();
    }

    @AfterClass
    public static void destroy() throws Exception {
        server.stop();
        server.destroy();
    }

    private static void startServer() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(TestService.class);

        List<Object> providers = new ArrayList<>();
        providers.add(new JacksonJsonProvider());
        providers.add(new ServiceExceptionMapper());

        sf.setProviders(providers);

        sf.setResourceProvider(TestService.class, new SingletonResourceProvider(new TestService(), true));
        sf.setAddress(ENDPOINT_ADDRESS);

        server = sf.create();
    }

    @Test
    public void testHello_Get() throws Exception {
        RestService client = JAXRSClientFactory.create(ENDPOINT_ADDRESS, RestService.class);
        WebClient.getConfig(client).getRequestContext().put(LocalConduit.DIRECT_DISPATCH, Boolean.TRUE);

        String result = client.hello("Tester");

        System.out.println(result);
        Assert.assertEquals("Hello~ Tester", result);
    }

    @Test
    public void testHello_Post() throws Exception {
        List<Object> providers = new ArrayList<>();
        providers.add(new JacksonJsonProvider());
        providers.add(new ServiceExceptionMapper());

        RestService client = JAXRSClientFactory.create(ENDPOINT_ADDRESS, RestService.class, providers);
        WebClient.getConfig(client).getRequestContext().put(LocalConduit.DIRECT_DISPATCH, Boolean.TRUE);

        HelloRequest request = new HelloRequest();
        request.setName("Tester");
        HelloResponse result = client.hello(request);

        System.out.println(result);
        Assert.assertEquals("Hello~ Tester", result.getHello());
    }
}