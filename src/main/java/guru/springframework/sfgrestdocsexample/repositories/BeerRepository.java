package guru.springframework.sfgrestdocsexample.repositories;

import guru.springframework.sfgrestdocsexample.domain.Beer;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
