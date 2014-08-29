//
//
//import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
//import static org.jbehave.core.reporters.Format.CONSOLE;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.jbehave.core.configuration.Configuration;
//import org.jbehave.core.configuration.MostUsefulConfiguration;
//import org.jbehave.core.embedder.StoryControls;
//import org.jbehave.core.failures.FailingUponPendingStep;
//import org.jbehave.core.io.LoadFromClasspath;
//import org.jbehave.core.io.StoryFinder;
//import org.jbehave.core.junit.JUnitStories;
//import org.jbehave.core.reporters.Format;
//import org.jbehave.core.reporters.StoryReporterBuilder;
//import org.jbehave.core.steps.InjectableStepsFactory;
//import org.jbehave.core.steps.InstanceStepsFactory;
//import org.jbehave.web.selenium.WebDriverHtmlOutput;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import de.vorsorge.theo.web.steps.AnlageStrategieStepDefinitions;
//import de.vorsorge.theo.web.steps.AufgabenSteps;
//import de.vorsorge.theo.web.steps.AufrufHistorieStepDefinitions;
//import de.vorsorge.theo.web.steps.CommonStepDefinitions;
//import de.vorsorge.theo.web.steps.DokumentenAnzeigeStepDefinitions;
//import de.vorsorge.theo.web.steps.EreignisseSteps;
//import de.vorsorge.theo.web.steps.GeVoStepDefinitions;
//import de.vorsorge.theo.web.steps.LoginStepDefinitions;
//import de.vorsorge.theo.web.steps.MailsSteps;
//import de.vorsorge.theo.web.steps.MiniSapStepDefinitions;
//import de.vorsorge.theo.web.steps.NewsSteps;
//import de.vorsorge.theo.web.steps.NotizenSteps;
//import de.vorsorge.theo.web.steps.PartnerDetailsansichtStepDefinition;
//import de.vorsorge.theo.web.steps.PartnerKurzuebersichtStepDefinitions;
//import de.vorsorge.theo.web.steps.SchaltflaechenStepDefinitions;
//import de.vorsorge.theo.web.steps.StepDefintion;
//import de.vorsorge.theo.web.steps.SucheStepDefinitions;
//import de.vorsorge.theo.web.steps.TelefonnotizStepDefinitions;
//import de.vorsorge.theo.web.steps.VertraegeZumPartnerStepDefinitions;
//import de.vorsorge.theo.web.steps.VertragsDetailsansichtStepDefinition;
//import de.vorsorge.theo.web.steps.VertragsZeitleisteStepDefinitions;
//import de.vorsorge.theo.web.steps.VorgangsHistorienStepDefinitions;
//import de.vorsorge.theo.web.steps.ZulagenStepDefinitions;
//
///**
// * Die Klasse ist zuständig für die Ausführung der Akzeptanztests. Ihre jeweilige Unterklasse wird dann
// * entweder direkt als JUnit-Test im Eclipse gestartet werden oder aber über
// * Maven (Details siehe
// * http://vlls071.vorsorge.lu:8090/display/FW/Akzeptanztests).
// * 
// * Sie verwendet zur Hilfe {@link AcceptanceTestConfiguration}, um an die
// * benötigten Konfigurationswerte zu kommen, und die {@link DriverFactory},
// * um passend zum gewählten Browser eine {@link WebDriver}-Implementierung
// * geliefert zu bekommen.
// */
//public abstract class AllWebAcceptanceTestStoriesOrig extends JUnitStories {
//
//	protected static Logger log = LoggerFactory.getLogger(AllWebAcceptanceTestStoriesOrig.class);
//
//	private AcceptanceTestSystemPropertiesConfiguration config = new AcceptanceTestSystemPropertiesConfiguration();
//
//	protected Session session;
//
//	public AllWebAcceptanceTestStoriesOrig() {
//		
//		logConfig();
//	
//		session = new Session(config.getBaseUrl(), shouldGenerateReports());
//
//		configuredEmbedder().embedderControls()
//			.useThreads(1)
//			.doIgnoreFailureInStories(true)
//			.doIgnoreFailureInView(false)
//			.doGenerateViewAfterStories(shouldGenerateReports());
//	}
//
//	@Override
//	public Configuration configuration() {
//		Configuration configuration = new MostUsefulConfiguration()
//				.useFailureStrategy(new FailingUponPendingStep())
//				.useStoryControls(new StoryControls().doResetStateBeforeScenario(false))
//				.useStoryLoader(new LoadFromClasspath(AllWebAcceptanceTestStoriesOrig.class));
//		if (shouldGenerateReports()) {
//			configuration.useStoryReporterBuilder(reportBuilder());
//		}
//		return configuration;
//	}
//	
//    protected StoryReporterBuilder reportBuilder() {
//		return new StoryReporterBuilder()
//				.withCodeLocation(thisClass())
//				// aktiviere Stacktrace, um Fehler besser lokalisieren zu können
//				.withFailureTrace(true)
//				.withFailureTraceCompression(false)
//				.withFormats(CONSOLE, Format.XML, Format.STATS, WebDriverHtmlOutput.WEB_DRIVER_HTML);
//	}
//
//	@Override
//	public List<String> storyPaths() {
//		return new StoryFinder().findPaths(thisClass(), "**/" + config.getStoryName(), "**/excluded*.story");
//	}
//
//	@Override
//	public InjectableStepsFactory stepsFactory() {
//		return new InstanceStepsFactory(configuration(), stepDefinitions());
//	}
//
//	private List<Object> stepDefinitions() {
//		return stepDefinitions(
//				new ScreenshotOnFailure(session.getDriverProvider(), 
//						configuration().storyReporterBuilder()),
//				new JBehaveLifecycleListener(session, config.getBrowser()),
//				new CommonStepDefinitions(session),
//				new LoginStepDefinitions(session), 
//				new SucheStepDefinitions(session), 
//				new VorgangsHistorienStepDefinitions(session), 
//				new DokumentenAnzeigeStepDefinitions(session),
//				new SchaltflaechenStepDefinitions(session),
//				new VertragsZeitleisteStepDefinitions(session),
//				new PartnerKurzuebersichtStepDefinitions(session),
//				new PartnerDetailsansichtStepDefinition(session),
//				new VertragsDetailsansichtStepDefinition(session),
//				new AnlageStrategieStepDefinitions(session),
//				new AufgabenSteps(session),
//				new NewsSteps(session),
//				new EreignisseSteps(session),
//				new VertraegeZumPartnerStepDefinitions(session),
//				new AufrufHistorieStepDefinitions(session),
//				new TelefonnotizStepDefinitions(session),
//				new MailsSteps(session),
//				new NotizenSteps(session),
//				new GeVoStepDefinitions(session),
//				new MiniSapStepDefinitions(session),
//				new ZulagenStepDefinitions(session)
//		);		
//	}
//
//	private List<Object> stepDefinitions(StepDefintion... stepDefintions) {
//		return new ArrayList<Object>(Arrays.asList(stepDefintions));
//	}
//
//	protected abstract boolean shouldGenerateReports();
//
//	private URL thisClass() {
//		return codeLocationFromClass(AllWebAcceptanceTestStoriesOrig.class);
//	}
//
//	private void logConfig() {
//		config.log();
//		log.info("shouldGenerateReports=" + shouldGenerateReports());
//	}
//
//}
