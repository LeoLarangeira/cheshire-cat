(ns handler.planets.planet
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route] 
            [cheshire.core :as json]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]
            [chesire-cat.read :as read-doc]))

(def filename "resources/public/data/planets.csv")


(defn mercury-route
      []
  (GET "/mercury" []
    { 
     :status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body (json/generate-string
            (let [result (first (filter #(= 1 (:id %)) (read-doc/read-csv filename)))
                  name (:name result)
                  geographic_features (:feature result)
                  facts (:facts result)]
              {:name name 
               :geographic-features geographic_features
               :facts facts}) 
            )
    }))


(defn venus-route
  []
  (GET "/earth" []
    {:status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body (json/generate-string (let [result (first (filter #(= 3 (:id %)) (read-doc/read-csv filename)))
                                       name (:name result)
                                       geographic_features (:feature result)
                                       facts (:facts result)]
                                   {:name name
                                    :geographic-features geographic_features
                                    :facts facts}))}))












(defn earth-route
  []
  (GET "/earth" []
    {:status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body (json/generate-string (let [result (first (filter #(= 3 (:id %)) (read-doc/read-csv filename)))
                                       name (:name result)
                                       geographic_features (:feature result)
                                       facts (:facts result)]
                                   {:name name
                                    :geographic-features geographic_features
                                    :facts facts}))}))

(defn mars-route
  []
  (GET "/earth" []
    {:status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body (json/generate-string (let [result (first (filter #(= 4 (:id %)) (read-doc/read-csv filename)))
                                       name (:name result)
                                       geographic_features (:feature result)
                                       facts (:facts result)]
                                   {:name name
                                    :geographic-features geographic_features
                                    :facts facts}))}))