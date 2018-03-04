package ch.joelhaeberli.tkpbackend;

import ch.joelhaeberli.tkpbackend.domain.customer.Customer;
import ch.joelhaeberli.tkpbackend.domain.order.OrderForm;
import ch.joelhaeberli.tkpbackend.domain.order.OrderStatus;
import ch.joelhaeberli.tkpbackend.domain.order.PictureOrder;
import ch.joelhaeberli.tkpbackend.domain.picture.Picture;
import ch.joelhaeberli.tkpbackend.service.OrderService;
import ch.joelhaeberli.tkpbackend.service.PictureService;
import ch.joelhaeberli.tkpbackend.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/")
public class TkpCustomerController {

    @Autowired
    PictureService pictureService;
    @Autowired
    OrderService orderService;
    @Autowired
    SettingService settingService;

    @GetMapping(value = "image/{uuid}")
    public ResponseEntity<Object> getPicture(@PathVariable String uuid) {
        return ResponseEntity.ok(pictureService.loadImage(uuid));
    }

    @GetMapping(value = "images/{lastIndex}")
    public ResponseEntity<Object> getNumberOfThumbnails(@PathVariable long lastIndex) {
        return ResponseEntity.ok(pictureService.getPictures());
    }

    @GetMapping(value = "thumbnail/{uuid}")
    public ResponseEntity<Object> getThumbnail(@PathVariable String uuid) {
        return ResponseEntity.ok(pictureService.loadThumbnail(uuid));
    }

    @GetMapping(value = "pagecontent/{settingId}")
    public ResponseEntity<Object> getSetting(@PathVariable String settingsId) {
        return ResponseEntity.ok(settingService.getSetting(settingsId));
    }

    @PostMapping(value = "order")
    public ResponseEntity<Object> orderPicture(@RequestBody Picture picture,
                                               @RequestBody Customer customer,
                                               @RequestBody String form,
                                               @RequestBody String notice) {

        PictureOrder pictureOrder = new PictureOrder();
        pictureOrder.setCustomer(customer);
        pictureOrder.setPicture(picture);
        pictureOrder.setNotice(notice);
        pictureOrder.setOrderForm(OrderForm.valueOf(form));
        pictureOrder.setOrderedAt(LocalDateTime.now());
        pictureOrder.setOrderStatus(OrderStatus.OPEN);

        return ResponseEntity.ok(orderService.addOrder(pictureOrder));
    }
}
