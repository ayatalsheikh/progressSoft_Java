package progressSoft.java.springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import progressSoft.java.springboot.modal.Deal;
import progressSoft.java.springboot.repositry.DealRepository;

@DataJpaTest
public class DealRepositryTests {

    @Autowired
    private DealRepository dealRepository;

    @Test
    public void saveDealTest (){

        Deal deal=Deal.builder()
                .fromCurrency("EUR")
                .toCurrency("KWD")
                .dealTimestamp("2024-12-10 16:30:00")
                .dealAmount("95.00").build();

        dealRepository.save(deal);

        Assertions.assertThat(deal.getId()).isGreaterThan(0);
    }
}
