package final_project;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class testClass extends CommonPageObject{
    public WebDriver edriver;

    public WebDriverWait ewait;

    DataField dataField;
    public testClass(){
        super(CommonPageObject.edriver);
        edriver = CommonPageObject.edriver;
        ewait = CommonPageObject.ewait;
        dataField = new DataField("src/main/java/final_project/testClass.xlsx");
    }

    @Test
    public void test() throws InterruptedException {
        //Test Case 1: Kiểm tra thông tin hiển thị trong bảng theo keyword
        //B1: Click chọn Searchbox và nhập vào Keyword = "may tinh"
        //B2: Click chọn nút "Filter by name" và xem kết quả
        //B3: Xóa Keyword trong search box
        //B4: Nhập vào Keyword = "ACE"
        //B5: Click chọn nút "Filter by name" và xem kết quả
//        waitUntilElementVisible(searchFilter);
//        setWait(2000);
//        searchInfor("may tinh",btnFilter,searchFilter);
//        setWait(2000);
//        searchFilter.clear();
//        searchInfor("AC",btnFilter,searchFilter);

        //Test Case 2: Kiểm tra Thông tin trang tiếp theo xuất hiện khi bấm Next và lùi lại trang trước khi bấm Previous
        //B1: Click chọn nút "Next"
        //B2: Click chọn nút "Previous"
//        setWait(2000);
//        buttonNext.click();
//        setWait(2000);
//        buttonPrevious.click();

        //Test Case 3: Kiểm tra Sắp xếp Computer name theo thứ tự giảm dần từ A-Z
        //B1: Click vào "Computer name" để sắp xếp từ Z-A
        //B2: Click thêm lần nữa vào "Computer name" để sắp xếp từ A-Z
        //Kết quả mong đợi: Thông tin cột Company name được sắp xếp theo đúng thứ tự
//        setWait(2000);
//        buttonSortUpName.click();
//
//        setWait(2000);
//        buttonSortDownName.click();

        //Test Case 4: Kiểm tra thông tin của một sản phẩm bất kỳ sau khi Update và Save
        //B1: Click chọn sản phẩm "ARRA"
        //B2: Cập nhật các thông tin mới cho sản phẩm
        //B3: Click chọn nút "Save this Computer"
        //B4: Kiểm tra lại thông tin sản phẩm "ARRA" sau khi đổi thành "Jipi"
        //Kết quả mong đợi: Thông tin sản phẩm sau khi cập nhật được hiển thị và thay thế cho sản phẩm cũ trên bảng
        setWait(1000);
        clickComputer.click();

        setWait(2000);
        inforComputer("Jipi","2022-12-01", textComputerName,textIntroduced,textDiscontinued
                , buttonCompany, buttonOption3);
        setWait(1000);
        buttonCreate.click();

        setWait(2000);
        searchInfor("Jipi",btnFilter,searchFilter);

        //Test Case 5: Danh sách computer có xuất hiện tên giống "nội dung ô B2" trong "testClass.xlsx". (Update va Cancel)
        //B1: sau khi tìm kiếm với từ khóa "ACE"
        //B2: chọn một computer bất kỳ trong danh sách computer
        //B3: update thông tin của một computer đó và click "Cancel"
//        setWait(2000);
//        searchFilter.clear();
//        searchInfor("ACE",btnFilter,searchFilter);
//
//        setWait(1000);
//        clickACE.click();
//
//        setWait(2000);
//        inforComputer("Test auto","2022-12-01", textComputerName,textIntroduced,textDiscontinued
//                , buttonCompany, buttonOption3);
//        setWait(1000);
//        buttonCancel.click();

        //Test Case 6: kiểm tra "ACE" sau khi "Delete this computer"
        //B1: Click chọn "ACE"
        //B2: Click chọn nút "Delete this Computer"
        //B3: Filter
//        setWait(2000);
//        clickComputer1.click();
//        setWait(2000);
//        clickdelete.click();
//        searchInfor("ACE",btnFilter,searchFilter);

        //Test Case 7: tạo new computer sau khi "add a new computer" và ấn "Save", Nhưng sai ngày
        //B1: Click nút "Add a new computer"
        //B2: Nhập thông tin (sai Introduced)
        //B3: Click chọn "Create"
//        buttonAddComputer.click();
//        setWait(2000);
//        inforComputer("Test auto","01-22-2022", textComputerName,textIntroduced,textDiscontinued
//                , buttonCompany, buttonOption3);
//
//        setWait(1000);
//        buttonCreate.click();
//        buttonCancel.click();

        //Test Case 8: Danh sách computer có xuất hiện tên computer giống "nội dung ô A2" của file "testClass.xlsx"
        //B1: Sau khi click "Add a new computer"
        //B2: Nhập thông tin hợp lệ
        //B3: Click "Create this computer"
        //B4: "Filter by name" với Keyword = "test"
//        String expected = dataField.getData(1, 1);
//        setWait(1000);
//        buttonAddComputer.click();
//        setWait(2000);
//        inforComputer("Test auto","2022-12-01", textComputerName,textIntroduced,textDiscontinued
//                , buttonCompany, buttonOption3);
//
//        setWait(1000);
//        buttonCreate.click();
//
//        setWait(1000);
//        searchInfor("test",btnFilter,searchFilter);
//        printCheckPass(expected);
//
//        Assert.assertEquals(expected,getListComputerName(expected));
    }
    @After
    public void tearDown() throws InterruptedException, IOException {
        dataField.closeWorkBook();
        setWait(3000);
        edriver.quit();
    }

}
