
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.Account;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expectedResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                // 3 символа
                {"T T", true},
                // 19 символов
                {"Дмитрий Петровсккий", true},
                // 10 символов
                {"Anna Novar", true},
                // > 3 символов
                {"T", false},
                // 20 символов
                {"PopovPirogov PopovPi", false},
                // 25 символов
                {"PopovPirogov PopovPirogov", false},
                // пробел в конце
                {"Lionov ", false},
                // пробел в начале
                {" Popov", false},
                // без пробела
                {"PopovPirogov", false},
                // более 1го пробела
                {"Popov  Pirogov", false},

        };
    }

    @Test
    public void checkAccountParamTest(){
        Account account = new Account(name);
        Assert.assertEquals(account.checkNameToEmboss(), expectedResult);
    }
}





