(ns chesire-cat.core
  (:gen-class)
 (:require [compojure.core :refer :all]
           [compojure.route :as route]
           [cheshire.core :as json]
           [ring.middleware.json :as ring-json]
           [ring.util.response :as rr]
           [chesire-cat.handler :as handler-master]))

(defn -main
  []
  (handler-master/create-route))