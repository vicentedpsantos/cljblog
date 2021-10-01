;; Structs accept only the :y call

(defstruct point-s :n :x :y)
(def p-s (struct point-s "A" 10 20))
(:y p-s)

;; Types accept the . call
(deftype PointT [n x y])
(def p-t (PointT. "B" 12 15))
(.y p-t)

;; Records accept both . and :
(defrecord PointR [n x y])
(def p-r (PointR. "C" 15 17))
(.y p-r)
(:y p-r)
