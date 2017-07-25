(ns bc-frontend.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [bc-frontend.layout :refer [error-page]]
            [bc-frontend.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [bc-frontend.env :refer [defaults]]
            [mount.core :as mount]
            [bc-frontend.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
