/**
 * 
 */
package com.services.turiscamp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gabriel.juarez
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Municipality implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private String name;
	
	private String subName;
	
	private String description;

	private String image;
	
	private String urlReferencia;
	
    private Date createdAt;
    
    
}
