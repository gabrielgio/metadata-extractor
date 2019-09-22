(ns imaging-test
  (:require [clojure.test :refer :all]
            [com.gabrielgio.me.core :refer [get-metadata]])
  (:import (java.text SimpleDateFormat)
           (java.util TimeZone)))

(defn format-date [date]
  (let [formatter (SimpleDateFormat. "yyyy-MM-dd hh:mm:ss")]
    (.setTimeZone formatter (TimeZone/getTimeZone "UTC"))
    (.format formatter date)))

(deftest png-metadata-reader-test
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
      (is (= "Created with GIMP" (-> meta :png/textual-data first .getValue str))))))

(deftest jpeg-metadata-reader-test
  (testing "extract xmp metadata"
    (let [file (clojure.java.io/file "test/data/withXmp.jpg")
          meta (get-metadata file)]
      (is (not (nil? (:xmp/xmp-values meta))))
      (is (true? (:huffman-tables/is-optimized meta)))))

  (testing "typical huffman"
    (let [file (clojure.java.io/file "test/data/withTypicalHuffman.jpg")
          meta (get-metadata file)]
      (is (true? (:huffman-tables/is-typical meta)))
      (is (false? (:huffman-tables/is-optimized meta))))))

(deftest bmp-header-metadata-reader-test
  (testing "test MsPaint 16 color"
    (let [file (clojure.java.io/file "test/data/16color-10x10.bmp")
          meta (get-metadata file)]
      (is (= 10 (:bmp/tag-image-width meta)))
      (is (= 10 (:bmp/tag-image-height meta)))
      (is (= 4 (:bmp/tag-bits-per-pixel meta)))
      (is (= "None" (:bmp/tag-compression meta)))
      (is (= 0 (:bmp/tag-x-pixel-per-meter meta)))
      (is (= 0 (:bmp/tag-y-pixel-per-meter meta)))
      (is (= 0 (:bmp/tag-palette-colour-count meta)))
      (is (= 0 (:bmp/tag-important-colour-count meta)))
      (is (= 1 (:bmp/tag-colour-planes meta)))
      (is (= 40 (:bmp/tag-header-size meta)))))
  (testing "test MsPaint 24 bpp"
    (let [file (clojure.java.io/file "test/data/24bpp-10x10.bmp")
          meta (get-metadata file)]
      (is (= 10 (:bmp/tag-image-width meta)))
      (is (= 10 (:bmp/tag-image-height meta)))
      (is (= 24 (:bmp/tag-bits-per-pixel meta)))
      (is (= "None" (:bmp/tag-compression meta)))
      (is (= 0 (:bmp/tag-x-pixel-per-meter meta)))
      (is (= 0 (:bmp/tag-y-pixel-per-meter meta)))
      (is (= 0 (:bmp/tag-palette-colour-count meta)))
      (is (= 0 (:bmp/tag-important-colour-count meta)))
      (is (= 1 (:bmp/tag-colour-planes meta)))
      (is (= 40 (:bmp/tag-header-size meta))))))


; TODO: this test wont work since it does not work on the upstream project
;(deftest adobe-jpeg-reader-test
;  (testing "test read adobe jpeg metadata1"
;    (let [file (clojure.java.io/file "test/data/adobeJpeg1.jpg.appe")
;          meta (get-metadata file)]
;      (is (= 1 (:adobe-jpeg/tag-color-transform meta))))))