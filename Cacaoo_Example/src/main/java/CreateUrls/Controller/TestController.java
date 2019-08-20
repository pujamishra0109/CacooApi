package CreateUrls.Controller;

import CreateUrls.Services.DiagramService;
import CreateUrls.Services.DiagramServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Puja on 18/08/19.
 */
@RestController
public class TestController {

    @Autowired
    DiagramService helperService;


    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/welcome")
    public String home() {

//        final String base = "http://cacoo.com/api/v1/diagrams.json?apiKey=smyUF8TbteJnZY2Zzi0T";
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        logger.info("intro of the rest template ",base.toString());
//
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        ResponseEntity<String> result = restTemplate.exchange(base, HttpMethod.GET,entity,String.class);
//        //logger.info("intro of the rest template ",result.getStatusCode()+ "  "+ restTemplate.getErrorHandler());
//        logger.debug("Response of  "+result.getBody());
//
//

        return "hello!";
    }



    @RequestMapping(value = "/user/", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<String> diagramDetails() throws Exception{
        ResponseEntity<String> result=null;
           result  = helperService.getDiagram();

        String obj=result.getBody();

        return new ResponseEntity<String >(obj,HttpStatus.OK);
    }


}
