package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;
import pages.component.ResultTableComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dayOfBirthInput = $("#dateOfBirthInput"),
            userSubjectInput = $("#subjectsInput"),
            userHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress =$("#currentAddress"),
            userStateSelect = $("#state"),
            userCitySelect = $("#city"),
            submitButton = $("#submit"),
            modalWindow = $(".modal-title.h4");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
    Configuration.pageLoadStrategy = "eager";
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
        return this;

    }

    public RegistrationPage setFirsName(String value) {
        firstNameInput.setValue(value);
        return this;

    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
        }
    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage userNumber(String value) {
        userNumber.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dayOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setUserSubjects(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        userHobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }


    public RegistrationPage setUserState(String value) {
        userStateSelect.click();
        userStateSelect.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserCity(String value) {
        userCitySelect.click();
        userCitySelect.$(byText(value)).click();

        return this;
    }
    public RegistrationPage submitRegistrationForm(String value) {
        submitButton.click();
        return this;
    }
    public RegistrationPage modalWindowShouldNotExist() {
        modalWindow.shouldNot(exist);

        return this;
    }
    public RegistrationPage checkUserData(String key, String value) {
        ResultTableComponent.checkResult(key, value);
        return this;
    }

    public RegistrationPage checkTableExist() {
        ResultTableComponent.checkExist();
        return this;
    }
}