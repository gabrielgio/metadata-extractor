(ns com.gabrielgio.file
  (:require [com.gabrielgio.directory :refer :all])
  (:import (com.drew.metadata.file FileTypeDirectory)
           (com.drew.metadata.file FileSystemDirectory)))

(defn get-file-type-directory [^FileTypeDirectory dir]
  (-> {}
      (assoc-if-contains-int dir :file-type/detected-file-type-name      FileTypeDirectory/TAG_DETECTED_FILE_TYPE_NAME)
      (assoc-if-contains-int dir :file-type/detected-file-type-long-name FileTypeDirectory/TAG_DETECTED_FILE_TYPE_LONG_NAME)
      (assoc-if-contains-int dir :file-type/detected-file-mime-type      FileTypeDirectory/TAG_DETECTED_FILE_MIME_TYPE)
      (assoc-if-contains-int dir :file-type/detected-file-name-extension FileTypeDirectory/TAG_EXPECTED_FILE_NAME_EXTENSION)        ))

(defn get-file-system-directory [^FileSystemDirectory dir]
  {:file-system/file-name (.getString dir FileSystemDirectory/TAG_FILE_NAME)
   :file-system/file-size (.getLong dir FileSystemDirectory/TAG_FILE_SIZE)
   :file-system/file-modified-date (.getDate dir FileSystemDirectory/TAG_FILE_MODIFIED_DATE)})