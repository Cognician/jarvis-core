(ns jarvis.plugins.flows
  (:require [jarvis.plugins :as plugins]
            [clj-flowdock.api.message :as message]
            [clj-flowdock.api.flow :as flow]
            [clojure.string :as s]))

(defn ^{:description "
Prints all flows the bot is currently on."
        :command "list-flows"
        :section "FlowDock"
        :author "Jonathan Chauncey"
        :plugin true}
  list-flows [message content-vec]
  (let [flows (flow/list)]
    (s/join ", " (map #(% "name") flows))))
