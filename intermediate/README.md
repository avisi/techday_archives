Level: intermediate

Summary: demo the interop between two languages

We will draw a temperature graph using the R language.

First add support for the R language to GraalVM:

gu install R

the demo uses the ggplot2 package. Install it by first starting R.

>install.packages("ggplot2")


Point JAVA_HOME to GraalVM:
export JAVA_HOME=<GRAALVM_HOME>

Build the project using
mvn clean install

Run the application using
mvn spring-boot:run

For convenience the R code for rendering a plot is provided in the resources folder and is called plot.R

After starting the application use http://localhost:8080/forecast to render a graph





