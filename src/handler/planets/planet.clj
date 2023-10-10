(ns handler.planets.planet
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route] 
            [cheshire.core :as json]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]))

(defn earth-route
  []
  (GET "/earth" []
    {:status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body (json/generate-string {
                                  :name "Earth"
                                  :sacanagem "oi"
     })}))