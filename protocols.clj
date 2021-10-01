(defprotocol Shape
  (area [this]))

(defrecord Circle [r]
  Shape
  (area [c]
    (* Math/PI (.r c) (.r c))))

(deftype Square [a]
  Shape
  (area [s]
    (* (.a s) (.a s))))

(defn make-bar [w h]
  (reify
    Shape
    (area [_]
      (* w h))))
