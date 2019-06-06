# Creating a native image of a Micronaut application

Steps to follow:

Set the path to the GraalVM binaries:

```
export GRAALVM_HOME=~/graalvm
export PATH=$GRAALVM_HOME/bin:$PATH
```
Install the native-image utility using:

```
gu install native-image
```

## Install Micronaut

### Brew
```
brew update
brew install micronaut
brew upgrade micronaut
```

### Caveat

Please note that during code generation Micronaut will inspect your installed VMs and might set the version of your Java code to e.g. 11 in the pom.xml.

## Generate application 

Create a skeleton Micronaut Maven application pre-configured for GraalVM native images:

```
mn create-app techday --features=graal-native-image --build maven
```

Take a minute to check the native-image.properties file:

```
Args = -H:IncludeResources=logback.xml|application.yml|bootstrap.yml \
       -H:Name=techday \
       -H:Class=nl.avisi.labs.techday.Application
```
Create a simple HelloWorld controller:
```
package techday;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;

import javax.validation.constraints.NotBlank;

@Controller("/")
@Validated
public class HelloWorldController {

    @Get(uri = "", produces = MediaType.TEXT_PLAIN)
    public Single<String> hello(@NotBlank String user) {
        return Single.just("Hello " + user + "!");
    }
}
```

These settings are used to enable GraalVM to make a native image. 

* The IncludeResources option defines which resources need to be packaged, e.g. the logback configuration.
* The Name option defines the name of the executable
* The Class option defines the name of the main class to execute 

### Build the application using 

```
mvn clean install
```

To create the native image:

```
native-image --no-server -cp target/techday-0.1.jar
```

This will result in an executable called techday

Check the difference in startup times between 

```
./techday
```
vs.
```
java -jar target/techday-0.1.jar
```

Use e.g. ```top``` to check the memory used by either the native image or the fat jar:
```
top -pid $(lsof -ti tcp:8080)
```
