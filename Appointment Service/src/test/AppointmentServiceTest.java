package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import appointmentService.Appointment;
import appointmentService.AppointmentService;


class AppointmentServiceTest {
    private AppointmentService appointmentService; // Instance of the AppointmentService class
    private LocalDate validDate; // Valid date object for testing
    private Appointment validAppointment; // Valid appointment object for testing

    /**
     * Set up method to initialize test data before each test case.
     */
    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService(); // Initialize AppointmentService
        validDate = LocalDate.now(); // Initialize valid date
        validAppointment = new Appointment("1234567890", validDate, "Valid description"); // Create valid appointment
    }

    /**
     * Test case to verify the functionality of adding an appointment.
     */
    @Test
    void testAddAppointmentSuccessful() {
        appointmentService.addAppointment(validAppointment);
        assertEquals(validAppointment, appointmentService.getAppointment("1234567890"));
    }

    /**
     * Test case to verify handling of adding an appointment with a duplicate ID.
     */
    @Test
    void testAddAppointmentDuplicateID() {
        appointmentService.addAppointment(validAppointment);

        // Adding an appointment with the same ID should throw an exception
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(new Appointment("1234567890", validDate, "Duplicate ID")));
    }

    
    /**
     * Test case to verify the functionality of deleting an appointment.
     */
    @Test
    void testDeleteAppointmentSuccessful() {
        appointmentService.addAppointment(validAppointment);
        appointmentService.deleteAppointment("1234567890");
        assertNull(appointmentService.getAppointment("1234567890"));
    }

    /**
     * Test case to verify handling of deleting a nonexistent appointment.
     */
    @Test
    void testDeleteNonexistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("NonexistentID"));
    }
    
    @Test
    void testDeleteNullAppointmentID() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment(null));
    }
}
