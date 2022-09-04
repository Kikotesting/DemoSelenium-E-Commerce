package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends BasePage {
    WebDriver driver;
    public AccountPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")public WebElement authenticationHeaderPage;
    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3") public WebElement personalInformationBlock;
    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[2]/h3") public WebElement personalAddress;
    @FindBy(xpath = "//*[@id=\"submitAccount\"]/span") public WebElement registerButton;
    //Personal info elements
    @FindBy(id = "id_gender1")WebElement radioBtnMr;
    @FindBy(id = "customer_firstname")WebElement customerFirstName;
    @FindBy(id = "customer_lastname")WebElement customerLastName;
    @FindBy(id = "email")WebElement customerEmail;
    @FindBy(id = "passwd")WebElement customerPasswd;
    @FindBy(xpath = "//*[@id=\"days\"]")WebElement dateBirthDropdown;
    @FindBy(xpath = "//*[@id=\"months\"]")WebElement monthBirthDropdown;
    @FindBy(xpath = "//*[@id=\"years\"]")WebElement yearsBirthDropdown;
    @FindBy(xpath = "//*[@id=\"optin\"]")WebElement receiveOffersCheckBox;
    public void populatePersonalInfo(String firstname,
                                     String lastname,
                                     String email,
                                     String customerPassword){
        radioBtnMr.click();
        customerFirstName.sendKeys(firstname);
        customerLastName.sendKeys(lastname);
        customerEmail.clear();
        customerEmail.sendKeys(email);
        customerPasswd.sendKeys(customerPassword);
        Select selectDate = new Select(dateBirthDropdown);
        selectDate.selectByValue("6");
        Select selectMonth = new Select(monthBirthDropdown);
        selectMonth.selectByValue("6");
        Select selectYear = new Select (yearsBirthDropdown);
        selectYear.selectByValue("2006");
        receiveOffersCheckBox.click();
    }

    // Personal address elements
    @FindBy(id = "firstname")WebElement inputFirstName;
    @FindBy(id = "lastname")WebElement inputLastName;
    @FindBy(id = "address1")WebElement inputAddress;
    @FindBy(id = "city")WebElement inputCity;
    @FindBy(xpath = "//*[@id=\"id_state\"]")WebElement stateDropdown;
    @FindBy(name = "postcode")WebElement zipPostalcode;
    @FindBy(xpath = "//*[@id=\"id_country\"]")WebElement countryDropdown;
    @FindBy(id = "phone_mobile")WebElement mobilePhone;
    @FindBy(name = "alias")WebElement addressReference;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")public WebElement welcomeMessage;
    public void populatePersonalAddress(String firstname,
                                        String lastname,
                                        String address,
                                        String city,
                                        String postalcode,
                                        String mobile,
                                        String emailReference){
        inputFirstName.sendKeys(firstname);
        inputLastName.sendKeys(lastname);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);
        Select selectState = new Select(stateDropdown);
        selectState.selectByValue("43");
        zipPostalcode.sendKeys(postalcode);
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByValue("21");
        mobilePhone.sendKeys(mobile);
        addressReference.clear();
        addressReference.sendKeys(emailReference);
    }

}