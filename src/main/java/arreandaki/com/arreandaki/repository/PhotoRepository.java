package arreandaki.com.arreandaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import arreandaki.com.arreandaki.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
