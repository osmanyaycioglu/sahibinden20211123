package com.training.spring.order.clients;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.live.error.ErrorObj;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class MyRestErrorDecoder implements ErrorDecoder {

    @Override
    public MyErrorException decode(final String methodKeyParam,
                                   final Response responseParam) {
        try {
            InputStream asInputStreamLoc = responseParam.body()
                                                        .asInputStream();
            ObjectMapper mapperLoc = new ObjectMapper();
            ErrorObj readValueLoc = mapperLoc.readValue(asInputStreamLoc,
                                                        ErrorObj.class);
            return new MyErrorException(readValueLoc);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return new MyErrorException();
    }

}
