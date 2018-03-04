package ch.joelhaeberli.tkpbackend.service;

import ch.joelhaeberli.tkpbackend.domain.order.PictureOrder;
import ch.joelhaeberli.tkpbackend.domain.order.PictureOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private PictureOrderRepo pictureOrderRepo;

    @Autowired
    private CustomerService customerService;

    public PictureOrder getPictureOrder(Long id) {

        return pictureOrderRepo.findOne(id);
    }

    public List<PictureOrder> getPictureOrders() {

        return pictureOrderRepo.findAll();
    }

    public PictureOrder addOrder(PictureOrder pictureOrder) {

        customerService.addCustomer(pictureOrder.getCustomer());
        return pictureOrderRepo.saveAndFlush(pictureOrder);
    }

    public boolean deletePictureOrder(Long id) {

        customerService.deleteCustomer(pictureOrderRepo.findOne(id).getCustomer().getId());
        pictureOrderRepo.delete(id);
        return true;
    }

    public PictureOrder updatePictureOrder(PictureOrder pictureOrder) {

        return pictureOrderRepo.saveAndFlush(pictureOrder);
    }
}
