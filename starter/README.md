#H1 Creating a native image of a Micronaut application

install the native-image utility using:

gu install native-image

Install Micronaut using:

brew update

brew install micronaut

brew upgrade micronaut

Next, create a skeleton Maven application pre-configured for GraalVM native images:

Set the path to the GraalVM binaries:

mn create-app techday --features=graal-native-image --build maven

Take a minute to check the native-image.properties file:

Args = -H:IncludeResources=logback.xml|application.yml|bootstrap.yml \
       -H:Name=techday \
       -H:Class=nl.avisi.labs.techday.Application


These settings are used to enable GraalVM to make a native image. The IncludeResources switch defines which resources need to be packaged.

Build the application using 

mvn clean install

To create the native image:

export GRAALVM_HOME=<path to GraalVM Home>
export PATH=$GRAALVM_HOME/bin:$PATH

native-image --no-server -cp target/techday-0.1.jar

This will result in an executable called techday

Check the difference in startup times between 

./techday

vs. 

java -jar target/techday-0.1.jar

For easy comparison it is best to add a System.exit(1); statement to the Application class

for memory usage the command

time 







