package DTO;


import java.util.Date;


public class DiagramResult {
	

	String Title;
	String DiagramId;
	String URL;
	String Description;
	String createdDate;
	
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDiagramId() {
		return DiagramId;
	}
	public void setDiagramId(String diagramId) {
		DiagramId = diagramId;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
