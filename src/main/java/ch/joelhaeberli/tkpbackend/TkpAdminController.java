package ch.joelhaeberli.tkpbackend;

import ch.joelhaeberli.tkpbackend.common.general.GeneralSuccess;
import ch.joelhaeberli.tkpbackend.domain.picture.*;
import ch.joelhaeberli.tkpbackend.domain.order.PictureOrder;
import ch.joelhaeberli.tkpbackend.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class TkpAdminController {

    @Autowired
    PictureService pictureService;

    @GetMapping(value = "/order/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<Object> getOrders() {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PutMapping(value = "/order/{id}")
    public ResponseEntity<Object> editOrder(@PathVariable Long id, @RequestBody PictureOrder order) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PostMapping(value = "/image")
    public ResponseEntity<Object> createImage(@RequestBody Picture picture, @RequestBody byte[] picRaw) {
        return ResponseEntity.ok(pictureService.savePicture(picture, picRaw));
    }

    @DeleteMapping(value = "/image/{uuid}")
    public ResponseEntity<Object> deleteImage(@PathVariable String uuid) {
        return ResponseEntity.ok(GeneralSuccess.isSuccess(pictureService.deletePicture(uuid)));
    }
}
