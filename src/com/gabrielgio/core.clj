(ns com.gabrielgio.core
  (:require [com.gabrielgio.jpeg :refer [get-jpeg-directory]]
            [com.gabrielgio.exif-sub-ifd :refer [get-exif-sub-ifd-directory]]
            [com.gabrielgio.file :refer [get-file-type-directory get-file-system-directory]]
            [com.gabrielgio.png :refer [get-png-directory]])
  (:import (com.drew.imaging ImageMetadataReader)
           (java.io File)
           (com.drew.metadata.exif ExifSubIFDDirectory)
           (com.drew.metadata.jpeg JpegDirectory)
           (com.drew.metadata Directory)
           (com.drew.metadata.file FileTypeDirectory FileSystemDirectory)
           (com.drew.metadata.png PngDirectory)))

(defn router-directory [^Directory dir]
  (condp instance? dir
    JpegDirectory       (get-jpeg-directory dir)
    ExifSubIFDDirectory (get-exif-sub-ifd-directory dir)
    FileTypeDirectory   (get-file-type-directory dir)
    PngDirectory        (get-png-directory dir)
    FileSystemDirectory (get-file-system-directory dir)))

(defn get-metadata [^File file]
  (let [metadata (ImageMetadataReader/readMetadata file)]
    (->> (.getDirectories metadata)
         (map router-directory)
         (reduce merge))))