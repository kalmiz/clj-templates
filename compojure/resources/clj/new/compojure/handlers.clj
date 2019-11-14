(ns {{root-ns}}.handlers
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (str "Hello World"))
  (route/not-found "Not found"))

(def app
  (wrap-defaults app-routes site-defaults))
