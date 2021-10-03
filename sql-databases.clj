(require '[clojure.java.jdbc :as j])

(def pg-db {:dbtype "postgresql"
            :dbname "plan_development"
            :host "localhost"
            :user "postgres"
            :password "postgres"})

(j/query pg-db ["SELECT * FROM users"])

(j/insert! pg-db :users {:first_name "Tamires"
                         :last_name "Quito"
                         :password "password123"
                         :email "tamires@email.com"
                         :login "tquito"})

(j/delete! pg-db :users ["first_name = ?" "Ann"])
(j/delete! pg-db :orders ["id = ?" 54])
