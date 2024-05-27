package firstmarket.koreashop.legacy;

public class CurrentUserResponse {
    private String currentId;
    private String currentPw;
    private String currentName;

    public CurrentUserResponse(String currentId, String currentPw, String currentName, String phoneNumber) {
        this.currentId = currentId;
        this.currentPw = currentPw;
        this.currentName = currentName;
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;

    public String getCurrentId() {
        return currentId;
    }

    public String getCurrentPw() {
        return currentPw;
    }

    public String getCurrentName() {
        return currentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
