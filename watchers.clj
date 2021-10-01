;; Watchers
(add-watch a :watcher-key
           (fn [key atom old-state new-state]
             (println key atom old-state new-state)))

(def acc1 (ref 1000))
(def acc2 (ref 1000))

(add-watch acc1 :acc1-watcher
           (fn [k r o n]
             (println "Watching...")
             (println k r o n)))

(dosync
  (alter acc1 - 10)
  (alter acc2 + 10))

;; This prints the message defined in the watcher

