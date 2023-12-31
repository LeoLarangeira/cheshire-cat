(defproject chesire-cat "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.csv "1.0.1"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [cheshire "5.12.0"]
                 [ring/ring-json "0.5.1"]
                 [org.clojure/clojurescript "1.11.121"]]
  :main ^:skip-aot cheshire.core
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler chesire-cat.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
  
