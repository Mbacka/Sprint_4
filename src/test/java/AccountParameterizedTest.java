import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.assertEquals;


@RunWith(Parameterized.class)
public class AccountParameterizedTest {

    private final String actualName;
    private boolean expectedResult;

    public AccountParameterizedTest(String actualName, boolean expectedResult) {
        this.actualName = actualName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[] getNameData() {
        return new Object[][]{
                {"SIRIUS BLACK", true},
                {" DORIAN GREY", true},
                {"Александр Романов ", true},
                {" Жераф Сомелье ", true},
                {"ТимотейШевролеееееее", false},
                {"Ми", false},
                {" ", false},
                {"Отто", false},
        };
    }

    @Test
    @DisplayName("Параметризованная проверка печати имени на банковской карте")
    public void testAccountName() {
        Account account = new Account(actualName);

        assertEquals(expectedResult, account.checkNameToEmboss());

    }


}
