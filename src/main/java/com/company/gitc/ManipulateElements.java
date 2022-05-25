package com.company.gitc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManipulateElements {
    final WebDriver driver;
    final Actions builder;

    @FindBy(id = "draggable")
    WebElement from;

    @FindBy(id = "droppable")
    WebElement to;

    public ManipulateElements(WebDriver driver, Actions builder) {
        this.driver = driver;
        this.builder = builder;
        PageFactory.initElements(driver, this);
    }

    public String dragAndDrop() {
        this.builder.dragAndDrop(from, to).build().perform();
        return to.getText();
    }
}
