(ns com.gabrielgio.me.png
  (:require [com.gabrielgio.me.directory :refer :all])
  (:import (com.drew.metadata.png PngDirectory)))

(defn get-png-directory [^PngDirectory dir]
  (-> {}
      (assoc-dir-int dir :png/width PngDirectory/TAG_IMAGE_WIDTH)
      (assoc-dir-int dir :png/height PngDirectory/TAG_IMAGE_HEIGHT)
      (assoc-dir-int dir :png/bits-per-sample PngDirectory/TAG_BITS_PER_SAMPLE)
      (assoc-dir-int dir :png/color-type PngDirectory/TAG_COLOR_TYPE)
      (assoc-dir-int dir :png/compression-type PngDirectory/TAG_COMPRESSION_TYPE)
      (assoc-dir-int dir :png/filter-method PngDirectory/TAG_FILTER_METHOD)
      (assoc-dir-int dir :png/interlace-method PngDirectory/TAG_INTERLACE_METHOD)
      (assoc-dir-int dir :png/palette-size PngDirectory/TAG_PALETTE_SIZE)
      (assoc-dir-int dir :png/has-transparency PngDirectory/TAG_PALETTE_HAS_TRANSPARENCY)
      (assoc-dir-int dir :png/srgb-rendering-intent PngDirectory/TAG_SRGB_RENDERING_INTENT)
      (assoc-dir-double dir :png/gamma PngDirectory/TAG_GAMMA)
      (assoc-dir-int dir :png/icc-profile-name PngDirectory/TAG_ICC_PROFILE_NAME)
      (assoc-dir-object dir :png/textual-data PngDirectory/TAG_TEXTUAL_DATA)
      (assoc-dir-date dir :png/last-modification-time PngDirectory/TAG_LAST_MODIFICATION_TIME)
      (assoc-dir-bytes dir :png/background-color PngDirectory/TAG_BACKGROUND_COLOR)
      (assoc-dir-int dir :png/pixel-per-unit-x PngDirectory/TAG_PIXELS_PER_UNIT_X)
      (assoc-dir-int dir :png/pixel-per-unit-y PngDirectory/TAG_PIXELS_PER_UNIT_Y)
      (assoc-dir-int dir :png/unit-specifier PngDirectory/TAG_UNIT_SPECIFIER)))
