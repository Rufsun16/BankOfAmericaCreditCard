package BofACreditCardApplyPage;

import org.openqa.selenium.By;

public class CreditCardPage {
    public String pageUrl ="https://www.bankofamerica.com/credit-cards/#filter";
    public By applyNow = new By.ByXPath("//*[@id=\"home_4060812~NV~en_US\"]");
    public By firstName = new By.ByCssSelector("#customerFirstName");
    public By middleName = new By.ByCssSelector("#customerMiddleName");
    public By lastName = new By.ByCssSelector("#customerLastName");
    public By address = new By.ByCssSelector("#customerResidentialAddressOne");
    public By city = new By.ByCssSelector("#customerAddressCity");
    public By state = new By.ByCssSelector("#customerAddressState");
    public By zipCode = new By.ByCssSelector("#customerAddressInput");
    public By phoneNumber = new By.ByCssSelector("#customerPrimaryPhoneNumber");
    public By phoneNumberType = new By.ByCssSelector("[for='phoneNumberMobile']");
    public By email = new By.ByCssSelector("#customerEmailAddress");
    public By saveAndContinue = new By.ByCssSelector("#icaiContinueButton");
    public By yesUSCitizen = new By.ByCssSelector("#customerUsCitizenYes");
    public By dualCitizenNo = new By.ByCssSelector("#customerDualCitizenshipNo");
    public By SSN = new By.ByCssSelector("#customerSocialSecurityNumber");
    public By countryOfResidence = new By.ByCssSelector("#customerCountryOfResidence");
    public By dateOfBirth = new By.ByCssSelector("#customerBirthDate");
    public By employmentStatus = new By.ByCssSelector("#employmentStatus");
    public By occupation = new By.ByCssSelector("#occupation");
    public By totalAnnualIncome = new By.ByCssSelector("#annualSalary");
    public By sourceOfIncome = new By.ByCssSelector("#incomeSource");
    public By monthlyHousingPayment = new By.ByCssSelector("#monthlyHousingPayment");
    public By termsAndConditions = new By.ByCssSelector("#termsAndConditionsCheckBox");
    public By reviewInformationText = new By.ByCssSelector(".cnx-regular");
}
