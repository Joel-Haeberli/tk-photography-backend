package ch.joelhaeberli.tkpbackend;

import ch.joelhaeberli.tkpbackend.domain.picture.*;
import ch.joelhaeberli.tkpbackend.domain.order.PictureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class TkpAdminController {

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String username, @RequestBody String password) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(@RequestBody String accessToken) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Object> getOrder(@RequestBody String accessToken, @PathVariable Long id) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @GetMapping("/orders")
    public ResponseEntity<Object> getOrders(@RequestBody String accessToken) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Object> editOrder(@RequestBody String accessToken, @PathVariable Long id, @RequestBody PictureOrder order) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Object> deleteOrder(@RequestBody String accessToken, @PathVariable Long id) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @PostMapping("/image")
    public ResponseEntity<Object> createImage(@RequestBody String accessToken, @RequestBody Picture picture) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }

    @DeleteMapping("/image/{id}")
    public ResponseEntity<Object> deleteImage(@RequestBody String accessToken, @PathVariable Long id) {
        return ResponseEntity.ok(new SystemMessage("Diese Funktion wurde noch nicht implementiert"));
    }
}
