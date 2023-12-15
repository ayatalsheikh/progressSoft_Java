package progressSoft.java.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import progressSoft.java.springboot.modal.Deal;
import progressSoft.java.springboot.repositry.DealRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private DealRepository<Deal> dealRepository;

	@Override
	public void run(String... args) throws Exception {

		Deal deal =new Deal();
		deal.setFromCurrency("JOD");
		deal.setToCurrency("USA");
		deal.setDealTimestamp("'2024-12-15 12:30:00'");
		deal.setDealAmount("200.00");

		List<Deal> existingDeal = dealRepository.findByFromCurrencyAndToCurrencyAndDealTimestampAndDealAmount(
				deal.getFromCurrency(), deal.getToCurrency(), deal.getDealTimestamp(), deal.getDealAmount());

		if (existingDeal.isEmpty()) {
			dealRepository.save(deal);
		}

		Deal deal1 =new Deal();
		deal1.setFromCurrency("JOD");
		deal1.setToCurrency("JOD");
		deal1.setDealTimestamp("'2024-12-16 10:20:00'");
		deal1.setDealAmount("80.00");

		existingDeal = dealRepository.findByFromCurrencyAndToCurrencyAndDealTimestampAndDealAmount(
				deal1.getFromCurrency(), deal1.getToCurrency(), deal1.getDealTimestamp(), deal1.getDealAmount());
		if (existingDeal.isEmpty()) {
			dealRepository.save(deal1);
		}
	}
}
