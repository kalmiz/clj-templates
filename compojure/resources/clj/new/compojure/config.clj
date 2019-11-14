(ns {{root-ns}}.config
  (:require [mount.lite :refer (defstate) :as mount]
            [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def config-file (io/resource "config.edn"))

(defstate config
  :start (edn/read-string (slurp config-file)))
