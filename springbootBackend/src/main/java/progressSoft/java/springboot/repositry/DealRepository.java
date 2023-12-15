package progressSoft.java.springboot.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progressSoft.java.springboot.modal.Deal;

import java.util.List;

@Repository
public interface DealRepository<D> extends JpaRepository<Deal, Long> {
    //to stop Duplicate Records
    List<Deal> findByFromCurrencyAndToCurrencyAndDealTimestampAndDealAmount(
            String fromCurrency, String toCurrency, String dealTimestamp, String dealAmount);
}
