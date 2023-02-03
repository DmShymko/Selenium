package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT)
public class AutomationTest {
    private WebDriver driver;

    Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();

    }

    @AfterEach
    public void afterEach() {
        driver.quit();

    }
    @Tag("T1")
    @Tag("Regression")
    @DisplayName("Test http://pudelek.pl")
    @Order(2)
    @Test
    public void seleniumTest1() {


        driver.get("http://pudelek.pl");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        System.out.println("ActualTitle: " + actualTitle);
        String expectedTitle = "Pudelek.pl - Plotki, Gwiazdy, Sensacja - Pudelek";
        assertThat("Title is not correct: ", actualTitle, equalTo(expectedTitle));

    }
    @Tag("T2")
    @Tag("Regression")
    @DisplayName("Test http://maven.com")
    @Order(1)
    @ParameterizedTest
    @ValueSource (strings = {"Maven: Expert-led. Peer-driven. Hello, live learning."})
    public void seleniumTest2(String expectedTitle) {


        driver.get("http://maven.com");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        System.out.println("ActualTitle: " + actualTitle);
        assertThat("Title is not correct: ", actualTitle, equalTo(expectedTitle));

    }
    @Tag("T3")
    @Order(3)
    @Test
    public void seleniumTest3() {


        driver.get("http://pudelek.pl");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        System.out.println("ActualTitle: " + actualTitle);
        String expectedTitle = "Pudelek.pl - Plotki, Gwiazdy, Sensacja - Pudelek";
        assertThat("Title is not correct: ", actualTitle, equalTo(expectedTitle));

    }

    @Tag("T4")
    @Tag("Regression")
    @DisplayName("Test calculator")
    @Order(4)
    @ParameterizedTest
    @CsvSource({
            "5, 10, 15",
            "15, 20, 35",
            "20, 25, 45"
    })
    void addition(int a, int b, int expectedResult) {
        calculator = new Calculator();


        int actualResult = calculator.addition(a, b);

        assertThat("Result is not correct: ", actualResult, equalTo(expectedResult)); //UWAGA! zamienien miestami actual result i expected result
        System.out.println("END TEST");
    }
}

