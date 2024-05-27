//package firstmarket.koreashop.item;
//
//
//
//import firstmarket.koreashop.member.*;
//import firstmarket.koreashop.upload.UploadServiceImpl;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//class ItemRepoTempTest {
//
//    @Test
//    void saveClickedItemInfoTest() {
//        // given : One item saved in DB
//        ItemRepo itemRepo=new ItemRepoTemp();
//        MemberRepo memberRepo = new MemberRepoTemp();
//        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);
//        //save item
//        ItemInfo myItem = new ItemInfo("math", "brand new", "10000",
//                "dong5478", "./image/userPhoto");
//        uploadService.uploadItem(myItem);
//        itemRepo.findAllUploadedItemInfo(); //not part of this code
//
//        // When : click item for see the detail
//        // 1.click item
//        // 2.clicked item store in front side
//        itemRepo.saveClickedItemInfo(myItem);
//
//
//        // Then
//        Assertions.assertThat(itemRepo.getSelectedItemInfo()[0]).isEqualTo("math");
//    }
//
//    @Test
//    void deleteClickedItemInfoTest() {
//        // given : One item saved in DB
//        ItemRepo itemRepo=new ItemRepoTemp();
//        MemberRepo memberRepo = new MemberRepoTemp();
//        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);
//        //save item
//        ItemInfo myItem = new ItemInfo("math", "brand new", "10000",
//                "dong5478", "./image/userPhoto");
//        ItemInfo myItem2 = new ItemInfo("algorithm", "used", "12000",
//                "dong5478", "./image/user/algorithmbook");
//        uploadService.uploadItem(myItem2);
//        uploadService.uploadItem(myItem);
//        itemRepo.findAllUploadedItemInfo(); //not part of this code
//
//        // When : click item for see the detail
//        // 1.click item
//        // 2.clicked item store in front side
//        itemRepo.saveClickedItemInfo(myItem);
//        //3. go back to menu
//        itemRepo.deleteClickedItemInfo();
//
//        // Then
//        Assertions.assertThat(itemRepo.getSelectedItemInfo()[0]).isEqualTo("");
//
//
//    }
//
//    @Test
//    void makeReservationTest() {
//        // save loged in user
//        MemberRepo memberRepo =new MemberRepoTemp();
//        MemberService memberService= new MemberServiceImpl(memberRepo);
//        Member member=new Member("yujung0516", "yujungjung", "jujung kim", "0102464318");
//        memberService.join(member);
//
//        // Two item saved in ItemInfoDB
//        ItemRepo itemRepo=new ItemRepoTemp();
//        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);
//        // save one items in DB
//        ItemInfo myItem2 = new ItemInfo("algorithm", "used", "12000",
//                "dong5478", "./image/user/algorithmbook");
//        uploadService.uploadItem(myItem2);
//
//
//        // 1. click item
//        // 2. clicked item store in front side
//        itemRepo.saveClickedItemInfo(myItem2);
//
//        // When : click reservation button
//        // 3. make reservation
//        itemRepo.makeReservation(memberRepo.getCurrentUserInfo()[0]); //예약
//
//        //Then
//        Assertions.assertThat(itemRepo.getSelectedItemInfo()[4]).isEqualTo(itemRepo.getItemInfoByImagePath("./image/user/algorithmbook")[4]);
//        Assertions.assertThat(itemRepo.getSelectedItemInfo()[6]).isEqualTo(itemRepo.getItemInfoByImagePath("./image/user/algorithmbook")[6]);
//    }
//
//    @Test
//    void cancelReservationTest() {
//        // save loged in user
//        MemberRepo memberRepo =new MemberRepoTemp();
//        MemberService memberService= new MemberServiceImpl(memberRepo);
//        Member member=new Member("yujung0516", "yujungjung", "jujung kim", "0102464318");
//        memberService.join(member);
//
//        // Two item saved in ItemInfoDB
//        ItemRepo itemRepo=new ItemRepoTemp();
//        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);
//        // save one items in DB
//        ItemInfo myItem2 = new ItemInfo("algorithm", "used", "12000",
//                "dong5478",  "./image/user/algorithmbook");
//        uploadService.uploadItem(myItem2);
//
//
//        // 1. click item
//        // 2. clicked item store in front side
//        itemRepo.saveClickedItemInfo(myItem2);
//
//        itemRepo.cancelReservation();
//
//        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/user/algorithmbook")[4]).isEqualTo("");
//        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/user/algorithmbook")[6]).isEqualTo("no");
//    }
//
//    @Test
//    void getItemInfoByImagePathTest_o() {
//        // given : One item saved in DB
//        ItemRepo itemRepo=new ItemRepoTemp();
//        MemberRepo memberRepo = new MemberRepoTemp();
//        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);
//        //save item
//        ItemInfo myItem = new ItemInfo("math", "brand new", "10000",
//                "dong5478", "./image/userPhoto");
//        ItemInfo myItem2 = new ItemInfo("algorithm", "used", "12000",
//                "dong5478", "./image/user/algorithmbook");
//        uploadService.uploadItem(myItem2);
//        uploadService.uploadItem(myItem);
//
//        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/user/algorithmbook")[5]).isEqualTo("./image/user/algorithmbook");
//    }
//
//    @Test
//    void getItemInfoByImagePathTest_x() {
//        // given : One item saved in DB
//        ItemRepo itemRepo=new ItemRepoTemp();
//        MemberRepo memberRepo = new MemberRepoTemp();
//        UploadServiceImpl uploadService = new UploadServiceImpl(itemRepo,memberRepo);
//        //save item
//        ItemInfo myItem = new ItemInfo("math", "brand new", "10000",
//                "dong5478","./image/userPhoto");
//        ItemInfo myItem2 = new ItemInfo("algorithm", "used", "12000",
//                "dong5478",  "./image/user/algorithmbook");
//        uploadService.uploadItem(myItem2);
//        uploadService.uploadItem(myItem);
//
//        Assertions.assertThat(itemRepo.getItemInfoByImagePath("./image/user/algorithmbook2")[5]).isNotEqualTo("./image/user/algorithmbook");
//    }
//
//}