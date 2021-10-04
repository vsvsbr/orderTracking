package com.entrevistas.transports.orderTracking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_TABLE")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="source_address_id")
	private Address source;
	@ManyToOne
	@JoinColumn(name="destination_address_id")
	private Address destination;
	@ManyToOne
	private Tracking currentPosition;
	
	@OneToMany(mappedBy = "order")
	private List<Tracking> tracking = new ArrayList<>();
	
	
	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getSource() {
		return source;
	}

	public void setSource(Address source) {
		this.source = source;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public Tracking getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Tracking currentPosition) {
		this.currentPosition = currentPosition;
	}

	public List<Tracking> getTracking() {
		return tracking;
	}

}
