package firstmarket.koreashop.item;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@ToString
@Component
@Getter
public class ItemRepoTemp implements ItemRepo{


    private static final ArrayList<String[]> itemStorage = new ArrayList<>();
    private static  String[] selectedItem = new String[7];
    public void saveItemInfo(ItemInfo itemInfo) {
        String[] tempItemInfo = new String[7];

        tempItemInfo[0]=itemInfo.getItemName();
        tempItemInfo[1]=itemInfo.getItemDetail();
        tempItemInfo[2]=itemInfo.getItemPrice();
        tempItemInfo[3]=itemInfo.getSellerId();
        tempItemInfo[4]=itemInfo.getBuyerId();
        tempItemInfo[5]=itemInfo.getImagePath();
        tempItemInfo[6]=itemInfo.getReservation();

        itemStorage.add(tempItemInfo);
    }

    public String checkItemByItemName(String itemName) {
        for (int i = 0; i < itemStorage.size(); i++) {
            if(itemName.equals(itemStorage.get(i)[0])){
                return itemStorage.get(i)[0];
            }
        }
        return "없습니다.";
    }

    public void findAllUploadedItemInfo() {

        if(itemStorage.size()==0){

            System.out.println("- 업로드된 아이템이 없습니다.");

        }

        else {

            for (int i = 0; i < itemStorage.size(); i++) {

                System.out.println("\nItem Information ---------- " + (i + 1));

                for (int j = 0; j < 7;j++) {

                    System.out.println("item No."+(i+1)+" = " + itemStorage.get(i)[j]);

                }
            }
        }
    }

    // when click and go to the detail page
    @Override
    public void saveClickedItemInfo(ItemInfo clickedItemInfo) {
        selectedItem[0]=clickedItemInfo.getItemName();
        selectedItem[1]=clickedItemInfo.getItemDetail();
        selectedItem[2]=clickedItemInfo.getItemPrice();
        selectedItem[3]=clickedItemInfo.getSellerId();
        selectedItem[4]=clickedItemInfo.getBuyerId();
        selectedItem[5]=clickedItemInfo.getImagePath();
        selectedItem[6]=clickedItemInfo.getReservation();
    }

    //when getting out of the detail page
    @Override
    public void deleteClickedItemInfo() {
        selectedItem[0]="";
        selectedItem[1]="";
        selectedItem[2]="";
        selectedItem[3]="";
        selectedItem[4]="";
        selectedItem[5]="";
        selectedItem[6]="";
    }


    // itemPath의 오리지날을 이용해 DB에 저장된 Item을 찾는다
    @Override
    public void makeReservation(String currentUserId) {
        for (int i = 0; i < itemStorage.size(); i++) {
            if(itemStorage.get(i)[5].equals(selectedItem[5])){
                String[] tempStorage = itemStorage.get(i);
                tempStorage[4] = currentUserId;
                tempStorage[6] = "yes";
                selectedItem[4] = currentUserId;
                selectedItem[6] = "yes";

                itemStorage.set(i, tempStorage);
            }
        }
    }

    @Override
    public void cancelReservation() {
        for (int i = 0; i < itemStorage.size(); i++) {
            if(itemStorage.get(i)[5].equals(selectedItem[5])){
                String[] tempStorage = itemStorage.get(i);
                tempStorage[4] = "";
                tempStorage[6] = "no";
                selectedItem[4] = "";
                selectedItem[6] = "no";

                itemStorage.set(i, tempStorage);
            }
        }
    }

    // print selected iteminfo, return item name
    @Override
    public String[] getSelectedItemInfo(){
        return selectedItem; // item name
    }

    @Override
    public String[] getItemInfoByImagePath(String path){
        for (int i = 0; i < itemStorage.size(); i++) {
            if (itemStorage.get(i)[5].equals(path)) {
                return itemStorage.get(i);
            }
        }
        System.out.println("not exist return empty list");
        String[] nothing = {"", "", "", "", "", "", ""};
        return nothing;
    }

    @Override
    public ArrayList<String[]> getMainpageItemsByArray() {
        return itemStorage;
    }
}
