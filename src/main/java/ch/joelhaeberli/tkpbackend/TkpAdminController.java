package ch.joelhaeberli.tkpbackend;

import ch.joelhaeberli.tkpbackend.common.general.GeneralSuccess;
import ch.joelhaeberli.tkpbackend.domain.picture.*;
import ch.joelhaeberli.tkpbackend.domain.order.PictureOrder;
import ch.joelhaeberli.tkpbackend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class TkpAdminController {

    @Autowired
    ImageService imageService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String username, @RequestBody String password) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout() {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @GetMapping("/orders")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Object> editOrder(@PathVariable Long id, @RequestBody PictureOrder order) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PostMapping("/image")
    public ResponseEntity<Object> createImage(@RequestBody Picture picture, @RequestBody byte[] picRaw) {
        return ResponseEntity.ok(imageService.savePicture(picture, picRaw));
    }

    @DeleteMapping("/image/{uuid}")
    public ResponseEntity<Object> deleteImage(@PathVariable String uuid) {
        return ResponseEntity.ok(GeneralSuccess.isSuccess(imageService.deletePicture(uuid)));
    }
}
