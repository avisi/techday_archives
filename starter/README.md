# Creating a native image of a Micronaut application

Steps to follow:

* Set the path to the GraalVM binaries:

```
EXPORT GRAALVM_HOME=~/graalvm``
EXPORT PATH=$GRAALVM_HOME/bin:$PATH
```
* install the native-image utility using:

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

### Windows:

Download the latest binary from the [Micronaut][http://micronaut.io/download.html]  Website

Extract the binary to appropriate location (For example: C:/micronaut)

Create an environment variable MICRONAUT_HOME which points to the installation directory i.e. C:/micronaut

Update the PATH environment variable, append %MICRONAUT_HOME%\bin.

### Caveat

Please note that during code generation Micronaut will inspect your installed VMs and might set the version of your Java code to e.g. 11 in the pom.xml.

## Generate application 

* Create a skeleton Maven application pre-configured for GraalVM native images:

```
mn create-app techday --features=graal-native-image --build maven
```

Take a minute to check the native-image.properties file:

```
Args = -H:IncludeResources=logback.xml|application.yml|bootstrap.yml \
       -H:Name=techday \
       -H:Class=nl.avisi.labs.techday.Application
```


These settings are used to enable GraalVM to make a native image. 

* The IncludeResources switch defines which resources need to be packaged, e.g. the logback configuration.
* The Name switch defines the name of the executable
* The Class switch defines the name of the main class to execute 

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
vs. 
java -jar target/techday-0.1.jar
```

For easy comparison it is best to add a 

``System.exit(1);``

statement to the Application class.

Use e.g. ```top``` to check the memory used by the native image.
