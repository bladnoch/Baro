package firstmarket.koreashop.service.item;

import firstmarket.koreashop.dto.item.ItemBuyRequest;
import firstmarket.koreashop.dto.item.ItemCancelRequest;
import firstmarket.koreashop.dto.item.ItemCreateRequest;

public interface ItemService {

    void saveItem(ItemCreateRequest request);

    void deleteItem(Long itemId);

    void buyItem(ItemBuyRequest request);

    void cancelItem(ItemCancelRequest request);

}
