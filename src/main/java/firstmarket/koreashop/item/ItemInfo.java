package firstmarket.koreashop.item;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ItemInfo {
    public ItemInfo(String itemName, String itemDetail, String itemPrice, String sellerId, String imagePath) {
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemPrice = itemPrice;
        this.sellerId = sellerId;
        this.buyerId = "";
        this.imagePath = imagePath;
        this.reservation = "no";
    }

    private String itemName;
    private String itemDetail;
    private String itemPrice;
    private String sellerId;
    private String buyerId;
    private String imagePath;
    private String reservation;
}

