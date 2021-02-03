package com.example.genderdecoder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GenderText")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class ProcessedText implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank
		private String text;
	    
	    @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;
	    
	    int countMasculine;
	    int countFeminine;
	    String genderMap;
	   
	    @Column(name = "last_modified_date")
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date lastModifiedDate;
	    
	    
	    public ProcessedText() {
	    	
	    }

	    public ProcessedText(String text, 
	    					 int countMasculine, int countFeminine, 
	    					 String genderMap) {
	    	this.text = text;
	    	this.countMasculine = countMasculine;
	    	this.countFeminine = countFeminine;
	    	this.genderMap = genderMap;
	    	
	    }
	    
	 // ToDo: Define all the Getters and Setters 
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
}

