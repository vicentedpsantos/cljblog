;; Atoms
;; Shared, synchronous, independent change of individual locations
(def a (atom 0))

(deref a) ;;=> 0
@a  ;;=> 0

(swap! a inc)
@a ;;=> 1

(reset! a 42)
@a ;;=> 42


;; Agents
;; Independent, asynchronous change of individual locations
(def counter (agent 0))

(deref counter) ;;=> 0
@counter ;;=> 0

(send counter inc)
@counter ;;=> 1

(send counter + 9)
@counter ;;=> 10


;; Ref, dosync
;; Coordinated, synchronous change of multiple locations
(def acc1 (ref 1000))
(def acc2 (ref 1000))

(dosync
  (alter acc1 - 10)
  (alter acc2 + 10))

;; Another example
(def ag1 (agent 0))
(def atom1 (atom 1))

(swap! atom1 (fn [x]
               (Thread/sleep 3000)
               (inc x))) ;; => Thread sleeps for 3 seconds before incrementing value

(send ag1 (fn [x]
            (Thread/sleep 3000)
            (inc x))) ;;=> Update is async, we don't see the thread sleeping for 3 secs
