package firstmarket.koreashop.profile;

import firstmarket.koreashop.item.ItemRepo;
import firstmarket.koreashop.item.ItemRepoTemp;
import firstmarket.koreashop.member.*;
import firstmarket.koreashop.upload.UploadService;
import firstmarket.koreashop.upload.UploadServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalInfoTest {

    @Test
    void displayElementsOfProfileTest() {
        MemberRepo memberRepo = new MemberRepoTemp();
        MemberService memberService = new MemberServiceImpl(memberRepo);
        ItemRepo itemRepo = new ItemRepoTemp();
        UploadService uploadService = new UploadServiceImpl(itemRepo, memberRepo);


        Member member = new Member("dong5478@korea.ac.kr", "H!ehddnr0516", "김동욱", "01046054434");

        memberService.join(member);




    }

}