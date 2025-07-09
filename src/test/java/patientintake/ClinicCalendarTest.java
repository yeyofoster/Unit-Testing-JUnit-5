package patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    @Test
    void allowEntryOfAnAppointment() {
        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("Yeyo", "Foster", "avery", "7/9/2025 2:00 PM");
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1, appointments.size());
        PatientAppointment appointment = appointments.get(0);
        assertEquals("Yeyo", appointment.getPatientFirstName());
        assertEquals("Foster", appointment.getPatientLastName());
        assertEquals(Doctor.avery, appointment.getDoctor());
        assertEquals("7/9/2025 2:00 PM", appointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy h:mm a")));
    }
}