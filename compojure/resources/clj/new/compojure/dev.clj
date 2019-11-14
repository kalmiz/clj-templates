(ns dev
  (:require [mount.lite :refer (defstate) :as mount] 
            [{{root-ns}} :as {{name}}]
            [clojure.tools.namespace.repl :as tns]))

(defn dev-test [] (println "dev"))

(defn reload []
  (do 
    (mount/stop)
    (tns/refresh)
    (mount/start)))
