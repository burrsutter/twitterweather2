package com.burrsutter.twitterweather2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.util.CamelLogger;


public class MyHandler {
    private final CamelLogger logger = new CamelLogger(MyHandler.class.getCanonicalName(), LoggingLevel.INFO);
    
    @Handler
    public void process(final Exchange exchange)
    {
        final Message message = exchange.getIn();
        final String text = message.getBody(String.class);
        String location = null;
        logger.log("Received " + text);
        logger.log(message.getBody().getClass().getCanonicalName());
        final Map<String, String> map = message.getBody(HashMap.class);
        if (map != null) {
        	logger.log("Location: " + map.get("location"));
        	location = map.get("location");
        	exchange.getOut().setHeader("tweetlocation", location);
        }
        //	exchange.getOut().setHeader("tweetlocation", location);
       exchange.getOut().setBody(exchange.getIn().getBody());
       
    }
}
