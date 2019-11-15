(ns {{root-ns}}.views
  (:use [hiccup core page]))

(defn index [title]
  (html5
    [:head
     [:title title]]
    [:body
     [:h1 title]]))
