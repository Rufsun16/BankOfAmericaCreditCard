package ToolsQAPages;

import org.openqa.selenium.By;

public class Selectable_ListPage extends SelectablePage {
    public By selectableList1 = new By.ByCssSelector("#verticalListContainer :nth-child(1)");
    public By selectableList2 = new By.ByCssSelector("#verticalListContainer :nth-child(2)");
    public By selectableList3 = new By.ByCssSelector("#verticalListContainer :nth-child(3)");
    public By selectableList4 = new By.ByCssSelector("#verticalListContainer :nth-child(4)");
}
