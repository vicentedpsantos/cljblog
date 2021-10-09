(ns cljblog.db
  (:require [monger.core :as mg]
            [monger.collection :as mc])

(:import
  [org.bson.types ObjectId]))

(def db-connection-uri (or
                         (System/getenv "CLJBLOG_MONG_URI")
                         "mongodb://127.0.0.1/cljblog-test"))

;; docker run -d -p 27017-27019:27017-27019 --name mongodb mongo
(def db (-> db-connection-uri
            mg/connect-via-uri
            :db))

(defn create-article [title body]
  (mc/insert db "articles"
             {:title title
              :body body
              :created (new java.util.Date)}))

(def articles-coll "articles")

(defn list-articles []
 (mc/find-maps db articles-coll))

(defn get-article-by-title [title]
  (mc/find-one db articles-coll
               {:title title}))

(defn get-article-by-id [article-id]
  (mc/find-map-by-id db articles-coll (ObjectId. article-id)))
