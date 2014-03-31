(ns jarvis.plugins.join
  (:require [jarvis.bot :as bot]
            [jarvis.plugins :as plugins]
            [clj-flowdock.api.flow :as f]
            [clj-flowdock.api.user :as user]
            [clj-flowdock.api.message :as m]
            [cogbot.log :as log]
            [clojure.string :as s]))

(declare join-flows join-flow)

(defn ^{:description "<flow-display-name>
Join the flow."
        :command "join"
        :section "FlowDock"
        :author "Jonathan Chauncey, Matt Farrar"
        :plugin true}
  join [message content-vec]
  (join-flows message @plugins/plugins-atom))

(defn- join-flows [message plugins]
  (log/info message)
  (let [flows (rest (s/split (m/content message) #"\s"))
        reply (map #(join-flow % plugins) flows)]
    (str "" (s/join "\n" reply))))

(defn- join-flow [flow-name plugins]
  (if-let [flow (f/find "name" flow-name)]
    (do
      (f/add-myself flow)
      (bot/init-flow-thread flow plugins)
      (str "Joined flow '" flow-name "'."))
    (str "Could not join flow '" flow-name "'. Try inviting me through the UI with my email address.")))
