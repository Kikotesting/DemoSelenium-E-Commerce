package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver){
        super (driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")public WebElement breadcrumbHeader;
    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[1]/h3") public WebElement personalInformation;
    @FindBy(xpath = "//*[@id=\"account-creation_form\"]/div[2]/h3") public WebElement personalAddress;
    @FindBy(xpath = "//*[@id=\"submitAccount\"]/span") public WebElement register_btn;
    //Personal info elements
    @FindBy(id = "id_gender1")WebElement radioMr_btn;
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
        radioMr_btn.click();
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
    @FindBy(name = "postcode")WebElement zipPostalCode;
    @FindBy(xpath = "//*[@id=\"id_country\"]")WebElement countryDropdown;
    @FindBy(id = "phone_mobile")WebElement mobilePhone;
    @FindBy(name = "alias")WebElement addressReference;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")public WebElement welcomeMessage;
    @FindBy(className = "logout") public WebElement logOutButton;
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
        zipPostalCode.sendKeys(postalcode);
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByValue("21");
        mobilePhone.sendKeys(mobile);
        addressReference.clear();
        addressReference.sendKeys(emailReference);
    }
}