(ns bc.frontend.routes.home
  (:require [bc.frontend.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [bc.frontend.http-util :as util]
            [bc.frontend.backend-util :as backend]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn charts-home []
  (layout/render
    "charts/charts_home.html"))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/charts" [] (charts-home))
  (GET "/about" [] (about-page))
  (GET ["/backend/:path" :path #".*"] [path] 
       (backend/relay path)))

