package firstmarket.koreashop.domain.item;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    public Item(String itemName, String itemDetail, long itemPrice, String sellerId, String buyerId, boolean reservation) {
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemPrice = itemPrice;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.imagePath = null;
        this.reservation = reservation;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=null;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String itemDetail;

    @Column(nullable = false)
    private long itemPrice;

    @Column(nullable = false)
    private String sellerId;

    private String buyerId;
    private String imagePath;
    private boolean reservation;
}

