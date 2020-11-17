package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShopPageTests extends CommonMethods {
	
	@BeforeTest
	public void initialSetup() {
		browserSetup();
	}
	
	@Test(description = "Verify items in shopping cart")
	public void verifyItemsInShoppingCart() throws InterruptedException {
		click("shop_ID");
		click("funnycow_XPATH");
		click("funnycow_XPATH");
		click("fluffybunny_XPATH");
		click("cart_ID");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText(), "Funny Cow");
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText(), "Fluffy Bunny");
	}

}
