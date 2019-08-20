package CreateUrls.HelperUtils;

import CreateUrls.Models.Diagram;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;

/**
 * Created by Puja on 19/08/19.
 */

@Service
public  class Helper {


    public static ResponseEntity<Diagram> returnDiagram() {

        final String base = "https://cacoo.com/api/v1/diagrams.json?apiKey=smyUF8TbteJnZY2Zzi0T";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<Diagram> result = restTemplate.exchange(base, HttpMethod.GET,null,Diagram.class);
        return result;


    }

}
