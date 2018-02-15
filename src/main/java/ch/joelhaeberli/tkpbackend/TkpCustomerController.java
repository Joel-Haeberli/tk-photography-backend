package ch.joelhaeberli.tkpbackend;

import ch.joelhaeberli.tkpbackend.domain.customer.Customer;
import ch.joelhaeberli.tkpbackend.domain.picture.Picture;
import ch.joelhaeberli.tkpbackend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Controller
public class TkpCustomerController {

    @Autowired
    ImageService imageService;

    @GetMapping("/image/{uuid}")
    public ResponseEntity<Object> getPicture(@PathVariable String uuid) {
        return ResponseEntity.ok(imageService.loadImage(uuid));
    }

    @GetMapping("/images/{lastIndex}")
    public ResponseEntity<Object> getNumberOfThumbnails(@PathVariable long lastIndex) {
        return ResponseEntity.ok(imageService.getPictures(lastIndex));
    }

    @GetMapping("/thumbnail/{uuid}")
    public ResponseEntity<Object> getThumbnail(@PathVariable String uuid) {
        return ResponseEntity.ok(imageService.loadThumbnail(uuid));
    }

    @GetMapping("/pagecontent/{key}")
    public ResponseEntity<Object> getValueOfKey(@PathVariable String key) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PostMapping("/order")
    public ResponseEntity<Object> orderPicture(@RequestBody Picture picture, @RequestBody Customer customer) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }
}
