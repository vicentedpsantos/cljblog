(slurp "Example.txt") ;;=> Read from

(spit "Example.txt" "This is a string") ;;=> Write to
(spit "Example.txt" "Gremio campeao" :append true)

(with-open [w (clojure.java.io/writer "Example.txt" :append true)]
  (.write w "test string"))

(.exists (clojure.java.io/file "Example.txt"))
(.delete (clojure.java.io/file "Example.txt"))
