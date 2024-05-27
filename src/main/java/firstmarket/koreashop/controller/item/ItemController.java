package firstmarket.koreashop.controller.item;


import firstmarket.koreashop.dto.item.ItemCreateRequest;
import firstmarket.koreashop.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private ItemService itemService;

    @PostMapping("/item")
    public void saveItem(@RequestBody ItemCreateRequest request) {

    }

}
