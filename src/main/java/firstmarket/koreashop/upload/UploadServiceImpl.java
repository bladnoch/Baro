package firstmarket.koreashop.upload;

import firstmarket.koreashop.item.ItemInfo;
import firstmarket.koreashop.item.ItemRepo;
import firstmarket.koreashop.member.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UploadServiceImpl implements UploadService {

    private final ItemRepo itemRepo;
    private final MemberRepo memberRepo;

    @Autowired
    public UploadServiceImpl(ItemRepo itemRepo, MemberRepo memberRepo) {
        this.itemRepo = itemRepo;
        this.memberRepo = memberRepo;
    }


    public void uploadItem(ItemInfo itemInfo){
        itemRepo.saveItemInfo(itemInfo);
    }

    public void makeTrade(){
        String currentUserId=memberRepo.getCurrentUserInfo()[0];
        itemRepo.makeReservation(currentUserId);
    }
    public void cancelTrade(){
        itemRepo.cancelReservation();
    }
    public ArrayList<String[]> getMainpageItems(){
        return itemRepo.getMainpageItemsByArray();
    }
    public void closeDeal(){} //  +
}
