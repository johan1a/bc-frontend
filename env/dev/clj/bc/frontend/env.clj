(ns bc.frontend.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [bc.frontend.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[bc.frontend started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[bc.frontend has shut down successfully]=-"))
   :middleware wrap-dev})
