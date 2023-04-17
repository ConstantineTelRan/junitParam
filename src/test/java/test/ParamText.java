package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import page.TextBoxPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParamText extends TestBase {
    TextBoxPage textBox;

    @BeforeEach
    public void openUrl() {
        driver.get("https://demoqa.com/text-box");
    }

    @ParameterizedTest
    @ValueSource(strings = {"John", "Kate", "Peter"})
    public void boxTest_1(String name) {
        textBox = new TextBoxPage(driver);
        textBox.fillTextBox(name, "mail@gmail.com", "currentAddress", "permanentAddress");
        textBox.waitText();
        assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        assertEquals(textBox.getTextFromInfoField("email"), "Email:" + "mail@gmail.com");
        assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + "currentAddress");
        assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + "permanentAddress");
    }

    @ParameterizedTest
    @CsvSource({"John2,john@gmail.com,John address 1,John address 2", "Kate2,kate@gmail.com,Kate address 1,Kate address 2",
    "Peter3,peter@gmail.com,Peter address 1,Peter address 2"})
    public void boxTest_2(String name, String email, String currentAddress, String permanentAddress) {
        textBox = new TextBoxPage(driver);
        textBox.fillTextBox(name, email, currentAddress, permanentAddress);
        textBox.waitText();
        assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        assertEquals(textBox.getTextFromInfoField("email"), "Email:" + email);
        assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void boxTest_3(String name, String email, String currentAddress, String permanentAddress) {
        textBox = new TextBoxPage(driver);
        textBox.fillTextBox(name, email, currentAddress, permanentAddress);
        textBox.waitText();
        assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        assertEquals(textBox.getTextFromInfoField("email"), "Email:" + email);
        assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }

    public static Stream<Arguments> provideDate() {
        return Stream.of(
                Arguments.of("John4", "john@gmail.com", "John address 1", "John address 2"),
                Arguments.of("Kate4", "kate@gmail.com", "Kate address 1", "Kate address 2"),
                Arguments.of("Peter4", "peter@gmail.com", "Peter address 1", "Peter address 2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideDate")
    public void boxTest_4(String name, String email, String currentAddress, String permanentAddress) {
        textBox = new TextBoxPage(driver);
        textBox.fillTextBox(name, email, currentAddress, permanentAddress);
        textBox.waitText();
        assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        assertEquals(textBox.getTextFromInfoField("email"), "Email:" + email);
        assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }

    public static Collection<Object[]> provideData2() {
        return Arrays.asList(new Object[][] {
                {"John5", "john@gmail.com", "John address 1", "John address 2"},
                {"Kate5", "kate@gmail.com", "Kate address 1", "Kate address 2"},
                {"Peter5", "peter@gmail.com", "Peter address 1", "Peter address 2"}
                });
    }

    @ParameterizedTest
    @MethodSource("provideData2")
    public void boxTest_5(String name, String email, String currentAddress, String permanentAddress) {
        textBox = new TextBoxPage(driver);
        textBox.fillTextBox(name, email, currentAddress, permanentAddress);
        textBox.waitText();
        assertEquals(textBox.getTextFromInfoField("name"), "Name:" + name);
        assertEquals(textBox.getTextFromInfoField("email"), "Email:" + email);
        assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }

    @ParameterizedTest
    @EnumSource(DataTextBox.class)
    public void boxTest_5(DataTextBox dataTextBox) {
        textBox = new TextBoxPage(driver);
        textBox.fillTextBox(dataTextBox.getNAME(), dataTextBox.getEMAIL(), dataTextBox.getCURRENT_ADDRESS(), dataTextBox.getPERMANENT_ADDRESS());
        textBox.waitText();
        assertEquals(textBox.getTextFromInfoField("name"), "Name:" + dataTextBox.getNAME());
        assertEquals(textBox.getTextFromInfoField("email"), "Email:" + dataTextBox.getEMAIL());
        assertEquals(textBox.getTextFromInfoField("currentAddress"),
                "Current Address :" + dataTextBox.getCURRENT_ADDRESS());
        assertEquals(textBox.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + dataTextBox.getPERMANENT_ADDRESS());
    }


}
