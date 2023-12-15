package progressSoft.java.springboot.modal;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "testDeals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column(name="from_currency")
    private String fromCurrency="";

    @Column(name="to_currency")
    private String toCurrency="";

    @Column(name="deal_Timestamp")
    private String dealTimestamp="";

    @Column(name="deal_amount")
    private String dealAmount="";

}
