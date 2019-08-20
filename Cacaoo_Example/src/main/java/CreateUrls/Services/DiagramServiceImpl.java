package CreateUrls.Services;

import CreateUrls.HelperUtils.Helper;
import CreateUrls.Models.Diagram;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.SSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Puja on 19/08/19.
 */

@Service
public class DiagramServiceImpl implements  DiagramService{


   @Autowired
    private SslConfiguration sslConfiguration;


    private static final Logger logger = LoggerFactory.getLogger(DiagramServiceImpl.class);
      public ResponseEntity<String> getDiagram() throws Exception {



       // final String base = "https://cacoo.com/api/v1/diagrams.json?apiKey=smyUF8TbteJnZY2Zzi0T";

            final String base="https://google.com";
          ResponseEntity<String> result=null;

      //  final String base=encode(baseUrl);
          try {
              RestTemplate restTemplate=sslConfiguration.restTemplate();
              HttpHeaders headers = new HttpHeaders();
              headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
              headers.setContentType(MediaType.APPLICATION_JSON);
              logger.info("intro of the rest template ",base.toString());
              logger.info("Url invoked:  "+ headers.getContentType());
              HttpEntity<String> entity = new HttpEntity<String>(headers);
              result = restTemplate.exchange(base, HttpMethod.GET,entity,String.class);
              //logger.info("intro of the rest template ",result.getStatusCode()+ "  "+ restTemplate.getErrorHandler());
              logger.debug("Response of  "+result.getBody());
          } catch (HttpStatusCodeException exception) {
              int statusCode = exception.getStatusCode().value();

          }

        logger.info("URL to be invoked  "+ base);


        return result;


    }

    public static String encode(String input) {
        StringBuilder resultStr = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (isUnsafe(ch)) {
                resultStr.append('%');
                resultStr.append(toHex(ch / 16));
                resultStr.append(toHex(ch % 16));
            } else {
                resultStr.append(ch);
            }
        }
        return resultStr.toString();
    }

    private static char toHex(int ch) {
        return (char) (ch < 10 ? '0' + ch : 'A' + ch - 10);
    }

    private static boolean isUnsafe(char ch) {
        if (ch > 128 || ch < 0)
            return true;
        return " %$&+,/:;=?@<>#%".indexOf(ch) >= 0;
    }



}
