//package firstmarket.koreashop;
//
//import firstmarket.koreashop.item.ItemInfo;
//import firstmarket.koreashop.item.ItemRepo;
//import firstmarket.koreashop.item.ItemRepoTemp;
//import firstmarket.koreashop.member.*;
//import firstmarket.koreashop.upload.UploadService;
//import firstmarket.koreashop.upload.UploadServiceImpl;
//
//
//public class UserBuyItemApp {
//    public static void main(String[] args) {
//        MemberRepo memberRepo = new MemberRepoTemp();
//        ItemRepo itemRepo = new ItemRepoTemp();
//
//        MemberService memberService = new MemberServiceImpl(memberRepo);
//        UploadService uploadService = new UploadServiceImpl(itemRepo, memberRepo);
//
//
//
//        //user sign in
//        Member member = new Member("dong5478@korea.ac.kr", "H!ehddnr0516", "김동욱", "01046054434");
//        memberService.join(member);
//
//        //setting up main page items
//        ItemInfo itemInfo = new ItemInfo("UserUploadItem", "try to know every methods are working"
//                , "34300", "random guy", "./images/UserUploadItem");
//        ItemInfo itemInfo1 = new ItemInfo(
//                "algorithms", "good condition", "12000",
//                "dk0520", "./image/dk0520-Photo");
//        ItemInfo itemInfo2 = new ItemInfo(
//                "math", "brand new", "10000",
//                "dong5478", "./image/userPhoto");
//
//        uploadService.uploadItem(itemInfo);
//        uploadService.uploadItem(itemInfo1);
//        uploadService.uploadItem(itemInfo2);
//
//        System.out.println("\n----------------start------------------");
//        //display main page items
//        System.out.println(">> items in DB");
//        uploadService.getMainpageItems();
//        for (int i=0;i<uploadService.getMainpageItems().size();i++) {
//            System.out.println("\n--------------------item #" + (i+1));
//            for (int j = 0; j < uploadService.getMainpageItems().get(i).length; j++) {
//                System.out.println("item #"+i+" = " + uploadService.getMainpageItems().get(i)[j]);
//            }
//        }
//
//        System.out.println("\n---------------------------------------");
//
//        //click item "algorithms"
//        System.out.println("\n>> click item algorithms");
//        itemRepo.saveClickedItemInfo(itemInfo1);
//        for (int i = 0; i < itemRepo.getSelectedItemInfo().length; i++) {
//            System.out.println("- " + itemRepo.getSelectedItemInfo()[i]);
//        }
//        //back to main page
//        itemRepo.deleteClickedItemInfo();
//
//        System.out.println("\n---------------------------------------");
//        //click itme "math"
//        System.out.println("\n>> click item math");
//        itemRepo.saveClickedItemInfo(itemInfo2);
//        for (int i = 0; i < itemRepo.getSelectedItemInfo().length; i++) {
//            System.out.println("- " + itemRepo.getSelectedItemInfo()[i]);
//        }
//
//        System.out.println("\n---------------------------------------");
//        //click reservation button
//        System.out.println("\n>> click reservation button");
//        uploadService.makeTrade();
//        for (int i = 0; i < itemRepo.getSelectedItemInfo().length; i++) {
//            System.out.println("- " + itemRepo.getSelectedItemInfo()[i]);
//        }
//        System.out.println("\n---------------------------------------");
//        //click cancel reservation button
//        System.out.println("\n>> click cancel reservation button");
//        uploadService.cancelTrade();
//        for (int i = 0; i < itemRepo.getSelectedItemInfo().length; i++) {
//            System.out.println("- " + itemRepo.getSelectedItemInfo()[i]);
//        }
//
//        System.out.println("\n-----------------end-------------------\n");
//
//    }
//}
