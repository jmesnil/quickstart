package org.jboss.as.quickstarts.rshelloworld;

import java.net.MalformedURLException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.arquillian.api.ContainerResource;
import org.jboss.as.arquillian.container.ManagementClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@RunAsClient
public class HelloServiceIT {

    @ContainerResource
    private ManagementClient managementClient;

    private Client client;

    @Before
    public void before() throws MalformedURLException {
        client = ClientBuilder.newClient();
    }

    @After
    public void after() {
        if (client != null) {
            client.close();
        }
    }

    @Test
    public void testJSONEndpoint() {
        Response response =  client
                .target(managementClient.getWebUri())
                .path("/rest/json")
                .request()
                .get();

        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("{\"result\":\"Hello World!\"}", response.readEntity(String.class));

        response.close();
    }

    @Test
    public void testXMLEndpoint() {
        Response response =  client
                .target(managementClient.getWebUri())
                .path("/rest/xml")
                .request()
                .get();

        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals("<xml><result>Hello World!</result></xml>", response.readEntity(String.class));

        response.close();
    }
}
