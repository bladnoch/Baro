package firstmarket.koreashop.domain.item;


import firstmarket.koreashop.domain.member.Member;
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

    public Item( String itemName, String itemDetail, long itemPrice, Long sellerId, Long buyerId, boolean reservation) {
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

    @ManyToOne
    private Member member;


    // origirnals
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false)
    private String itemDetail;
    @Column(nullable = false)
    private long itemPrice;
    private String imagePath;
    private boolean reservation;


    //
    @Column(nullable = false)
    private Long sellerId;
    private Long buyerId;


    public void addBuyerId(Long buyerId) {
        this.buyerId = buyerId;
        this.reservation = true;
    }

    public void deleteBuyerId(Long buyerId) {
        this.buyerId = null;
        this.reservation = false;
    }
}

