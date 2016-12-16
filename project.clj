(defproject clojure-irc-client "0.1.0-SNAPSHOT"
  :description "Very basic command line IRC client"
  :url "https://github.com/AdamBoxall/clojure-irc-client"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.5"]
                 [org.clojure/core.async "0.2.395"]
                 [com.gearswithingears/async-sockets "0.1.0"]]
  :main ^:skip-aot clojure-irc-client.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :uberjar-name "clojure-irc-client.jar")
