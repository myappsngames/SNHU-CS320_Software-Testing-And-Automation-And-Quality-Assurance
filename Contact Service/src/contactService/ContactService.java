package contactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService extends Contact {
	// declare a map variable to hold contacts
	private Map<String, Contact> contacts;
	
	// initialize contacts with a hash map
	public ContactService() {
		contacts = new HashMap<>();
	}
	
	// method to add contacts with a unique ID
	public void addContact(Contact contact) {
		// check if contact is null
		if (contact == null) {
			throw new IllegalArgumentException("Contact must not be null");
		}
		
		// check if contact already exists
		if (contacts.containsKey(contact.getContactID())) {
			// throw an exception
			throw new IllegalArgumentException("Contact with ID " + contact.getContactID() + " already exists.");
		}
		contacts.put(contact.getContactID(), contact);
	}
	
	// method to delete contacts per contact ID
	public void deleteContact(String contactId) {
		// Check if contact exists before deletion
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact with ID" + contactId + " does not exist.");
		}
		
		contacts.remove(contactId);
	}
	
	// method to update contact fields per contact ID
	public void updateContactField(String contactId, String fieldName, String newFieldValue) {
    	
        Contact contact = contacts.get(contactId);
        
        if (contact == null) {
        	throw new IllegalArgumentException("Contact with ID" + contactId + " does not exist.");
        }
        
        // switch statement to update fields
        switch (fieldName) {
        	case "firstName":
        		contact.setFirstName(newFieldValue);
        		break;
        	case "lastName":
        		contact.setLastName(newFieldValue);
        		break;
        	case "phone":
        		contact.setPhone(newFieldValue); 
        		break;
        	case "address":
        		contact.setAddress(newFieldValue);
        		break;
        	default:
        		throw new IllegalArgumentException("Invalid field name");
        }
        
    }
    
    // method to get contact per contact ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
