package firstmarket.koreashop.profile;

import firstmarket.koreashop.member.MemberRepo;
import firstmarket.koreashop.member.MemberService;
import firstmarket.koreashop.upload.UploadService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PersonalInfoImpl {

    private final UploadService uploadService;
    private final MemberService memberService;

    public PersonalInfoImpl(MemberService memberService, UploadService uploadService) {
        this.memberService = memberService;
        this.uploadService = uploadService;
    }

    public String[] displayElementsOfProfile() {
        return new String[]{memberService.currentUser()[3], memberService.currentUser()[0]};
    }

    public ArrayList<String> MemberUploadedItem() {
        return null;
    }

    public ArrayList<String> MemberReservedItem() {
        return null;
    }

    public ArrayList<String> likedItem() {
        return null;
    }

    public void deleteMember() {
        memberService.currentUser();
    }
}
