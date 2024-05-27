//package firstmarket.koreashop.item;
//
//import firstmarket.koreashop.domain.item.ItemInfo;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//
//@Repository
//public interface ItemRepo {
//    /**
//     * seller uploads new item
//     * @param itemInfo : user input in detail page
//     */
//    void saveItemInfo(ItemInfo itemInfo);
//
//    /**
//     * test usage
//     * if input(item name) in itemStorage -> return(item name)
//     * @param itemName typed in item name
//     * @return if item storage has same item name, return item name
//     */
//    String checkItemByItemName(String itemName);
//
//    /**
//     * test usage
//     * print all itemInfos
//     */
//    void findAllUploadedItemInfo();
//
//    /**
//     * runs when user clicks reservation button
//     * make changes on itemInfo that user is watching
//     * @param currnetUserId : loged in user's id
//     */
//    void makeReservation(String currnetUserId);
//
//    /**
//     * cancel reservation that user is watching in item detail page
//     */
//    void cancelReservation();
//
//    /**
//     * 상세페이지, 메뉴 이동시
//     * 선택한 물건 정보 param에 저장, 삭제
//     * @param clickedItemInfo : 상세페이지에 나올 아이템 디스플레이
//     */
//    // frontend로부터 clickedItemInfo를 받는다고 가정
//    void saveClickedItemInfo(ItemInfo clickedItemInfo);
//
//    /**
//     * runs when getting out of the item detail page for empty
//     * temporary saved item info that user watched
//     */
//    void deleteClickedItemInfo();
//    String[] getSelectedItemInfo();
//    String[] getItemInfoByImagePath(String path);
//
//    /**
//     * 두번쨰 호출될 때 첫번째 호출된 아이템의 마지막 아이텡을 확인해서 두번째 호출할 아이템의 범위를 지정
//     * @return : 모든 아이템 정보를 arraylist로 반환
//     */
//    ArrayList<String[]> getMainpageItemsByArray();
//
//}
