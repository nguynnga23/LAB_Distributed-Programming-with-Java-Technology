package entity;

import java.time.LocalDate;

public class Order {
//	{"shipCity":"Reims","orderID":"10248","freight":"32.38","requiredDate"│
//		│:"1996-08-01 00:00:00.000","employeeID":"5","shipName":"Vins et alcool│
//		│s Chevalier","shipPostalCode":"51100","shipCountry":"France","shipAddr│
//		│ess":"59 rue de l'Abbaye","shipVia":"3","customerID":"VINET","shippedD│
//		│ate":"1996-07-16 00:00:00.000","orderDate":"1996-07-04 00:00:00.000","│
//		│shipRegion":"NULL"}       
	private String orderId;
	private String employeeId;
	private Customer customer;
	private String shipCity;
	private String freight;
	private LocalDate requireDate;
	private String shipName;
	private String shipPostalCode;
	private String shipCountry;
	private String shipAddress;
	private LocalDate shippedDate;
	private LocalDate orderDate;
	private String shipRegion;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String orderId, String employeeId, Customer customer, String shipCity, String freight,
			LocalDate requireDate, String shipName, String shipPostalCode, String shipCountry, String shipAddress,
			LocalDate shippedDate, LocalDate orderDate, String shipRegion) {
		super();
		this.orderId = orderId;
		this.employeeId = employeeId;
		this.customer = customer;
		this.shipCity = shipCity;
		this.freight = freight;
		this.requireDate = requireDate;
		this.shipName = shipName;
		this.shipPostalCode = shipPostalCode;
		this.shipCountry = shipCountry;
		this.shipAddress = shipAddress;
		this.shippedDate = shippedDate;
		this.orderDate = orderDate;
		this.shipRegion = shipRegion;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public LocalDate getRequireDate() {
		return requireDate;
	}

	public void setRequireDate(LocalDate requireDate) {
		this.requireDate = requireDate;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public LocalDate getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", employeeId=" + employeeId + ", customer=" + customer + ", shipCity="
				+ shipCity + ", freight=" + freight + ", requireDate=" + requireDate + ", shipName=" + shipName
				+ ", shipPostalCode=" + shipPostalCode + ", shipCountry=" + shipCountry + ", shipAddress=" + shipAddress
				+ ", shippedDate=" + shippedDate + ", orderDate=" + orderDate + ", shipRegion=" + shipRegion + "]";
	}

}
