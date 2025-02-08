package pages.component;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    public static void checkResult(String key, String value) {
        $(".table").$(byText(key)).parent().shouldHave(text(value));
    }

        public static void checkExist() {
            $(".table").shouldNot(exist);
        }
    }

