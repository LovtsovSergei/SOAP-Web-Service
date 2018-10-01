package soap.publisher;

import soap.service.PetClinicServiceImpl;

import javax.xml.ws.Endpoint;

public class SOAPPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/myservice", new PetClinicServiceImpl());
    }
}
