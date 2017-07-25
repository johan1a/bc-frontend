(ns bc-frontend.backend-util
  (:require [bc-frontend.http-util :as util]
            [bc-frontend.config :refer [env]]
            ))

(defn relay
  [path]
  (let [host (env :bc-backend-service-host)
        port (env :bc-backend-service-port)
        url (str "http://" host ":" port "/" path)]
    (println (str "Backend url called: " url))
    (util/json-get url)))
