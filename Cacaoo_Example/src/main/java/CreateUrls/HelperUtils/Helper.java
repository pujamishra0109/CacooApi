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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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
	  
	            SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

	 
	 DateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
	 
	public List<DiagramResult> getSearchResult(String str,String  startDate,String endDate) throws Exception {
		
		Diagram diagram=helperService.getDiagramDetails();
		if(diagram==null)
			return null;
		List<DiagramResult> resultList=new ArrayList<DiagramResult>();
		ArrayList<DiagramValue> diagramValue=diagram.getResult();
		for(DiagramValue diagramValueObj : diagramValue) {
			DiagramResult diagramResult=new DiagramResult();
			if(checkEqual(str,diagramValueObj) && CompareDates(diagramValueObj,startDate,endDate))
			{
				if(diagramValueObj.getTitle()!=null)
				diagramResult.setTitle(diagramValueObj.getTitle());
				
				if(diagramValueObj.getDiagramId()!=null)
				diagramResult.setDiagramId(diagramValueObj.getDiagramId());
				
				if(diagramValueObj.getUrl()!=null)
				diagramResult.setURL(diagramValueObj.getUrl());
				
				if(diagramValueObj.getDescription()!=null)
				diagramResult.setDescription(diagramValueObj.getDescription());
				
				diagramResult.setCreatedDate(sdf1.format(diagramValueObj.getCreated()));
				
		
				
				resultList.add(diagramResult);
			}
				
		}
		return resultList;
		
		
	}
	
	public boolean CompareDates(DiagramValue diagramValueObj,String  startDateStr,String  endDateStr) throws ParseException {
		
		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(diagramValueObj.getCreated());
	    String formatedDate = cal.get(Calendar.DATE) + "-" + 
	            (cal.get(Calendar.MONTH) + 1) + 
	            "-" +         cal.get(Calendar.YEAR);
	    logger.info("formatedDate : " + formatedDate);

	    Date created=new SimpleDateFormat("dd-MM-yyyy").parse(formatedDate);
		
	    logger.info("createdDate   "+created+"   "+" startDateStr : "+ startDateStr+" endDateStr  "+endDateStr);
		if(Objects.isNull(startDateStr) && Objects.isNull(endDateStr)) 
			return true;
		Date startDate=null;
		Date endDate=null;
		
		if(Objects.nonNull(startDateStr)) {
			
			
			    startDate=new SimpleDateFormat("dd-MM-yyyy").parse(startDateStr);
				
			   
		}
		if(Objects.nonNull(endDateStr)) {
			   endDate=new SimpleDateFormat("dd-MM-yyyy").parse(endDateStr);
				
		}
		logger.info("StartDate : "+ startDate+" endDate  "+endDate);
		
		if(Objects.nonNull(startDate) && Objects.nonNull(endDate)) {
			if(created.compareTo(startDate)>=0 && created.compareTo(endDate)<0)
				return true;
		}
		else if(Objects.nonNull(startDate) && Objects.isNull(endDate))
		{
			if(created.compareTo(startDate)==0 ||created.compareTo(startDate)>0   )
				return true;
		}
		else  if(Objects.nonNull(endDate))
		{
			if(created.compareTo(endDate)==0 ||created.compareTo(endDate)<0)
				return true;
		}
		
		logger.info("StartDate compared  : "+ startDate+" endDate  compared "+endDate);
		
		return false;
			
		
					
	}
	
	public List<DiagramResult> getSearchResultSorted(String str,String startDate,String endDate) throws Exception {
		List<DiagramResult> result=new ArrayList<DiagramResult>();
			result=getSearchResult(str,startDate,endDate);
		return result;
		
		
    	
		
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
