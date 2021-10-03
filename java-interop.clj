(.toUpperCase "some string")
(.getName String) ;;=> java.lang.String
(System/getProperty "java.vm.version")

(macroexpand '(.toUppercase "this string")) ;;=> (. "this string" toUppercase)
(. "some string" toUpperCase)

(Math/PI)
(. Math PI)

;; Double dot for method chains
(.. System (getProperties) (get "os.name"))
(. (. System (getProperties)) (get "os.name"))

(doto (new java.util.HashMap)
  (.put "a" 1)
  (.put "b" 2))
