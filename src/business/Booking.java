package business;

public class Booking {
	private String firstName, lastName, notes,contactno;
	private int guests, rooms;
	
	//get methods
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNotes() {
		return notes;
	}
	public String getContact() {
		return contactno;
	}
	
	//set methods
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public void guests(int guests) {
		this.guests = guests;
	}
	public void rooms(int rooms) {
		this.rooms = rooms;
	}
}
