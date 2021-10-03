(require '[ring.adapter.jetty :as ring])
(require '[compojure.core :refer :all])
(require '[compojure.route :as route])

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World"})

(ring/run-jetty handler {:port 3000
                         :join? false})

(defroutes app
  (GET "/" [] "<h1>Hello from Compojure!</h1>")
  (GET "/test/:id" [id] (str "Hello, " id)))

(ring/run-jetty app {:port 3000
                     :join? false})
