(ns clojure-irc-client.core
  (:gen-class)
  (:require [clojure-irc-client.commands :as command]
            [clojure.string :as string]
            [clojure.tools.cli :as cli]
            [clojure.core.async :as async]
            [com.gearswithingears.async-sockets :refer :all]))

(defn message-handler [socket]
  (async/go-loop []
    (when-let [line (async/<! (:in socket))]
      (println line)
      (recur))))

(defn connect [host port]
  (println "Connecting...")
  (try
    (let [socket (socket-client port host)]
      (println (str "Connected to " host ":" port))
      (message-handler socket))
    (catch Exception e
      (println (str "Failed to connect to " host ":" port)))))

(def cli-usage
  [["-n" "--nick NICK" "Nickname"]
   ["-h" "--host HOST" "Hostname"]
   ["-p" "--port PORT" "Port number" :parse-fn #(Integer/parseInt %) :default 6667]])

(defn -main [& args]
  (let [{:keys [options summary]} (cli/parse-opts args cli-usage)]
    (if (empty? options)
      (println summary)
      (connect
        (-> options :host string/trim)
        (:port options)))))
