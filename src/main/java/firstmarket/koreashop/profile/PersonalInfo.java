package firstmarket.koreashop.profile;

public interface PersonalInfo {
    String getMemberPhoneNumber();
    String getMemberId();
    String[] MemberUploadedItem();
    String[] MemberReservedItem();
    String[] likedItem();
    void deleteMember();
}
