package firstmarket.koreashop.service.item;

import firstmarket.koreashop.domain.item.Item;
import firstmarket.koreashop.domain.item.ItemRepository;
import firstmarket.koreashop.dto.item.ItemCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public void saveItem(ItemCreateRequest request) {
        itemRepository.save(
                new Item(request.getItemName(),
                        request.getItemDetail(),
                        request.getItemPrice(),
                        request.getSellerId(),
                        request.getBuyerId(),
                        request.isReservation()));
    }
}
