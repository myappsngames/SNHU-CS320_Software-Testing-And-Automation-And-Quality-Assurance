package appointmentService;

import java.time.LocalDate;

public class Appointment {
	
    // Private member variables to store appointment information
    private String appointmentID; // Unique identifier for the appointment (No longer than 10 characters/not null/not updatable)
    private LocalDate appointmentDate; // Date and time of the appointment (Cannot be in the past/not null)
    private String description; // Description of the appointment (No longer than 50 characters/ not null)
    
    // Constructor with parameters
    public Appointment(String appointmentID, LocalDate appointmentDate, String description) {
    	super();
    	
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID: Appointment ID must not be null and cannot exceed 10 characters.");
		}
		if (appointmentDate.isBefore(LocalDate.now()) ) {
			throw new IllegalArgumentException("Invalid appointment date: Appointment Date must not be null and cannot be in the past.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description: Appointment description must not be null and cannot exceed 50 characters.");
		}
    	
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getter Methods
    
    public String getAppointmentID() {
        return appointmentID;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}