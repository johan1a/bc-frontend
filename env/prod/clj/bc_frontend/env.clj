(ns bc-frontend.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[bc-frontend started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[bc-frontend has shut down successfully]=-"))
   :middleware identity})
