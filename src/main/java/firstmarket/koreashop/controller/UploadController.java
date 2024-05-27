//package firstmarket.koreashop.controller;
//
//import firstmarket.koreashop.dto.MainpageItemsResponse;
//import firstmarket.koreashop.upload.UploadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class UploadController {
//    @Autowired
//    UploadService uploadService;
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    /**
//     * void uploadItem(ItemInfo itemInfo); //put
//     * void makeTrade(); //post
//     * void cancelTrade(); //post
//     * ArrayList<String[]> getMainpageItems(); //get
//     * void closeDeal(); //  +
//     */
//
//    @PostMapping("/uploadItem")
//    public void uploadItem(@RequestBody ItemInfo itemInfo) {
//        uploadService.uploadItem(itemInfo);
//    }
//
//    @GetMapping("/mainpage")
//    public List<MainpageItemsResponse> getMainpageItems() {
//        List<MainpageItemsResponse> responses = new ArrayList<>();
//        List<String[]> items = uploadService.getMainpageItems();
//
//        for (int i = 0; i < items.size(); i++) {
//            responses.add(new MainpageItemsResponse(items.get(i)));
//            System.out.println(responses.get(i));
//        }
//
//        return responses;
//    }
//
//}
