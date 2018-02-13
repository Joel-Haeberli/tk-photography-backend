package ch.joelhaeberli.tkpbackend;

import ch.joelhaeberli.tkpbackend.domain.customer.Customer;
import ch.joelhaeberli.tkpbackend.domain.picture.Picture;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Controller
public class TkpCustomerController {

    @GetMapping("/image/{id}")
    public ResponseEntity<Object> getPicture(@PathVariable long id) {
        throw new NotImplementedException();
    }

    @GetMapping("/images/{number}")
    public ResponseEntity<Object> getNumberOfThumbnails(@PathVariable long number) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @GetMapping("/thumbnail/{id}")
    public ResponseEntity<Object> getThumbnail(@PathVariable long id) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
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
