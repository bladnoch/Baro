package firstmarket.koreashop.service.item;

import firstmarket.koreashop.domain.item.Item;
import firstmarket.koreashop.domain.item.ItemRepository;
import firstmarket.koreashop.domain.member.MemberRepository;
import firstmarket.koreashop.dto.item.ItemBuyRequest;
import firstmarket.koreashop.dto.item.ItemCancelRequest;
import firstmarket.koreashop.dto.item.ItemCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveItem(ItemCreateRequest request) {
        itemRepository.save(
                new Item(request.getItemName(),
                        request.getItemDetail(),
                        request.getItemPrice(),
                        request.getSellerId(),
                        request.getBuyerId(),
                        request.isReservation()));
    }

    @Transactional
    public void deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(IllegalAccessError::new);
        itemRepository.delete(item);
    }


    @Transactional
    public void buyItem(ItemBuyRequest request) {
    // request.getSellerId(), request.getBuyerId(), request.getItemName()
        Item item = itemRepository.findBySellerIdAndItemName(request.getSellerId(), request.getItemName())
                .orElseThrow(IllegalArgumentException::new);

        if (item.getBuyerId() != null) {
            throw new IllegalArgumentException(String.format("유저 아이디 (%s)이 구매를 예약했습니다.", item.getBuyerId()));
        }

        item.addBuyerId(request.getBuyerId());

    }

    @Transactional
    public void cancelItem(ItemCancelRequest request) {

        Item item = itemRepository.findBySellerIdAndBuyerIdAndItemName(request.getSellerId(), request.getBuyerId(), request.getItemName())
                .orElseThrow(IllegalAccessError::new);

        item.deleteBuyerId(request.getBuyerId());

    }
}
