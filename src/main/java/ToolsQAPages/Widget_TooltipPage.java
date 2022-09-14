package ToolsQAPages;

import org.openqa.selenium.By;

public class Widget_TooltipPage extends WidgetPage {
    public By hoverButton = new By.ByCssSelector("#toolTipButton");
    public By toolTip = new By.ByCssSelector(".tooltip-inner");
    public By toolTipTextField = new By.ByCssSelector("#toolTipTextField");
    public By contrary = new By.ByCssSelector("#texToolTopContainer > a:nth-child(1)");
    public By section = new By.ByCssSelector("#texToolTopContainer > a:nth-child(2)");

}
