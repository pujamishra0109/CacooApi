package CreateUrls.Controller;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CreateUrls.Models.Diagram;
import CreateUrls.Services.DiagramService;
import DTO.DiagramResult;

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
        return "hello!";
    }



    @RequestMapping(value = "/user/", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<Diagram> diagramDetails() throws Exception{
    	 ResponseEntity<Diagram> result
           = helperService.getDiagram();

     
        return result;}
    



    @RequestMapping(value = "/searchDate", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<DiagramResult>> searchWordDate(@RequestParam String str,@RequestParam(required=false) String startDate,@RequestParam(required=false)String endDate) throws Exception{
    	 
    	ResponseEntity<List<DiagramResult>> result= helperService.getSerachResult(str,startDate,endDate);

     
        return result;}



}
