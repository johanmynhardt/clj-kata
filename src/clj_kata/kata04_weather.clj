(ns clj-kata.kata04-weather
  (:require [clojure.string :as st]))

(def data "data/weather.dat")

(defn parse-records [location]
  (let [rows (st/split-lines (slurp location))]
    rows))

(defn rem-empty [records]
  (remove empty? records))

(defn ltrim [records]
  (map st/triml records))

(defn data-row [record]
  "Processes raw records into data fields per row."
  (let [row (st/split record #"\s+")
        fix (fn [s]
              (if (.contains s "*") (st/replace s #"\*" "")
                  s))
        no-star (map fix row)]
    no-star))

(defn data-rows [records]
  (map data-row records))

(defn lines [records]
  "Prints the records with min, max and spread."
  (doseq [item records]
    (let [min (Integer/parseInt (nth item 2))
          max (Integer/parseInt (nth item 1))
          diff (- max min)]
      (println "min:" min "max:" max "diff:" diff "---"))))

(defn find-ss [records]
  "Finds the smallest spread from the records to proccess."
  (let [sp (atom {:id 0 :spread 500})]
    (doseq [record records]
      (let [id (nth record 0)
            min (Integer/parseInt (nth record 2))
            max (Integer/parseInt (nth record 1))]
        (if (< (- max min) (@sp :spread))
          (do (swap! sp assoc :id id)
              (swap! sp assoc :spread (- max min))))))
    (println "smallest spread:" @sp)))

(defn day-lines [records]
  "Filter raw record rows that start with digits."
  (filter #(.matches % "\\s+\\d+.*") records))

;; Bring it all together, using thread-first.
(-> (parse-records data)
    (rem-empty)
    ;; (count)
    ;; (ltrim)
    (day-lines)
    (ltrim)
    (data-rows)
    (find-ss)
    ;; (lines)
    )

