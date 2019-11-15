(ns {{root-ns}}.handlers
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [{{root-ns}}.views :as views]))

(defroutes app-routes
  (GET "/" [] (views/index "It works"))
  (route/not-found "Not found"))

(def app
  (wrap-defaults app-routes site-defaults))
