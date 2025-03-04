import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCaseTest {

    @Test
    void testMarkAsPassed(){
        TestCase tc = new TestCase("TC01", "Login Test");
        tc.markAsPassed();
        assertEquals(tc.getStatus(), TestCase.Status.PASSED);
        tc.resetStatus();
    }

    @Test
    void testMarkAsFailed(){
        TestCase tc = new TestCase("TC02", "Logout Test");
        tc.markAsFailed();
        assertEquals(tc.getStatus(), TestCase.Status.FAILED);
        tc.resetStatus();
    }
}
