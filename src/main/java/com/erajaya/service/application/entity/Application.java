package com.erajaya.service.application.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_application_type")
public class Application {
	@Id
	@Column(name="application_type_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	@Column(name="name")
	private String Name;
	@Column(name="is_delete")
	private boolean isdelete;
	@Column(name="created_by")
	private String createdby;
	@Column(name="created_date")
	private Timestamp createddate;
	@Column(name="created_from")
	private String createdfrom;
	@Column(name="modified_by")
	private String modifiedby;
	@Column(name="modified_date")
	private Timestamp modifieddate;
	@Column(name="modified_from")
	private String modifiedfrom;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isIsdelete() {
		return isdelete;
	}
	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public String getCreatedfrom() {
		return createdfrom;
	}
	public void setCreatedfrom(String createdfrom) {
		this.createdfrom = createdfrom;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public Timestamp getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getModifiedfrom() {
		return modifiedfrom;
	}
	public void setModifiedfrom(String modifiedfrom) {
		this.modifiedfrom = modifiedfrom;
	}
	
	
	
}
