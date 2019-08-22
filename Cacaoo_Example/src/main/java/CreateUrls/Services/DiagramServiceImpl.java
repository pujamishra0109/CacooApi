package CreateUrls.Services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import CreateUrls.Models.Diagram;
import CreateUrls.Services.SSLUtil;
import DTO.DiagramResult;
import CreateUrls.*;
import CreateUrls.HelperUtils.Helper;






/**
 * Created by Puja on 19/08/19.
 */

@Service
public class DiagramServiceImpl implements  DiagramService{


   @Autowired
    private SslConfiguration sslConfiguration;
   
   @Autowired
   private Helper helper;
   
   @Value("${apiKey}")
   private String apiKey;

   
   
   
   ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(DiagramServiceImpl.class);
    public ResponseEntity<Diagram> getDiagram() throws Exception {

    		Diagram diagram= getDiagramDetails();
    		if(diagram==null)
    			return new ResponseEntity<Diagram >(diagram,HttpStatus.NO_CONTENT);
    					
    		return new ResponseEntity<Diagram >(diagram,HttpStatus.OK);
        }
    
    
    
    
    public Diagram getDiagramDetails() throws Exception {

        final String base = "https://cacoo.com/api/v1/diagrams.json?apiKey="+ apiKey;
        System.out.println("get diagram");
        Diagram diagram=null;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            SSLUtil.turnOffSslChecking();
            HttpEntity<Diagram> entity = new HttpEntity<Diagram>(headers);
            diagram = objectMapper.readValue((restTemplate.exchange(base, HttpMethod.GET, entity, String.class)).getBody(),Diagram.class);
            
            logger.debug("Response of  " + diagram);
            SSLUtil.turnOnSslChecking();
        } catch (HttpStatusCodeException exception) {
            exception.printStackTrace();
          
        }

        System.out.println("URL to be invoked  " + base);

        return diagram;
    }

    public ResponseEntity<List<DiagramResult>> getSerachResult(String str,String startDate,String endDate) throws Exception {

    	List<DiagramResult> result=new ArrayList<DiagramResult>();
    	
    		result= helper.getSearchResultSorted(str,startDate,endDate);

    		if(result==null)
    		return new ResponseEntity<List<DiagramResult> >(result,HttpStatus.NO_CONTENT);
        
    	return new ResponseEntity<List<DiagramResult> >(result,HttpStatus.OK);
        
    }

  


}
