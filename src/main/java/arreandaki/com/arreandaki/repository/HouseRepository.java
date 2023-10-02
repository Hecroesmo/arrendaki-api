package arreandaki.com.arreandaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import arreandaki.com.arreandaki.model.House;

public interface HouseRepository extends JpaRepository<House, Long> {

}
