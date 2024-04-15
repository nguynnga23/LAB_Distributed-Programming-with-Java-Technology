package entity;

public class Supplier {
//	{"country":"UK","contactTitle":"Purchasing Manager","address":"49 Gilb│
//		│ert St.","supplierID":"1","phone":"(171) 555-2222","city":"London","co│
//		│ntactName":"Charlotte Cooper","companyName":"Exotic Liquids","postalCo│
//		│de":"EC1 4SD","region":"NULL","fax":"NULL","homePage":"NULL"} 
	private String supplierId;
	private String country;
	private String contactTitle;
	private String address;
	private String phone;
	private String city;
	private String contactName;
	private String companyName;
	private String postalCode;
	private String region;
	private String fax;
	private String homePage;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(String supplierId, String country, String contactTitle, String address, String phone, String city,
			String contactName, String companyName, String postalCode, String region, String fax, String homePage) {
		super();
		this.supplierId = supplierId;
		this.country = country;
		this.contactTitle = contactTitle;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.contactName = contactName;
		this.companyName = companyName;
		this.postalCode = postalCode;
		this.region = region;
		this.fax = fax;
		this.homePage = homePage;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", country=" + country + ", contactTitle=" + contactTitle
				+ ", address=" + address + ", phone=" + phone + ", city=" + city + ", contactName=" + contactName
				+ ", companyName=" + companyName + ", postalCode=" + postalCode + ", region=" + region + ", fax=" + fax
				+ ", homePage=" + homePage + "]";
	}

}
