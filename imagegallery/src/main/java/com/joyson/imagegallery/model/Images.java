package com.joyson.imagegallery.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * Image Gallery Images pojo for database table mapping
 * 
 * @author Joyson De Souza
 *
 */
@Entity(name = "images")
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_Sequence")
	@SequenceGenerator(name = "images_Sequence", sequenceName = "IMAGES_SEQ")
	private Long id;

	@Column(name = "imagename", unique = true)
	private String imageName;

	@Column(name = "size")
	private long size;

	@Column(name = "contenturl")
	private String contentUrl;

	@Column(name = "mimetype")
	private String mimeType;

	@Column(name = "info")
	private String info;

	@OneToOne
	@JoinColumn(name = "username")
	private Users createBy;

	@Column(name = "createddate")
	private Date createdDate;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Users getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Users createBy) {
		this.createBy = createBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
