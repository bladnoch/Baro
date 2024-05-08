package firstmarket.koreashop;

import firstmarket.koreashop.dto.ChangePasswordRequest;
import firstmarket.koreashop.item.ItemInfo;
import firstmarket.koreashop.item.ItemRepo;
import firstmarket.koreashop.item.ItemRepoTemp;
import firstmarket.koreashop.member.*;
import firstmarket.koreashop.upload.UploadService;
import firstmarket.koreashop.upload.UploadServiceImpl;


/**
 * 판매자가 물건을 업로드 하는 과정을 모사한 과정
 */
public class UserUploadItemApp {
    public static void main(String[] args) {

        MemberRepo memberRepo = new MemberRepoTemp();
        ItemRepo itemRepo = new ItemRepoTemp();
        MemberService memberService = new MemberServiceImpl(memberRepo);
        UploadService uploadService = new UploadServiceImpl(itemRepo,memberRepo);

        System.out.println("\n----------------start------------------");
        //User login page
        System.out.println("\n>> User Login page");
        Member member = new Member("dong5478@korea.ac.kr", "H!ehddnr0516", "김동욱", "01046054434");
        memberService.join(member);

        System.out.println("\n>> member sigh in");
        for (int i = 0; i < memberService.currentUser().length; i++) {
            System.out.println("- "+memberService.currentUser()[i]);
        }


        //User wants to find his ID
        String userId = memberService.findMemberIdByPhoneNumber("01046054434");
        System.out.println("\n>> User wants to find his ID = " + userId);


        //User wants to find(change) his PW
        memberService.changePwByPhoneNumber(new ChangePasswordRequest("01046054434","New!ehddnr0516"));
        String userNewPw = memberService.currentUser()[1];
        System.out.println("\n>> User wants to find(change) his PW = " + userNewPw);

        System.out.println("\n>> Changed personal information");
        for (int i = 0; i < memberService.currentUser().length; i++) {
            System.out.println("- "+memberService.currentUser()[i]);
        }


        //User main page
        System.out.println("\n>> User main page");
        itemRepo.findAllUploadedItemInfo();

        //user upload item page
        System.out.println("\n>> user upload item page");

        ItemInfo itemInfo = new ItemInfo("UserUploadItem", "try to know every methods are working"
                , "34300", memberService.currentUser()[0], "./images/UserUploadItem");

        //upload
        System.out.println("\n>> upload item info");
        uploadService.uploadItem(itemInfo);
        itemRepo.findAllUploadedItemInfo();

        System.out.println("\n----------------close------------------\n");

    }

}
