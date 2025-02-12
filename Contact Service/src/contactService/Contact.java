package contactService;

public class Contact {
	
	// private member variables
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact() {}
	
	// Constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID: The contact ID must not be null and cannot exceed 10 characters.");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name: The first name must not be null and cannot exceed 10 characters.");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name: The last name must not be null and cannot exceed 10 characters.");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number: The phone number must not be null and must be 10 digits.");
		}
		if (!phone.matches("^[0-9]+$")) {
			throw new IllegalArgumentException("Invalid phone number: The phone number must contain only digits.");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address: The address must not be null and cannot exceed 30 characters.");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// getters
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
