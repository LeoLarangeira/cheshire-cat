(ns chesire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cheshire.core :as json]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]))



(defroutes app-routes
    (GET "/" [] (slurp "resources/public/index.html"))
  (route/resources "/")
  (route/not-found "Not Found"))



;(def app
;  (wrap-defaults app-routes site-defaults))

(def app 
  (-> app-routes
      (ring-json/wrap-json-response)
      (wrap-defaults site-defaults)))