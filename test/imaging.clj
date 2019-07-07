(ns imaging
  (:require [clojure.test :refer :all]
            [com.gabrielgio.core :refer [get-metadata]])
  (:import (java.text SimpleDateFormat)
           (java.util TimeZone)))

(defn format-date [date]
  (let [formatter (SimpleDateFormat. "yyyy-MM-dd hh:mm:ss")]
    (.setTimeZone formatter (TimeZone/getTimeZone "UTC"))
    (.format formatter date)))

(testing "gimp greyscale with many chunks"
  (let [file (clojure.java.io/file "test/data/gimp-8x12-greyscale-alpha-time-background.png")
        meta (get-metadata file)]
    (is (= 8 (:png/width meta)))
    (is (= 12 (:png/height meta)))
    (is (= 8 (:png/bits-per-sample meta)))
    (is (= 4 (:png/color-type meta)))
    (is (= 0 (:png/compression-type meta)))
    (is (= 0 (:png/filter-method meta)))
    (is (= 0 (:png/interlace-method meta)))
    (is (> 0.00001 (- (:png/gamma meta) 0.45455)))
    (is (= (byte 0) (first (:png/background-color meta))))
    (is (= (byte 52) (last (:png/background-color meta))))
    (is (= 1 (:png/unit-specifier meta)))
    (is (= 2835 (:png/pixel-per-unit-x meta)))
    (is (= 2835 (:png/pixel-per-unit-y meta)))
    (is (= "2013-01-01 04:08:30" (format-date (:png/last-modification-time meta))))
    (is (= 0 (:png/interlace-method meta)))
    (is (= "Comment" (-> meta :png/textual-data first .getKey)))
    (is (= "Created with GIMP" (-> meta :png/textual-data first .getValue str)))))