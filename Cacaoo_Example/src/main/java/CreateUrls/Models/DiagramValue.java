package CreateUrls.Models;

import lombok.Data;

import java.util.Date;

/**
 * Created by Puja on 19/08/19.
 */


public class DiagramValue {

        private String url;
        private String imageUrl;
        private String imageUrlForApi;
        private String diagramId;
        private  String title;
        private String description;
        private String security;
        private String type;
        private Owner owner;
        private String ownerName;
        private String ownerNickname;
        private Boolean editing;
        private Boolean own;
        private Boolean shared;
        private Integer folderId;
        private String folderName;
        private Integer sheetCount;
        private Date created;
        private Date updated;
        private String projectId;
        private String projectName;
        private String organizationKey;

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        public String getImageUrlForApi() {
                return imageUrlForApi;
        }

        public void setImageUrlForApi(String imageUrlForApi) {
                this.imageUrlForApi = imageUrlForApi;
        }

        public String getDiagramId() {
                return diagramId;
        }

        public void setDiagramId(String diagramId) {
                this.diagramId = diagramId;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getSecurity() {
                return security;
        }

        public void setSecurity(String security) {
                this.security = security;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public Owner getOwner() {
                return owner;
        }

        public void setOwner(Owner owner) {
                this.owner = owner;
        }

        public String getOwnerName() {
                return ownerName;
        }

        public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
        }

        public String getOwnerNickname() {
                return ownerNickname;
        }

        public void setOwnerNickname(String ownerNickname) {
                this.ownerNickname = ownerNickname;
        }

        public Boolean getEditing() {
                return editing;
        }

        public void setEditing(Boolean editing) {
                this.editing = editing;
        }

        public Boolean getOwn() {
                return own;
        }

        public void setOwn(Boolean own) {
                this.own = own;
        }

        public Boolean getShared() {
                return shared;
        }

        public void setShared(Boolean shared) {
                this.shared = shared;
        }

        public Integer getFolderId() {
                return folderId;
        }

        public void setFolderId(Integer folderId) {
                this.folderId = folderId;
        }

        public String getFolderName() {
                return folderName;
        }

        public void setFolderName(String folderName) {
                this.folderName = folderName;
        }

        public Integer getSheetCount() {
                return sheetCount;
        }

        public void setSheetCount(Integer sheetCount) {
                this.sheetCount = sheetCount;
        }

        public Date getCreated() {
                return created;
        }

        public void setCreated(Date created) {
                this.created = created;
        }

        public Date getUpdated() {
                return updated;
        }

        public void setUpdated(Date updated) {
                this.updated = updated;
        }

        public String getProjectId() {
                return projectId;
        }

        public void setProjectId(String projectId) {
                this.projectId = projectId;
        }

        public String getProjectName() {
                return projectName;
        }

        public void setProjectName(String projectName) {
                this.projectName = projectName;
        }

        public String getOrganizationKey() {
                return organizationKey;
        }

        public void setOrganizationKey(String organizationKey) {
                this.organizationKey = organizationKey;
        }

        public String getOrganizationName() {
                return OrganizationName;
        }

        public void setOrganizationName(String organizationName) {
                OrganizationName = organizationName;
        }

        String OrganizationName;


    }


