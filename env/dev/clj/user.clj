(ns user
  (:require [mount.core :as mount]
            bc.frontend.core))

(defn start []
  (mount/start-without #'bc.frontend.core/repl-server))

(defn stop []
  (mount/stop-except #'bc.frontend.core/repl-server))

(defn restart []
  (stop)
  (start))


