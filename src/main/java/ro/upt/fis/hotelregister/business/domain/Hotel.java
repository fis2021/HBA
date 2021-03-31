package ro.upt.fis.hotelregister.business.domain;

import lombok.Data;

@Data
public class Hotel {

    // TODO change get id
    private Long id = 0L;
    private String businessEmail;
    private String hotelBusinessName;
    private String passwordHash;

    public Hotel(){
        id++;
    }
}
