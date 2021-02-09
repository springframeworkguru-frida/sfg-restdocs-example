package guru.springframework.sfgrestdocsexample.bootstrap;

import guru.springframework.sfgrestdocsexample.domain.Beer;
import guru.springframework.sfgrestdocsexample.repositories.BeerRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//spring context does pick it up
public class BeerLoader implements CommandLineRunner {

    //spring inject a beerrepository implementation provided by spring data JPA
    private final BeerRepository beerRepository;
    public static final String BEER_1_UPC = "0631234200036";

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){

            beerRepository.save(Beer.builder()
                    .beerName("Mongo Bobs")
                    .beerStyle("IPA")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(0631234200036L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(337088393930111L)
                    .price(new BigDecimal("11.95"))
                    .build());
        }

        //System.out.println("Loaded Beers: " + beerRepository.count());
    }
}

