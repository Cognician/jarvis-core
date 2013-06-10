(use '[clojure.java.shell :only [sh]])

(defproject com.rallydev/jarvis-core "1.0.0"
  :description "A robot for FlowDock"
  :url "http://github.com/RallySoftware/jarvis-core"
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [com.rallydev/clj-flowdock "1.1.0"]
                 [org.codehaus.groovy/groovy-all "2.1.0"]
                 [org.clojure/java.classpath "0.2.0"]
                 [org.clojure/tools.logging "0.2.6"]
                 [clj-http "0.7.2"]
                 [fs "1.3.2"]
                 [ch.qos.logback/logback-classic "1.0.9"]]
  :source-paths ["src/main/clojure" "src/plugins"]
  :java-source-paths ["src/main/java"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources"]
  :plugins [[lein-clojars "0.9.1"]]
  :jvm-opts ["-Xmx1G" "-DLOG_DIR=./logs"])