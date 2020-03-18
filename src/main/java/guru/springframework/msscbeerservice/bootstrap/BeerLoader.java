package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeers();
    }

    private void loadBeers() {

        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                    .upc(1L)
                    .beerName("b1")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(250)
                    .price(new BigDecimal("12.95"))
                    .build());
            beerRepository.save(Beer.builder()
                    .upc(2L)
                    .beerName("b2")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(250)
                    .price(new BigDecimal("10.95"))
                    .build());

        }
        System.out.println("Beer Repo..Loaded");
    }
}
