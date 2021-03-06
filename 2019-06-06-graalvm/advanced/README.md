In this part of the handson we will add a new custom language to the GraalVM environment.

To start with, clone the SimpleLanguage demo language from the [GraalVM GitHub](https://github.com/graalvm/simplelanguage.git)

The SimpleLanguage is a language which defines functions and statements.

The syntax for the SimpleLanguage can be found in the folder
```
simplelanguage/language/src/main/java/com/oracle/truffle/sl/parser/SimpleLanguage.g4

```

Build instructions:

Point JAVA_HOME to GraalVM (this is needed in order to include the Truffle API


```
export JAVA_HOME=
cd simplelanguage
mvn clean install
```

Maven will compile and create a native image called ``sl``

Try out the SimpleLanguage by using e.g.

```
./sl ../greet.sl
``` 

The output may come as no surprise.

Add the SimpleLanguage to the interpreters supported by GraalVM by using

```
gu install -L component/sl-component.jar
```
Check the list of available components to see that indeed the SimpleLanguage has been added:

```
gu available
```

The interop folder contains an application where we integrate the SimpleLanguage into Java.
The resource file square.sl defines a function returning the square of an Integer.

```
cd ../interop
mvn spring-boot:run
```

After the Spring Boot Application has started use the URL ```[http://localhost:8080/42](http://localhost:8080/42)``` to retrieve the square value.
