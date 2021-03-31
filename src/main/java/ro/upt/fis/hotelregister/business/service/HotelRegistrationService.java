package ro.upt.fis.hotelregister.business.service;

import ro.upt.fis.hotelregister.business.domain.Hotel;
import ro.upt.fis.hotelregister.business.domain.HotelRepository;
import ro.upt.fis.hotelregister.business.dto.HotelRegistration;

public class HotelRegistrationService {

    private HotelRepository hotelRepository;

    public void registerUser(HotelRegistration hotelRegistration){
        Hotel hotel = map(hotelRegistration);
        // TODO send confirmation mail
        hotelRepository.save(hotel);
    }

    private Hotel map(HotelRegistration hotelRegistration){
        Hotel hotel = new Hotel();
        hotel.setHotelBusinessName(hotelRegistration.getHotelBusinessName());
        hotel.setPasswordHash(String.valueOf(hotelRegistration.getPassword().hashCode()));

        return hotel;
    }
}
