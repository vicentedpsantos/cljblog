(filter odd? [1 2 3 4 5]) ;;=> (1 3 5)
(filter odd?) ;;=> Returns transducer

(map inc [1 2 3 4 5]) ;; => (2 3 4 5 6)
(map inc) ;;=> Returns transduncer

;; Transducer composition
(def xf
  (comp
    (filter odd?)
    (map inc)
    (take 5)))

;; apply transducer
(transduce xf + (range 5)) ;; works like reduce => results in 6
(eduction xf (range 5)) ;; works like apply => results in (2 4)
