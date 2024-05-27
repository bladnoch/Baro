package firstmarket.koreashop.controller.item;


import firstmarket.koreashop.dto.item.ItemBuyRequest;
import firstmarket.koreashop.dto.item.ItemCancelRequest;
import firstmarket.koreashop.dto.item.ItemCreateRequest;
import firstmarket.koreashop.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item")
    public void saveItem(@RequestBody ItemCreateRequest request) {
        itemService.saveItem(request);
    }

    @DeleteMapping("/item")
    public void deleteItem(@RequestParam Long itemId) {
        itemService.deleteItem(itemId);
    }

    @PostMapping("/item/buy")
    public void buyItem(ItemBuyRequest request) {
        itemService.buyItem(request);
    }

    @PostMapping("/item/cancel")
    public void cancelItem(ItemCancelRequest request) {
        itemService.cancelItem(request);
    }

}
