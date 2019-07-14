(ns com.gabrielgio.me.jpeg
  (:import (com.drew.metadata.jpeg JpegDirectory JpegComponent HuffmanTablesDirectory)))

(defn get-huffman-directory [^HuffmanTablesDirectory dir]
  {:huffman-tables/is-optimized (.isOptimized dir)
   :huffman-tables/is-typical (.isTypical dir)})

(defn get-jpeg-directory-component [^JpegComponent comp]
  {:name                       (.getComponentName comp)
   :quantization-table         (.getQuantizationTableNumber comp)
   :horizontal-sampling-factor (.getHorizontalSamplingFactor comp)
   :vertical-sampling-factor   (.getVerticalSamplingFactor comp)})

(defn get-jpeg-directory-components [^JpegDirectory dir]
  (->> (range (.getNumberOfComponents dir))
       (map #(.getComponent dir %))
       (map get-jpeg-directory-component)))

(defn get-jpeg-directory [^JpegDirectory dir]
  {:jpeg/width            (.getImageWidth dir)
   :jpeg/height           (.getImageHeight dir)
   :jpeg/compression-type (.getDescription dir JpegDirectory/TAG_COMPRESSION_TYPE)
   :jpeg/data-precision   (.getInt dir JpegDirectory/TAG_DATA_PRECISION)
   :jpeg/components       (get-jpeg-directory-components dir)})