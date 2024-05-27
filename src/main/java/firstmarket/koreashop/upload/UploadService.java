package firstmarket.koreashop.upload;

import firstmarket.koreashop.domain.item.ItemInfo;

import java.util.ArrayList;

public interface UploadService {
    void uploadItem(ItemInfo itemInfo); //put
    void makeTrade(); //post
    void cancelTrade(); //post
    ArrayList<String[]> getMainpageItems(); //get
    void closeDeal(); //  +
}