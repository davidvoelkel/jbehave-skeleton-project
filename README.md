JBehave Project Skeleton
========================
A minimal ([Apache Maven](http://maven.apache.org/) based) setup for a [JBehave](http://jbehave.org/) acceptance test project. **Get it running** in [Eclipse](http://www.eclipse.org/):
* Maven needs to be installed on your system
* Checkout this project
* To be executed on your [Continuous Integration](http://martinfowler.com/articles/continuousIntegration.html) Server you can start a test run in Maven with `mvn -DskipTests=true test` in the projects base directory. That will execute all stories and generate an HTML-Report in `target/jbehave/view/reports.html`.
* `mvn eclipse:eclipse` + Refresh of the Eclipse project to get the required libs into place
* The class JBehaveStories can be run as JUnit test during development and the results in the Eclipse Testrunner GUI will be rendered apropriately thanks to the [jbehave-junit-runner](https://github.com/codecentric/jbehave-junit-runner)
* Install the [Eclipse JBehave Plugin](http://jbehave.org/eclipse-integration.html) to get syntax highlighting and support you with linking the stories to the step definitions 

The project consists of the following **artifacts**:
- `Calculator.story`: the actual story containing scenarios consisting of single steps which are implemented in ...
- `CalculatorStepDefinitions.java`: implements the gluecode accessing the object under test...
- `Calculator.java`: the production code under test
- `JBehaveStories.java` & `pom.xml`: the JBehave configuration

**Further reading**:
- Introduction into JBehave:
  - [JBehave Configuration Tutorial](https://blog.codecentric.de/en/2012/06/jbehave-configuration-tutorial/)
  - [Automated Acceptance Testing using JBehave](https://blog.codecentric.de/en/2011/03/automated-acceptance-testing-using-jbehave/)
  - [JBehave JUnit Runner](https://blog.codecentric.de/en/2014/06/jbehave-junit-runner-release-1-1-2-future-development/)
- [JBehave reference](http://jbehave.org/)
