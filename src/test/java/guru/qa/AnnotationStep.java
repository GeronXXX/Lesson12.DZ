package guru.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationStep {
    private static final String Repository = "GeronXXX/Lesson10.Files";
    private static final String Text = "Welcome to issues!";

    @DisplayName("3. Шаги с аннотацией @Step")
    @Test
    public void testAnnotatedStep() {
        PageObgects step = new PageObgects();
        step.openMainPage();
        step.searchForRepository(Repository);
        step.repository(Repository);
        step.issuesTab();
        step.verificationText(Text);
        step.takeScreenshot();
    }
}
