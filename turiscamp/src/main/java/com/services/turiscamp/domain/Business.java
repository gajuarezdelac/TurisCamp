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
public class Business implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;
	
  private String nombre;
  
  private String[] horariosApert;
  
  private String[] horariosCierre;
  
  private String numberPhone;
  
  // Latitud
  private String lat;
  
  // Longitud
  private String log;
  
  private String people;
  
  private String typeBusiness;
  
  private String imagenReferencia;
  
  private Date createdAt;
  
//  private List<String> comments;
  
//    private List<Product> productos; 
  
}
