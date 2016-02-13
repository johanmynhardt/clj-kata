(ns clj-kata.kata01)

(defn -idx [list min max]
  (let [idx (java.lang.Math/round (/ (+ min max) 2.0))]
    ;; (println "idx:" idx)
    idx))

(defn -search [data search min max]
  (println "search(" search ") min=" min ", max=" max)
  (if (< max min) -1
      (let [mid (-idx data min max)
            mv (nth data mid)]
        (cond (> mv search) (recur data search min (- mid 1))
              (< mv search) (recur data search (+ mid 1) max)
              :else mid))))

(defn chop [search list]
  (-search list search 0 (- (count list) 1)))


  
 
