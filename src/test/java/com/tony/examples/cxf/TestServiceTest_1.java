package com.tony.examples.cxf;

import com.tony.examples.cxf.protocol.HelloRequest;
import com.tony.examples.cxf.protocol.HelloResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test Example by Spring RestTemplate
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestServiceTest_1 {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testHello_Get() throws Exception {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/svc/test/hello.do?name=Lee", String.class);
        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void testHello_Post() throws Exception {
        HelloRequest request = new HelloRequest();
        ResponseEntity<HelloResponse> entity = restTemplate.postForEntity("http://localhost:8080/svc/test/hello.do", request, HelloResponse.class);
        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
    }

}