JBehave Project Skeleton
========================
A minimal ([Apache Maven](http://maven.apache.org/) based) setup for a [JBehave](http://jbehave.org/) acceptance test project. Required steps to get it running in [Eclipse](http://www.eclipse.org/):
* Maven needs to be installed on your system
* Checkout this project
* To be executed on your [Continuous Integration](http://martinfowler.com/articles/continuousIntegration.html) Server you can start a test run in Maven with `mvn -DskipTests=true test`. That will execute all stories and generate an HTML-Report in `target/jbehave/view/reports.html`.
* `mvn eclipse:eclipse` + Refresh of the Eclipse project to get the required libs into place
* The class JBehaveStories can be run as JUnit test during development and the results in the Eclipse Testrunner GUI will be rendered apropriately thanks to the [jbehave-junit-runner](https://github.com/codecentric/jbehave-junit-runner)
* Install the [Eclipse JBehave Plugin](http://jbehave.org/eclipse-integration.html) to get syntax highlighting and support you with linking the stories to the step definitions 
