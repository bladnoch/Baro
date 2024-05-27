package firstmarket.koreashop.dto.item;


import lombok.Getter;

@Getter
public class ItemCreateRequest {

    public ItemCreateRequest(String itemName, String itemDetail, long itemPrice, String sellerId) {
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemPrice = itemPrice;
        this.sellerId = sellerId;
        this.buyerId = null;
        this.imagePath = null;
        this.reservation = false;
    }

    private Long id=null;


    private String itemName;
    private String itemDetail;
    private long itemPrice;
    private String sellerId;
    private String buyerId;
    private String imagePath;
    private boolean reservation;
}
