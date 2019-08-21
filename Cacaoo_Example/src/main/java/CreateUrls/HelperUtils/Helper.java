package CreateUrls.HelperUtils;

import CreateUrls.Models.Diagram;
import CreateUrls.Services.DiagramService;
import CreateUrls.Services.DiagramServiceImpl;
import DTO.DiagramResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.*;

import CreateUrls.Models.*;;


/**
 * Created by Puja on 19/08/19.
 */

@Service
public class Helper {
	
	 @Autowired
	 private DiagramService helperService;

	 private static final Logger logger = LoggerFactory.getLogger(Helper.class);
	   
	public List<DiagramResult> getSearchResult(String str) throws Exception {
		
		Diagram diagram=helperService.getDiagramDetails();
		if(diagram==null)
			return null;
		List<DiagramResult> resultList=new ArrayList<DiagramResult>();
		ArrayList<DiagramValue> diagramValue=diagram.getResult();
		for(DiagramValue diagramValueObj : diagramValue) {
			DiagramResult diagramResult=new DiagramResult();
			if(checkEqual(str,diagramValueObj))
			{
				if(diagramValueObj.getTitle()!=null)
				diagramResult.setTitle(diagramValueObj.getTitle());
				
				if(diagramValueObj.getDiagramId()!=null)
				diagramResult.setDiagramId(diagramValueObj.getDiagramId());
				
				if(diagramValueObj.getUrl()!=null)
				diagramResult.setUrl(diagramValueObj.getUrl());
				
				if(diagramValueObj.getDescription()!=null)
				diagramResult.setDescription(diagramValueObj.getDescription());
				
				resultList.add(diagramResult);
			}
				
		}
		return resultList;
		
		
	}
	
	public boolean checkEqual(String str,DiagramValue diagramValueObj) {
		
		String title=diagramValueObj.getTitle();
		String description=diagramValueObj.getDescription();
		logger.info("title and des  "+ title +" "+ description );
		if(str.equalsIgnoreCase(title))
			return true;
	
		String s1="";
		for(int i=0;i<title.length();i++) {
			
				if(!Character.isLetter(title.charAt(i)))
			{
				if(s1.equalsIgnoreCase(str))return true;
					logger.info("String matched or not : "+ s1);
				s1="";
			}
				else
					s1+=String.valueOf(title.charAt(i));
		}
		if(s1.equalsIgnoreCase(str))return true;
		
	
		String s="";
		
		for(int j=0;j<description.length();j++) {
			
				if(!Character.isLetter(description.charAt(j)))
			{
				if(s.equalsIgnoreCase(str))return true;
				s="";
			}
				else
					s+=String.valueOf(description.charAt(j));
		}
		if(s.equalsIgnoreCase(str))return true;
		return false;
		
		
	}
    

}
