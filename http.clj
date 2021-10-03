(require '[clj-http.client :as client])
(client/head "http://example.com/resource")
(client/get "http://example.com.resources/id")
(client/put "http://example.com/api"
            {:body "my PUT body"})
(client/delete "http://example.com/resource")

