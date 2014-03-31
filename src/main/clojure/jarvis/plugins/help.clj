(ns jarvis.plugins.help
  (:require [jarvis.plugins :as plugins]
            [clojure.string :as s]))

(defn ^{:description "
Prints the description of all plugins."
        :command "help"
        :section "FlowDock"
        :author "Adam Esterline"
        :plugin true}
  help
  ([message content-vec] (help message content-vec @plugins/plugins-atom))
  ([message content-vec plugins]
    (let [plugin-meta (map meta plugins)
          sorted-plugin-meta (sort-by (juxt :section :command) plugin-meta)
          help-text (map #(str "\t~" (:command %) " " (:description %)) sorted-plugin-meta)]
      (str
        (s/join "\n" help-text)
        "\n\t~leave
Have the bot leave the flow. The bot will need to be invited back through the FlowDock API to join again."
        "\n\t~<command> can be used also in private-messages with me."))))
