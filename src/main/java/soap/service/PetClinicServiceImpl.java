package soap.service;

import dao.Doctor;
import dao.Workday;
import exceptions.doctorException.DoctorNotFoundException;
import exceptions.timeSlotException.TimeSlotIsNotFreeException;
import exceptions.timeSlotException.TimeSlotNotFoundException;
import exceptions.workdayException.WorkdayNotFoundException;
import exceptions.workdayException.WorkdayNotFreeException;
import service.DoctorService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "soap.service.PetClinicServiceInterface")
public class PetClinicServiceImpl implements PetClinicServiceInterface {

    private static DoctorService doctorService = new DoctorService();

    public PetClinicServiceImpl() {
    }

    @Override
    public List<String> getDoctorLastName(String lastName) throws DoctorNotFoundException {
        if (lastName == null) {
            return doctorService.getAllDoctorsLastNames();

        } else {
            return doctorService.getDoctorLastName(lastName);
        }
    }


    @Override
    public List<Workday> getDoctorScheduleByLastName(String lastName) throws DoctorNotFoundException {

        return doctorService.getDoctorScheduleByLastName(lastName);
    }


    @Override
    public List<Doctor> getAllDoctors() {

        return doctorService.getDoctors();
    }


    @Override
    public void registerNewPatient(String patient, String date, String time, String doctor)
            throws TimeSlotNotFoundException, TimeSlotIsNotFreeException,
            DoctorNotFoundException, WorkdayNotFoundException {

        doctorService.registerNewPatient(patient, date, time, doctor);
    }


    @Override
    public void addWorkday(String lastName, Workday workday) throws WorkdayNotFreeException,
            DoctorNotFoundException {

        doctorService.addWorkday(lastName, workday);
    }
}


