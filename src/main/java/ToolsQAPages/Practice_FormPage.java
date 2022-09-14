package ToolsQAPages;

import org.openqa.selenium.By;

public class Practice_FormPage extends FormsPage {
    public By practiceFormFirstName = new By.ByCssSelector("#firstName");
    public By practiceFormLastName = new By.ByCssSelector("#lastName");
    public By practiceFormEmail = new By.ByCssSelector("userEmail");
    public By practiceFormGenderMale = new By.ByCssSelector("#genterWrapper .custom-control:nth-child(1)");
    public By practiceFormGenderFemale = new By.ByCssSelector("#genterWrapper .custom-control:nth-child(2)");
    public By practiceFormGenderOther = new By.ByCssSelector("#genterWrapper .custom-control:nth-child(3)");
    public By practiceFormDOB = new By.ByCssSelector("dateOfBirthInout");
    public By practiceFormHobbiesSports = new By.ByCssSelector("#hobbiesWrapper .custom-control:nth-child(1)");
    public By practiceFormHobbiesReading = new By.ByCssSelector("#hobbiesWrapper .custom-control:nth-child(2)");
    public By practiceFormHobbiesMusic = new By.ByCssSelector("#hobbiesWrapper .custom-control:nth-child(3)");
    public By practiceFormCurrentAddress = new By.ByCssSelector("#currentAddress");
    public By practiceFormState = new By.ByCssSelector("#stateCity-wrapper #state .css-1wy0on6");
    public By practiceFormCity = new By.ByCssSelector("#stateCity-wrapper #city .css-1wy0on6");
    public By practiceFormSubmit = new By.ByCssSelector("#submit");
}
