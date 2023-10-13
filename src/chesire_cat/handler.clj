(ns chesire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cheshire.core :as json]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]
            [handler.planets.planet :as planet-handler]))



(defroutes app-routes 
  (GET "/" [] (slurp "resources/public/index.html")) 
  (GET "/earth" [] (planet-handler/earth-route))
  (GET "/mercury" [] (planet-handler/mercury-route))
  (route/not-found "Not Found")
 )



(def app 
  (-> app-routes
      (ring-json/wrap-json-response)
      (wrap-defaults site-defaults)))

(defn create-route []
  (routes
   (GET "/earth" request (planet-handler/earth-route))))