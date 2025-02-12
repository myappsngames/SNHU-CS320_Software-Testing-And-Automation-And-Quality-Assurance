package test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;

class AppointmentTest {
	private String validID; // ID for testing
    private String validDescription; // Description for testing
    private String longID; // ID longer than allowed length for testing
    private String longDescription; // Description longer than allowed length for testing
    private LocalDate validDate; // Valid date for testing
    private LocalDate pastDate; // Past date for testing
    
    @BeforeEach
    void setUp() {
    	validID = "123456789";
    	validDescription = "This is a valid description"; // Initialize description
        longID = "111222333444555666777888999"; // Initialize too long ID
        longDescription = "This description is not valid. This description is too long. This description is good for testing."; // Initialize too long description
        validDate = LocalDate.now();  // Initialize valid date
        pastDate = LocalDate.now().minusDays(1); // Initialize valid past date
    }
    
	// Default Constructor Test
	@Test
	public void testDefaultConstructor() {
		Appointment appointment = new Appointment(validID, validDate, validDescription);
	    assertNotNull(appointment.getAppointmentID());
	    assertNotNull(appointment.getAppointmentDate());
	    assertNotNull(appointment.getDescription());
	}
    
    /** Tests for Appointment ID
     * 
     */
	@Test
	public void testAppointmentIdSuccess() {
		assertDoesNotThrow( () -> new Appointment(validID, validDate, validDescription));
	}
	
    @Test
    public void testAppointmentIdIsGreaterThan10() {
    	assertThrows(IllegalArgumentException.class, () -> new Appointment(longID, validDate, validDescription) );
    }
    
    @Test
    public void testAppointmentIdIsNull() {
    	assertThrows(IllegalArgumentException.class, () -> new Appointment(null, validDate, validDescription) );
    }
    
    /** Tests for Appointment Date
     * 
     */
	@Test
	public void testAppointmentDateSuccess() {
		assertDoesNotThrow( () -> new Appointment(validID, validDate, validDescription));
	}
	
    @Test
    public void testAppointmentDateIsPast() {
    	assertThrows(IllegalArgumentException.class, () -> new Appointment(validID, pastDate, validDescription) );
    }
    

    
    
    /** Tests for Appointment Description
     * 
     */
	@Test
	public void testAppointmentDescriptionSuccess() {
		assertDoesNotThrow( () -> new Appointment(validID, validDate, validDescription));
	}
	
    @Test
    public void testAppointmentDescriptionIsGreaterThan50() {
    	assertThrows(IllegalArgumentException.class, () -> new Appointment(validID, validDate, longDescription) );
    }
    
    @Test
    public void testAppointmentDescriptionIsNull() {
    	assertThrows(IllegalArgumentException.class, () -> new Appointment(validID, validDate, null) );
    }
    
    /** Tests for Getter Methods
     * 
     */
    @Test
    void testGetAppointmentID() {
        Appointment appointment = new Appointment(validID, validDate, validDescription);
        assertEquals("123456789", appointment.getAppointmentID()); // Check if ID is correct
    }

    @Test
    void testGetAppointmentDate() {
        Appointment appointment = new Appointment(validID, validDate, validDescription);
        assertEquals(LocalDate.now(), appointment.getAppointmentDate()); // Check if date is correct
    }

    @Test
    void testGetDescription() {
        Appointment appointment = new Appointment(validID, validDate, validDescription); 
        assertEquals("This is a valid description", appointment.getDescription()); // Check if description is correct
    }
}