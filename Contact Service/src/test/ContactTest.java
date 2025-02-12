package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import contactService.Contact;

public class ContactTest {
	
	// Default Constructor Test
	@Test
	public void testDefaultConstructor() {
		Contact contact = new Contact();
	    assertNull(contact.getContactID());
	    assertNull(contact.getFirstName());
	    assertNull(contact.getLastName());
	    assertNull(contact.getPhone());
	    assertNull(contact.getAddress());
	}
	
	// Id Tests
    @Test
    public void testContactIDLessThan10() {
    	assertDoesNotThrow( () -> new Contact("123", "John", "Doe", "1234567890", "123 Main St.") );
    }

	@Test
    public void testContactIDEquals10() {
        assertDoesNotThrow( () -> new Contact("1234567890", "Elizabeth", "Smith", "9876543210", "456 Elm St.") );
    }

    @Test
    public void testContactIDGreaterThan10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Alex", "Johnson", "5555555555", "789 Oak St."));
    }
   
    @Test
    public void testContactIDIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Null", "Contact", "0000000000", "Null St."));
    }
    
    // First Name Tests
    @Test
    public void testFirstNameIsNull() {
    	assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", null, "Doe", "1234567890", "123 Main St."));
    }

    @Test
    public void testFirstNameIsGreaterThan10() {
    	assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "JohnDoeIsTooLong", "Doe", "1234567890", "123 Main St."));
    }
    
    // Last Name Tests
    @Test
    public void testConstructorNullLastName() {
    	assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", null, "1234567890", "123 Main St."));
    }

    @Test
    public void testConstructorLastNameTooLong() {
    	assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "ThisLastNameIsTooLong", "1234567890", "123 Main St."));
    }    

    // Phone number tests
    @Test
    public void testPhoneNumberInvalidCharacters() {
    	assertThrows(IllegalArgumentException.class, () -> new Contact("1234", "John", "Doe", "123456789A", "123 Main St.") );
    }
    
    @Test
    public void testPhoneNumberIsNull() {
    	assertThrows(IllegalArgumentException.class, () -> new Contact("1234", "John", "Doe", null, "123 Main St.") );
    }
    
    @Test
    public void testPhoneNumberInvalidLength() {
    	assertThrows(IllegalArgumentException.class, () -> new Contact("1234", "John", "Doe", "123456789012", "123 Main St.") );
    }
    
    // Address tests
    @Test
    public void testAddressIsNull() {
      String validContactId = "1234567890";
      String validFirstName = "John";
      String validLastName = "Doe";
      String validPhone = "1234567890";

      assertThrows(IllegalArgumentException.class, 
          () -> new Contact(validContactId, validFirstName, validLastName, validPhone, null));
    }

    @Test
    public void testAddressisGreaterThan30() {
      String validContactId = "1234567890";
      String validFirstName = "John";
      String validLastName = "Doe";
      String validPhone = "1234567890";
      String invalidAddress = "This address is too long to be stored. It exceeds the character limit.";

      assertThrows(IllegalArgumentException.class, 
          () -> new Contact(validContactId, validFirstName, validLastName, validPhone, invalidAddress));
    }    
    
    // Getters and Setters Test
    @Test
    public void testGettersAndSetters() {
      String contactId = "1234567890";
      String firstName = "John";
      String lastName = "Doe";
      String phone = "1234267890";
      String address = "123 Mane St.";

      Contact contact = new Contact(contactId, firstName, lastName, phone, address);

      assertEquals(contactId, contact.getContactID());
      assertEquals(firstName, contact.getFirstName());
      assertEquals(lastName, contact.getLastName());
      assertEquals(phone, contact.getPhone());
      assertEquals(address, contact.getAddress());

      String newFirstName = "Jon";
      String newLastName = "Smith";
      String newPhone = "0987654331";
      String newAddress = "456 Eve St.";

      contact.setFirstName(newFirstName);
      contact.setLastName(newLastName);
      contact.setPhone(newPhone);
      contact.setAddress(newAddress);

      assertEquals(newFirstName, contact.getFirstName());
      assertEquals(newLastName, contact.getLastName());
      assertEquals(newPhone, contact.getPhone());
      assertEquals(newAddress, contact.getAddress());
    }
}