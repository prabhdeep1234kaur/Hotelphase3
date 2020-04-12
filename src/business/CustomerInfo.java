package business;

public class CustomerInfo  {
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String city;
	private String province;
	private String country;
	private String zip;
	
	public CustomerInfo(String firstName,String lastName,String address,String phoneNumber,String city,String province,String country,String zip) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.address = address;
		this.phoneNumber=phoneNumber;
		this.city=city;	
		this.province=province;
		this.country=country;
		this.zip=zip;
	}
	public String getfirstName() {
		
		return firstName;
	}
	public String getlastName() {
		
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		
		return phoneNumber;
	}
	public String getCity() {
		
		return city;
	}
	public String getCountry() {
		
		return country;
	}
	public String getProvince() {
		
		return province;
	}
	public String getZip() {
		
		return zip;
	}
}