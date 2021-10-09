(ns cljblog.pages
  (:require [hiccup.page :refer [html5]]))

(defn base-page [& body]
  (html5
    [:head [:title "Clojure Blog"]]
    [:body
     [:h1 [:a {:href "/"} "CljBlog"]]
     body]))

(defn index [articles]
  (base-page
    (for [a articles]
      [:h2 [:a] (:title a)])))

(defn index [articles]
  (base-page
    (for [a articles]
      [:div
       [:p (:_id a)]
       [:h2 [:a {:href (str "/articles/" (:_id a))} (:title a)]]])))

(defn article [a]
  (base-page
    [:small (:created a)]
    [:h1 (:title a)]
    [:p (:body a)]))
