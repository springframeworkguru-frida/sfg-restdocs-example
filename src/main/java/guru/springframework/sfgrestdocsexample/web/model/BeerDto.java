package guru.springframework.sfgrestdocsexample.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Null 外部无法修改read-only properties for client's side，create beer pojo will bind to 会有id version等
public class BeerDto {

    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    @Size(min = 3,max = 100)
    private String beerName;

    @NotNull
    private BeerStyleEnum beerStyle;

    @Positive
    @com.sun.istack.NotNull
    private Long upc;

    @NotNull
    @Positive
    private BigDecimal price;

    @Positive
    private Integer quantityOnHand;


}
