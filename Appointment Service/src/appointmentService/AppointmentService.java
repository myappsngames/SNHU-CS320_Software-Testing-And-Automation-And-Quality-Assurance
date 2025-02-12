package appointmentService;

import java.util.HashMap;
import java.util.Map;

// Appointment Service Class
public class AppointmentService {
    // Map to store appointments with their unique IDs as keys
    private Map<String, Appointment> appointments;

    // Constructor that initializes AppointmentService with an empty map of appointments
    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    // Method to add an appointment
    public void addAppointment(Appointment appointment) {
    	  	
        // Check if the appointment ID is already present (must be unique)
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }

        // Add the appointment to the map
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    // Method to delete an appointment
    public void deleteAppointment(String appointmentID) {
        // Check if the appointment ID is null
        if (appointmentID == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }

        // Check if an appointment with the given ID exists
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment with the given ID not found.");
        }

        // Remove the appointment from the map
        appointments.remove(appointmentID);
    }
    
    // method to get an appointment per id
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
    
}