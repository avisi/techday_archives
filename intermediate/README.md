# Intermediate

Purpose: demo the interop between two languages, in this case the interop between Java and R. R is frequently used in data science applications. 
It has support for creating graphs. In this part of the hand-on we will draw a temperature graph using the R language.

Expand your path to include GraalVM utilities:

``export PATH=$GRAALVM_HOME/bin:$PATH``

Add support for the R language to GraalVM with this command:

``gu install R``

Point JAVA_HOME to GraalVM:

``export JAVA_HOME=<GRAALVM_HOME>``

Build and run the project using

``mvn spring-boot:run``

For convenience the R code for rendering a plot is provided in the resources folder and is called plot.R. The code is not complete: the main challenge is to use the comments in the code to import the R code and expose it as a BiFunction.

After starting the application use
``http://localhost:8080``
to render a graph.

Note that we can pass Java types back and forth from Java to R.





