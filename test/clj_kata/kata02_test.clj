(ns clj-kata.kata02-test
  (:require [clojure.test :refer :all]
            [clj-kata.kata02 :refer :all]))

(deftest chop-3-nothing
  (testing "FIXME, I fail."
    (is (= -1 (chop 3 [])))))

(deftest chop-3-1
  (testing "fixme"
    (is (= -1 (chop 3 [1])))))

(deftest chop-1-1
  (testing "fixme"
    (is (= 0 (chop 1 [1])))))

(deftest chop-1-1-3-5 (testing "fixme" (is (= 0 (chop 1 [1 3 5])))))
(deftest chop-3-1-3-5 (testing "fixme" (is (= 1 (chop 3 [1 3 5])))))
