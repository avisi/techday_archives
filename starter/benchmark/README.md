Benchmark

The module contains a standard benchmark which you can run out of the box.

First build the module using

mvn clean package

Then, run the benchmark using your default VM:

java -jar target/benchmarks.jar reduce


Notice that during the warmup iterations the time per operation slowly decreases.

Instead of the default VM you can also chose to have GraalVM as your VM:

export GRAALVM_HOME=<location of your GraalVM Home>
export PATH=$GRAALVM_HOME/bin:$PATH

Next run the benchmark again but now using the GraalVM in classic mode:

java -XX:-UseJVMCICompiler -jar target/benchmarks.jar reduce

Conclusion: not much difference

Next run the benchmark but now with GraalVM running in optimization mode:

java -jar target/benchmarks.jar reduce

The GraalVM is capable of reaching a higher performance due to optimization of the stream operations.

Finally, Java11 has support for GraalVM as well:

java -jar target/benchmarks.jar reduce

export JAVA_HOME=<path to your Java 11>
export PATH=$JAVA_HOME/bin:$PATH

java -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -jar target/benchmarks.jar reduce

Question: from your daily work as a software engineer, can you find an example which could benefit from GraalVM optimization?



