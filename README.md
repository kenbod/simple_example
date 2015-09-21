# Example

Here is an example of how I would like the FeatureExtractor packaged
so I can make use of it in a Spark job.

In the util directory is a simple Scala project that creates a .jar file
that contains a single .class file that can be used by other programs.

You would use it in the following way:

    cd util
    ./gradlew assemble
    cp build/libs/util.jar ../test/libs

These commands create the jar file. We then copy it into the `libs`
directory of the `test` directory; the build.gradle file in the
`test` directory is set up to look for <q>3rd party</q> jar files
in its libs directory. You can then create the final program with
the commands:

    cd test
    ./gradlew shadowJar
    ./run.sh build.gradle

The program in the `test` directory is set-up to receive a file name
as its one and only argument. It reads that file into a string and then
passes it to the `reverse()` method of the `ReverseMe` utility class (which
comes from the `util.jar` file).

For the feature extractor, I want to be able to include a .jar file in
the <q>uberjar</q> produced by the shadowJar plugin that contains the
classes of the feature extractor (and all of its dependencies). I should
then be able to write code in a Spark job that will instantiate the
feature extractor and apply it to all of the java source code files
in our repository saving the results as one big sequence file for later
processing.
