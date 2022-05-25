package elements;

import basetest.BaseTest;
import com.company.gitc.ManipulateElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class METest extends BaseTest {


    @Test
    public void testME() {
        ManipulateElements me = new ManipulateElements(getDriver(), getAs());
        String text = me.dragAndDrop();
        Assert.assertEquals(text, "Dropped!");
    }
}
