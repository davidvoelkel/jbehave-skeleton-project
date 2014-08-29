package calculator;
import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.net.URL;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(value = JUnitReportingRunner.class)
public class JBehaveStories extends JUnitStories {
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), asList(new CalculatorStepDefinitions()));
	}

	@Override
	protected List<String> storyPaths() {
		// run all *.story files found in resources
		return new StoryFinder().findPaths(thisClass(), "*.story", null);
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
				.useFailureStrategy(new FailingUponPendingStep())
				.useStoryControls(new StoryControls().doResetStateBeforeScenario(false))
				.useStoryReporterBuilder(reportBuilder());
	}
	
    protected StoryReporterBuilder reportBuilder() {
		return new StoryReporterBuilder()
				.withFormats(Format.CONSOLE, Format.XML, Format.HTML)
				.withCodeLocation(thisClass())
				// activate stacktrace for easier finding errors 
				.withFailureTrace(true)
				.withFailureTraceCompression(false);
	}

	private URL thisClass() {
		return codeLocationFromClass(getClass());
	}
}
