(ns clj.new.compojure
  (:require [clj.new.templates :refer [renderer project-name name-to-path ->files
                                       multi-segment sanitize-ns]]))

(def render (renderer "compojure"))

(defn compojure
  "FIXME: write documentation"
  [name]
  (let [data {:name (project-name name)
              :sanitized (name-to-path name)
              :root-ns (multi-segment (sanitize-ns name))}]
    (println "Generating fresh 'clj new' compojure project.")
    (->files data
             ["README.md" (render "README.md" data)]
             ["deps.edn" (render "deps.edn" data)]
             ["resources/config.edn" (render "config.edn" data)]
             ["dev/dev.clj" (render "dev.clj" data)]
             ["src/{{sanitized}}.clj" (render "main.clj" data)]
             ["src/{{sanitized}}/config.clj" (render "config.clj" data)]
             ["src/{{sanitized}}/handlers.clj" (render "handlers.clj" data)]
             ["src/{{sanitized}}/views.clj" (render "views.clj" data)])))
