(defmulti area (fn [shape] (:type shape)))

(defmethod area :circle [c]
  (* Math/PI (:r c) (:r c)))

(area {:type :circle, :r 10})

(defmethod area :square [s]
  (* (:a s) (:a s)))

(area {:type :square, :a 20})

;; You can also call it on a map with the same attributes
(def my-circle {:type :circle, :r 10})
(area my-circle)


;; Defining multimethod for str-shape
(defrecord Circle [r])
(defrecord Square [a])

(defmulti str-shape (fn [shape fmt]
                      [(class shape) fmt]))

(defmethod str-shape [Circle :short] [c _]
  (str "C: " (.r c)))

(defmethod str-shape [Circle :detailed] [c _]
  (str "Circle with radius: " (.r c)))

(defmethod str-shape [Square :short] [s _]
  (str "S: " (.a s)))

(defmethod str-shape [Square :detailed] [s _]
  (str "Square with side: " (.a s)))

(def c (Circle. 10))
(def s (Square. 20))

(str-shape c :short)
(str-shape s :detailed)
