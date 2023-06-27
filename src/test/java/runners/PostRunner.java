package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {"@POST"},
        features = "src/test/resources/features/Post.feature",
        glue = "stepDefinitions",
        snippets = SnippetType.CAMELCASE
)
public class PostRunner {
}
