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
        assertEquals(Long.valueOf(787000) , new BillInformationUtility().getAmountFromPayId("78782730"));
        assertEquals(Long.valueOf(395000) , new BillInformationUtility().getAmountFromPayId("39580780"));
        assertEquals(Long.valueOf(289000) , new BillInformationUtility().getAmountFromPayId("28980711"));
    }

}