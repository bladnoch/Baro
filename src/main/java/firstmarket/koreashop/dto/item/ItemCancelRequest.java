package firstmarket.koreashop.dto.item;

import lombok.Getter;

@Getter
public class ItemCancelRequest {
    private Long buyerId;
    private Long sellerId;
    private String itemName;

    public ItemCancelRequest(Long buyerId, Long sellerId, String itemName) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.itemName = itemName;
    }
}
