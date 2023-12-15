package progressSoft.java.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progressSoft.java.springboot.exception.ResourceNotFoundException;
import progressSoft.java.springboot.modal.Deal;
import progressSoft.java.springboot.repositry.DealRepository;
import java.util.List;


@RestController
@RequestMapping("/api/vi/testDeals")
public class DealController {

    Logger logger=  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DealRepository<Deal> dealRepository;

    @GetMapping
    public List <Deal> gwtAllDeal(){
        return dealRepository.findAll();
    };
    //build Deal Reset API
    @PostMapping
    public Deal createDeal(@RequestBody Deal deal){
            return  dealRepository.save(deal);
    };

    // build get Deal by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Deal> getDealById(@PathVariable  long id){
        logger.error("some thing has error in get method");
        Deal deal = dealRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Deal not exist with id:" + id));
                //orElseThrow(() -> new ResourceNotFoundException("Deal not exist with id:" + id));
        return ResponseEntity.ok(deal);
    }


    // build update Deal REST API
    @PutMapping("{id}")
    public ResponseEntity<Deal> updateDeal(@PathVariable long id,@RequestBody Deal dealDetail) {
        logger.error("some thing has error in update method");
        Deal updateDeal = dealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Deal not exist with id: " + id));

        updateDeal.setFromCurrency(dealDetail.getFromCurrency());
        updateDeal.setToCurrency(dealDetail.getToCurrency());
        updateDeal.setDealTimestamp(dealDetail.getDealTimestamp());
        updateDeal.setDealAmount(dealDetail.getDealAmount());

        dealRepository.save(updateDeal);

        return ResponseEntity.ok(updateDeal);
    }


    // build delete Deal REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDeal(@PathVariable long id){
        logger.error("some thing has error in delete method");
        Deal deal = dealRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Deal not exist with id: " + id));

        dealRepository.delete(deal);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
