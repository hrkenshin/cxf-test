package com.tony.examples.cxf;

import com.tony.examples.cxf.protocol.HelloRequest;
import com.tony.examples.cxf.protocol.HelloResponse;

/**
 * TEST API
 */
public interface RestService {

    public String hello(String name);

    public HelloResponse hello(HelloRequest request);
}