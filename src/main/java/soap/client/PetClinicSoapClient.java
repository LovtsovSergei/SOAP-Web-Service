package soap.client;

import soap.service.PetClinicServiceInterface;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class PetClinicSoapClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8081/myservice?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://service.soap/", "PetClinicServiceImplService");

        Service service = Service.create(url, qname);

        PetClinicServiceInterface pcsi = service.getPort(PetClinicServiceInterface.class);

//        System.out.println(pcsi.getAllDoctors().get(2).getSchedule());
//        System.out.println(pcsi.getDoctorLastName(null));
//        System.out.println(pcsi.getAllDoctors().get(0).getSchedule());
//        pcsi.registerNewPatient("smirnov", "0110-2018", "10:30", "ivanov");
//          pcsi.addWorkday("petro", new Workday());
        System.out.println(pcsi.getDoctorScheduleByLastName("petrov"));
        System.out.println(pcsi.getAllDoctors());

    }


}
