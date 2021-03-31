package ro.upt.fis.hotelregister.infrastructure;

import ro.upt.fis.hotelregister.business.domain.Hotel;
import ro.upt.fis.hotelregister.business.domain.HotelRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryHotelRepository implements HotelRepository {

  private Map<Long, Hotel> hotels = new HashMap<Long, Hotel>();

  @Override
  public void save(Hotel hotel){
      hotels.put(hotel.getId(), hotel);
  }
}
