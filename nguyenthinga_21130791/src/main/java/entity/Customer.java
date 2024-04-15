package entity;

public class Customer {
//	{"country":"Germany","contactTitle":"Sales Representative","address":"│
//		│Obere Str. 57","phone":"030-0074321","city":"Berlin","contactName":"Ma│
//		│ria Anders","companyName":"Alfreds Futterkiste","postalCode":"12209","│
//		│customerID":"ALFKI","fax":"030-0076545","region":"NULL"}    
	private String customerId;
	private String country;
	private String contactTitle;
	private String address;
	private String phone;
	private String city;
	private String contactName;
	private String companyName;
	private String postalCode;
	private String fax;
	private String region;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerId, String country, String contactTitle, String address, String phone, String city,
			String contactName, String companyName, String postalCode, String fax, String region) {
		super();
		this.customerId = customerId;
		this.country = country;
		this.contactTitle = contactTitle;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.contactName = contactName;
		this.companyName = companyName;
		this.postalCode = postalCode;
		this.fax = fax;
		this.region = region;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", country=" + country + ", contactTitle=" + contactTitle
				+ ", address=" + address + ", phone=" + phone + ", city=" + city + ", contactName=" + contactName
				+ ", companyName=" + companyName + ", postalCode=" + postalCode + ", fax=" + fax + ", region=" + region
				+ "]";
	}

}
