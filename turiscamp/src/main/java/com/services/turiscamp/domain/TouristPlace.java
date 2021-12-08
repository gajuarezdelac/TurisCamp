package com.services.turiscamp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TouristPlace implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String[] horariosApertura;
	
	private String[] horariosCierre;
	
	private String typePeople;
	
	private int calification;
	
	private String history;
	
	// Latitud
	private String lat;
	
	// Longitud
	private String log;
	
	private String[] imagenes;
	
    private Date createdAt;
    
	
}
