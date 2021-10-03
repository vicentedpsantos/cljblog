(require '[hiccup.core :as h])

(h/html [:body [:h1 {:class "header"} "Header"] [:p "some text"]])
(h/html [:body [:h1.header "Header"] [:p "some text"]])

(require '[net.cgrand.enlive-html :as h])

(h/deftemplate my-templ "resources/application.html"
  []
  [:head, :title]
  (h/content "Enlive starter kit"))
