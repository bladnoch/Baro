package firstmarket.koreashop.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class MainpageItemsResponse {

    public MainpageItemsResponse(String[] items) {
        this.itemName = items[0];
        this.itemDetail = items[1];
        this.itemPrice = items[2];
        this.sellerId = items[3];
        this.buyerId = items[4];
        this.imagePath = items[5];
        this.reservation = items[6];
    }

    private String itemName;
    private String itemDetail;
    private String itemPrice;
    private String sellerId;
    private String buyerId;
    private String imagePath;
    private String reservation;


}
