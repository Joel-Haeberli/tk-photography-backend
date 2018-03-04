package ch.joelhaeberli.tkpbackend.service;

import ch.joelhaeberli.tkpbackend.domain.order.PictureOrder;
import ch.joelhaeberli.tkpbackend.domain.order.PictureOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private PictureOrderRepo pictureOrderRepo;

    @Autowired
    private CustomerService customerService;

    public PictureOrder addOrder(PictureOrder pictureOrder) {

        customerService.addCustomer(pictureOrder.getCustomer());
        return pictureOrderRepo.saveAndFlush(pictureOrder);
    }

    public void deletePictureOrder(Long id) {

        customerService.deleteCustomer(pictureOrderRepo.findOne(id).getCustomer().getId());
        pictureOrderRepo.delete(id);
    }

    public PictureOrder updatePictureOrder(PictureOrder pictureOrder) {

        return pictureOrderRepo.saveAndFlush(pictureOrder);
    }
}
