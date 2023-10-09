(ns chesire-cat.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cheshire.core :as json]
            [ring.middleware.json :as ring-json]
            [ring.util.response :as rr]))


(GET "/cheshire-cat" [] "Smile!")

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/cheshire-cat" [] 
    (rr/response {:name "Cheshire Cat" :status :grinning}))
  (route/not-found "Not Found"))



;(def app
;  (wrap-defaults app-routes site-defaults))

(def app 
  (-> app-routes
      (ring-json/wrap-json-response)
      (wrap-defaults site-defaults)))