package arreandaki.com.arreandaki.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import arreandaki.com.arreandaki.model.House;
import arreandaki.com.arreandaki.model.Photo;
import arreandaki.com.arreandaki.repository.HouseRepository;
import arreandaki.com.arreandaki.repository.PhotoRepository;

@RestController
@RequestMapping("/houses")
public class HouseController {
  @Autowired
  private HouseRepository houseRepository;

  @Autowired
  private PhotoRepository photoRepository;

  public House save(@RequestBody House house) {
    return houseRepository.save(house);
  }

  @PostMapping("/{id}/upload-photo")
  public ResponseEntity<String> uploadPhoto(@PathVariable Long id, @RequestParam("photoFile") MultipartFile photoFile) {
    if (photoFile.isEmpty()) {
      return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
    }

    try {
      House house = houseRepository.findById(id)
          .orElse(null);

      if (house != null) {
        Photo photo = new Photo();
        photo.setFileName(photoFile.getOriginalFilename());
        photo.setHouse(house);
        photoRepository.save(photo);

        return new ResponseEntity<>("Photo uploaded and associated with the house.", HttpStatus.CREATED);
      } else {
        return new ResponseEntity<>("House not found.", HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Failed to upload and associate the photo.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
