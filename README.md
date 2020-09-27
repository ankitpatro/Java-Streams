# Java-Streams
Java Stream usage and implementations



A stream represents a sequence of elements and supports different kind of operations to perform computations upon those elements.
tream operations are either intermediate or terminal. Intermediate operations return a stream so we can chain multiple intermediate operations without using semicolons. Terminal operations are either void or return a non-stream result. In the above example filter, map and sorted are intermediate operations whereas forEach is a terminal operation. For a full list of all available stream operations see the [Stream Javadoc](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)

This project is licensed under the terms of the [MIT license](LICENSE).

