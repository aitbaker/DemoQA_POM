package com.demoqa.tests.forms;

import com.demoqa.data.StudentData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.tests.TestBase;
import com.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();
    }

    @Test
    public void enterPracticeForm() {
        new PracticeFormPage(driver)
                .enterPersonalData(StudentData.FIRST_NAME,StudentData.LAST_NAME,
                        StudentData.EMAIL,StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER).typeOfDate(StudentData.B_DAY)
//                //.chooseDate("May","2000","13")
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .inputState(StudentData.STATE).inputCity(StudentData.CITY)
                .submitForm();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usingFile")
    public void fillStudentRegFormWithDataProviderTest(String firstName, String lastName, String email,
                                                       String phone, String birthDate, String file) {
        new PracticeFormPage(driver).enterPersonalData(firstName, lastName, email, phone)
                .selectGender(StudentData.GENDER).typeOfDate(birthDate)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(file);
    }
}
