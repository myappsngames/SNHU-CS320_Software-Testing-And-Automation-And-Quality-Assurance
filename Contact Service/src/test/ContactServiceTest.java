package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

public class ContactServiceTest {
	private ContactService contactService;
	
	@BeforeEach
    public void setUp() {
		contactService = new ContactService();
    }

	
	/**
	 *  Tests for Adding Contacts
	 */
    @Test
    public void testAddContactSuccessful() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);
        assertNotNull(contactService.getContact("1234567890"));
    }
    
    @Test
    public void testAddNullContact() {
        Contact contact = null;
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
    }
    
    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
    }
    
    /**
     * Tests for Deleting Contacts
     */
    @Test
    public void testDeleteContactSuccessful() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }
    
    @Test
    public void testDeleteContactDoesNotExist() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () ->contactService.deleteContact("1234567891"));
    }
    
    
    /**
     * Tests for Updating Contact Fields
     */    
    @Test
    public void testUpdateContactFieldFirstName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);
        contactService.updateContactField("1234567890", "firstName", "Ben");
        assertEquals("Ben", contact.getFirstName());
    }
    
    @Test
    public void testUpdateContactFieldLastName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);
        contactService.updateContactField("1234567890", "lastName", "Show");
        assertEquals("Show", contact.getLastName());
    }
    
    @Test
    public void testUpdateContactFieldPhoneNumber() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);
        contactService.updateContactField("1234567890", "phone", "1234567899");
        assertEquals("1234567899", contact.getPhone());
    }
    
    @Test
    public void testUpdateContactFieldAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
        contactService.addContact(contact);
        contactService.updateContactField("1234567890", "address", "456 Main St.");
        assertEquals("456 Main St.", contact.getAddress());
    }
    
    @Test
    public void testUpdateContactInvalidFieldName() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St.");
    	contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("1234567890", "middleName", "Franklin"));
    }
    
    @Test
    public void testUpdateContactDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactField("1234567890", "middleName", "Franklin"));
    }
}