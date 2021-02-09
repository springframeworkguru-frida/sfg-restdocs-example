package guru.springframework.sfgrestdocsexample.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//hibernate entity
public class Beer {

    @Id
    @GeneratedValue(generator = "UUID")
    //when create an entity hibernate will auto generate the uuid settings for us
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    //never be able to change
    private UUID id;

    @Version
    //optimistic locking乐观锁
    private Long version;

    @CreationTimestamp
    //hibernate is an implementation of the JPA api
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    private String beerName;
    private String beerStyle;

    @Column(unique = true)
    private Long upc;
    private BigDecimal price;

    private Integer minOnHand;
    private Integer quantityToBrew;
}
