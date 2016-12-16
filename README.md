# clojure-irc-client

A very basic command line IRC client written with Clojure to help me learn the language.

## Usage

Build and run the uberjar with Leiningen:
~~~
lein run -n <nickname> -h <hostname> [-p <port>]
~~~

Or, manually build the uberjar and run it directly:
~~~
lein uberjar
java -jar target/uberjar/clojure-irc-client.jar -n <nickname> -h <hostname> [-p <port>]
~~~
