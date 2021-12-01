package com.live.error;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class MyRestErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String methodKeyParam,
                            final Response responseParam) {
        try {
            InputStream asInputStreamLoc = responseParam.body()
                                                        .asInputStream();
            //            if (responseParam.status() == 500) {
            //                return new RetryableException(0, methodKeyParam, null, null, null);
            //            }
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
