(ns cljblog.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cljblog.db :as db]
            [cljblog.pages :as p]))

(defroutes app-routes
  (GET "/" [] (p/index (db/list-articles)))
  (GET "/articles/:article-id" [article-id] (p/article (db/get-article-by-id article-id)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
