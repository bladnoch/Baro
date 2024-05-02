package firstmarket.koreashop.dto;

public class CurrentUserResponse {
    private String currentId;
    private String currentPw;
    private String currentName;
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

    public CurrentUserResponse(String[] currentUser) {
        this.currentId = currentUser[0];
        this.currentPw = currentUser[1];
        this.currentName = currentUser[2];
        this.phoneNumber = currentUser[3];
    }
}
