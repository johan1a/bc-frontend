(ns bc.frontend.routes.home
  (:require [bc.frontend.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [bc.frontend.http-util :as util]
            [bc.frontend.config :refer [env]]
            ))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn charts-home []
  (layout/render
    "charts/charts_home.html" {:backend-host (env :bc-backend-service-host)
                               :backend-port (env :bc-backend-service-port)}))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/charts" [] (charts-home))
  (GET "/about" [] (about-page))
  (GET ["/backend/:path" :path #".*"] [path]
    (let [host (env :bc-backend-service-host)
          port (env :bc-backend-service-port)
          url (str "http://" host ":" port "/" path)]
        (println (str "url: " url))
          (util/json-get url))))

