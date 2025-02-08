package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class FormDemoqaPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFullFormTest() {

        registrationPage.openPage()
                .setFirsName("Виктор")
                .setLastName("Рыбаков")
                .setUserEmail("7152955@gmail.com")
                .setGender("Male")
                .userNumber("0123456789")
                .setDateOfBirth("10", "April", "1989")
                .setUserSubjects("Computer Science")
                .setHobbies("Music")
                .setPicture("img/1.png")
                .setAddress("Мск")
                .setUserState("NCR")
                .setUserCity("Gurgaon")
                .submitRegistrationForm("#submit")
                .checkUserData("Student Name", "Виктор Рыбаков")
                .checkUserData("Student Email", "7152955@gmail.com")
                .checkUserData("Gender", "Male")
                .checkUserData("Mobile", "0123456789")
                .checkUserData("Date of Birth", "10 April,1989")
                .checkUserData("Subjects", "Computer Science")
                .checkUserData("Hobbies", "Music")
                .checkUserData("Picture", "1.png")
                .checkUserData("Address", "Мск")
                .checkUserData("State and City", "NCR Gurgaon");




    }

    @Test
    void fillMinimalFormTest() {

        registrationPage.openPage()
                .setFirsName("Виктор")
                .setLastName("Рыбаков")
                .setUserEmail("7152955@gmail.com")
                .setGender("Male")
                .userNumber("0123456789")
                .submitRegistrationForm("#submit")

                .checkUserData("Student Name", "Виктор Рыбаков")
                .checkUserData("Student Email", "7152955@gmail.com")
                .checkUserData("Gender", "Male")
                .checkUserData("Mobile", "0123456789");

    }


        @Test
        void fillFailFormTest() {

            registrationPage.openPage()
                    .setFirsName("Виктор")
                    .setLastName("Рыбаков")
                    .submitRegistrationForm("#submit")
                    .modalWindowShouldNotExist();
        }

}



