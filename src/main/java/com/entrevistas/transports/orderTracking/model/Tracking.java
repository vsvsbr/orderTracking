package com.entrevistas.transports.orderTracking.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tracking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	@ManyToOne
	private Address address;
	@ManyToOne
	private LocalService sourceService;
	@ManyToOne
	private LocalService destinationService;

	private ZonedDateTime now;

	@Enumerated(EnumType.STRING)
	private TrackingStatus status;

	public Tracking() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalService getSourceService() {
		return sourceService;
	}

	public void setSourceService(LocalService sourceService) {
		this.sourceService = sourceService;
	}

	public LocalService getDestinationService() {
		return destinationService;
	}

	public void setDestinationService(LocalService destinationService) {
		this.destinationService = destinationService;
	}

	public ZonedDateTime getNow() {
		return now;
	}

	public void setNow(ZonedDateTime now) {
		this.now = now;
	}

	public TrackingStatus getStatus() {
		return status;
	}

	public void setStatus(TrackingStatus status) {
		this.status = status;
	}
	
}
