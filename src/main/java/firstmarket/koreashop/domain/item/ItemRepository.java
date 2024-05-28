package firstmarket.koreashop.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findBySellerIdAndItemName(Long sellerId, String itemName);

    Optional<Item> findBySellerIdAndBuyerIdAndItemName(Long sellerId, Long buyerId, String itemName);
}
