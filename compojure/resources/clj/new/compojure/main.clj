(ns {{root-ns}}
  (:require [mount.lite :refer (defstate) :as mount] 
            [{{root-ns}}.config :as config]
            [{{root-ns}}.handlers :as handlers]
            [ring.adapter.jetty :refer [run-jetty]])
  (:import [org.eclipse.jetty.server.handler StatisticsHandler])
  (:gen-class))

(def a-minute 60000)

(defn jetty-conf
  [server]
  (let [stats-handler (StatisticsHandler.)
        default-handler (.getHandler server)]
    (.setHandler stats-handler default-handler)
    (.setHandler server stats-handler)
    (.setStopTimeout  server a-minute)
    (.setStopAtShutdown server true)))

(defn run [port join]
  (run-jetty #'handlers/app {:port port :configurator jetty-conf :join? join}))

(defstate http
  :start (run (get-in @config/config [:http :port]) false)
  :stop (.stop @http))

(defn -main [& args]
  (run (Integer/valueOf 3000) true))

