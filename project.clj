(defproject com.rallydev/jarvis-core "1.6.5"
  :description "A robot for FlowDock"
  :url "http://github.com/RallySoftware/jarvis-core"
  :license {:name "The MIT License (MIT)"
            :url  "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [com.rallydev/clj-flowdock "1.2.4"]
                 [org.clojure/java.classpath "0.2.3"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.reader "0.10.0"]
                 [clj-http "2.0.1"]
                 [fs "1.3.3"]
                 [cheshire "5.5.0"]
                 [ch.qos.logback/logback-classic "1.1.3"]]
  :source-paths ["src/main/clojure" "src/plugins"]
  :java-source-paths ["src/main/java"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources"]
  :target-path "target"
  :main jarvis.bot
  :plugins [[lein-clojars "0.9.1"]]
  :jvm-opts ["-Xmx1G" "-DLOG_DIR=./logs"])
