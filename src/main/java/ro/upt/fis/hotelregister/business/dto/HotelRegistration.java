package ro.upt.fis.hotelregister.business.dto;

import lombok.Data;

@Data
public class HotelRegistration {

    private String hotelBusinessName;
    private String businessEmail;
    private String password;
}
