package ro.upt.fis.sample.model;

import lombok.Data;
import org.dizitart.no2.objects.Id;
import ro.upt.fis.sample.enums.Role;

@Data
public class Hotel {

    @Id
    //private NitriteId idField;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String location = "set your location please";
    private String password;
    private String description = "set your description please";
    private Role role = Role.HOTEL;
    private int rating = 0;

    public Hotel(String firstName, String lastName, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Hotel() {
    }
}
