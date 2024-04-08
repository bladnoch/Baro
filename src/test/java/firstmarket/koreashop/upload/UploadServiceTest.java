package firstmarket.koreashop.upload;

import firstmarket.koreashop.item.ItemInfo;
import firstmarket.koreashop.item.ItemRepo;
import firstmarket.koreashop.item.ItemRepoTemp;
import firstmarket.koreashop.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class UploadServiceTest {

    @Test
    void uploadItemTest() {
        ItemRepo itemRepo=new ItemRepoTemp();
        MemberRepo memberRepo = new MemberRepoTemp();
        UploadService uploadService = new UploadServiceImpl(itemRepo,memberRepo);

        //user input
        ItemInfo item = new ItemInfo("uploadItemTest", "new", "14200",
                "do5478", "./image/uploadItemTest");

        //complete upload
        uploadService.uploadItem(item);

        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/uploadItemTest")[0]).isEqualTo("uploadItemTest");
    }

    @Test
    void uploadItemTest_o() {

        //given
        ItemRepo itemRepo=new ItemRepoTemp();
        MemberRepo memberRepo = new MemberRepoTemp();
        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);

        ItemInfo itemInfo = new ItemInfo(
                "math", "brand new", "10000",
                "dong5478",  "./image/userPhoto");
        ItemInfo itemInfo1 = new ItemInfo(
                "algorithms", "good condition", "12000",
                "dk0520", "./image/dk0520-Photo");

        //when
        uploadService.uploadItem(itemInfo);
        uploadService.uploadItem(itemInfo1);

        //then
        Assertions.assertThat(itemRepo.checkItemByItemName("math")).isEqualTo("math");
    }

    @Test
    void uploadItemTest_x() {

        //given
        ItemRepo itemRepo=new ItemRepoTemp();
        MemberRepo memberRepo = new MemberRepoTemp();
        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);

        ItemInfo itemInfo = new ItemInfo(
                "math", "brand new", "10000",
                "dong5478", "./image/userPhoto");
        ItemInfo itemInfo1 = new ItemInfo(
                "algorithms", "good condition", "12000",
                "dk0520", "./image/dk0520-Photo");

        //when
        uploadService.uploadItem(itemInfo);
        uploadService.uploadItem(itemInfo1);

        itemRepo.findAllUploadedItemInfo(); //

        //then
        Assertions.assertThat(itemRepo.checkItemByItemName("math")).isNotEqualTo("algorithms");
    }

    @Test
    public void makeTradeTest(){
        ItemRepo itemRepo=new ItemRepoTemp();
        MemberRepo memberRepo = new MemberRepoTemp();
        MemberService memberService = new MemberServiceImpl(memberRepo);

        Member member=new Member("yujung0516", "yujungjung", "jujung kim", "0102464318");
        memberService.join(member);
        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);

        ItemInfo itemInfo1 = new ItemInfo(
                "algorithms", "good condition", "12000",
                "dk0520", "./image/dk0520-Photo");

        uploadService.uploadItem(itemInfo1);

        //when
        // 1. click item
        // 2. clicked item store in front side
        itemRepo.saveClickedItemInfo(itemInfo1);

        uploadService.makeTrade();

        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/dk0520-Photo")[4]).isEqualTo("yujung0516");
        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/dk0520-Photo")[6]).isEqualTo("yes");

    }

    @Test
    public void cancelTradeTest(){
        ItemRepo itemRepo=new ItemRepoTemp();
        MemberRepo memberRepo = new MemberRepoTemp();
        MemberService memberService = new MemberServiceImpl(memberRepo);

        Member member=new Member("yujung0516", "yujungjung", "jujung kim", "0102464318");
        memberService.join(member);
        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);

        ItemInfo itemInfo1 = new ItemInfo(
                "algorithms", "good condition", "12000",
                "dk0520", "./image/dk0520-Photo");

        uploadService.uploadItem(itemInfo1);

        //when
        // 1. click item
        // 2. clicked item store in front side
        itemRepo.saveClickedItemInfo(itemInfo1);

        uploadService.cancelTrade();

        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/dk0520-Photo")[4]).isEqualTo("");
        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/dk0520-Photo")[6]).isEqualTo("no");
        }

    @Test
    void getMainpageItemsTest() {
        ItemRepo itemRepo=new ItemRepoTemp();
        MemberRepo memberRepo = new MemberRepoTemp();

        MemberService memberService = new MemberServiceImpl(memberRepo);

        Member member=new Member("yujung0516", "yujungjung", "jujung kim", "0102464318");
        memberService.join(member);
        UploadService uploadService = new UploadServiceImpl(itemRepo,memberRepo);

        ItemInfo itemInfo1 = new ItemInfo(
                "algorithms", "good condition", "12000",
                "dk0520", "./image/dk0520-Photo");
        ItemInfo itemInfo2 = new ItemInfo(
                "a", "e", "40330",
                "dk0520",  "./image/dk0520-Photo");
        ItemInfo itemInfo3 = new ItemInfo(
                "s", "like new", "12000",
                "kdk33",  "./image/dk0520-Photo");
        ItemInfo itemInfo4 = new ItemInfo(
                "d", "used", "12000",
                "kdk", "./image/dk0520-Photo");

        uploadService.uploadItem(itemInfo1);
        uploadService.uploadItem(itemInfo2);
        uploadService.uploadItem(itemInfo3);
        uploadService.uploadItem(itemInfo4);

        ArrayList<String[]> itemsInMainpage = uploadService.getMainpageItems();

        System.out.println("UploadServiceTest.getMainpageItemsTest");
        int size = itemRepo.getMainpageItemsByArray().size();
        System.out.println("size = " + size);


        Assertions.assertThat(itemsInMainpage.get(size-1)[0]).isEqualTo("d");
        Assertions.assertThat(itemsInMainpage.get(size-2)[3]).isEqualTo("kdk33");


    }

}