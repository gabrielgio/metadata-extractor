(ns com.gabrielgio.me.exif-sub-ifd
  (:import (com.drew.metadata.exif ExifSubIFDDirectory)))

(defn get-exif-sub-ifd-directory [^ExifSubIFDDirectory dir]
  {:exif-subifd/date-original  (.getDateOriginal dir)
   :exif-subifd/date-digitized (.getDateDigitized dir)})