package business;

public class CustomerInfo  {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String country;
	private String province;
	private String city;
	private String zip;
	private String address;
	
	public CustomerInfo(String firstName,String lastName, String phoneNumber,String country,String province,String city, String zip, String address) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
		this.country=country;
		this.province=province;
		this.city=city;	
		this.address = address;
		this.zip=zip;
	}
	public String getfirstName() {
		
		return firstName;
	}
	public String getlastName() {
		
		return lastName;
	}
	public String getPhoneNumber() {
		
		return phoneNumber;
	}
	public String getCountry() {
		
		return country;
	}
	public String getProvince() {
		
		return province;
	}
	public String getCity() {
		
		return city;
	}
	public String getZip() {
		
		return zip;
	}
	public String getAddress() {
		return address;
	}
}