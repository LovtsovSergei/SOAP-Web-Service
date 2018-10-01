package soap.service;

import dao.Doctor;
import dao.Workday;
import exceptions.doctorException.DoctorNotFoundException;
import exceptions.timeSlotException.TimeSlotIsNotFreeException;
import exceptions.timeSlotException.TimeSlotNotFoundException;
import exceptions.workdayException.WorkdayNotFoundException;
import exceptions.workdayException.WorkdayNotFreeException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface PetClinicServiceInterface {

    @WebMethod
    List<String> getDoctorLastName(String lastName)
            throws DoctorNotFoundException;

    @WebMethod
    List<Workday> getDoctorScheduleByLastName(String lastName)
            throws DoctorNotFoundException;

    @WebMethod
    List<Doctor> getAllDoctors();

    @WebMethod
    void registerNewPatient(String patient, String date, String time, String doctor)
            throws TimeSlotNotFoundException, TimeSlotIsNotFreeException,
            DoctorNotFoundException, WorkdayNotFoundException;

    @WebMethod
    void addWorkday(String lastName, Workday workday) throws
            WorkdayNotFreeException, DoctorNotFoundException;
}
