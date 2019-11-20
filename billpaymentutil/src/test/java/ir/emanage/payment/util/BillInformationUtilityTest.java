package ir.emanage.payment.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Arman
 * Date: 11/6/19
 * Time: 12:17 PM
 **/
class BillInformationUtilityTest {
    @Test
    void getAmountFromPayId_Successful_CorrectAmount() {
        BillInformationUtility billInformationUtility = new BillInformationUtility();
        assertEquals(Long.valueOf(787000) , billInformationUtility.getAmountFromPayId("78782730"));
        assertEquals(Long.valueOf(395000) , billInformationUtility.getAmountFromPayId("39580780"));
        assertEquals(Long.valueOf(289000) , billInformationUtility.getAmountFromPayId("28980711"));
    }

    @Test
    void getBillTypeFromBillId_CorrectValue(){
        BillInformationUtility billInformationUtility = new BillInformationUtility();
        assertEquals(BillType.MOBILE_PHONE,billInformationUtility.getBillType("5516674930156"));
        assertEquals(BillType.ELECTRICITY,billInformationUtility.getBillType("9395954204127"));
        assertEquals(BillType.ELECTRICITY,billInformationUtility.getBillType("9943873404129"));
    }

    @Test
    void getSubCompanyCodeFromBillId_CorrectValue(){
        BillInformationUtility billInformationUtility = new BillInformationUtility();
        assertEquals("301",billInformationUtility.getSubCompanyCode("5516674930156"));
        assertEquals("041",billInformationUtility.getSubCompanyCode("9395954204127"));
        assertEquals("041",billInformationUtility.getSubCompanyCode("9943873404129"));
    }
}