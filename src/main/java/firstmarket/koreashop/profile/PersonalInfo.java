package firstmarket.koreashop.profile;

import java.util.ArrayList;

public interface PersonalInfo {

    /**
     * [0]=phoneNumber, [1]=name
     * @return userPhoneNumber, userName
     */
    String[] displayElementsOfProfile();

    /**
     * All items that user uploaded
     * @return ArrayList<String> list of uploaded items
     */
    ArrayList<String> MemberUploadedItem();
    /**
     * All items that user reserved
     * @return ArrayList<String> list of reserved items
     */
    ArrayList<String> MemberReservedItem();
    /**
     * All items that user liked
     * @return ArrayList<String> list of like items
     */
    ArrayList<String> likedItem();

    /**
     * delete member info
     */
    void deleteMember();
}
