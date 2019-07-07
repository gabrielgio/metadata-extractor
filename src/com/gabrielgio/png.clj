(ns com.gabrielgio.png
  (:require [com.gabrielgio.directory :refer :all])
  (:import (com.drew.metadata.png PngDirectory)))

(defn get-png-directory [^PngDirectory dir]
  (-> {}
      (assoc-if-contains-int    dir :png/width                  PngDirectory/TAG_IMAGE_WIDTH)
      (assoc-if-contains-int    dir :png/height                 PngDirectory/TAG_IMAGE_HEIGHT)
      (assoc-if-contains-int    dir :png/bits-per-sample        PngDirectory/TAG_BITS_PER_SAMPLE)
      (assoc-if-contains-int    dir :png/color-type             PngDirectory/TAG_COLOR_TYPE)
      (assoc-if-contains-int    dir :png/compression-type       PngDirectory/TAG_COMPRESSION_TYPE)
      (assoc-if-contains-int    dir :png/filter-method          PngDirectory/TAG_FILTER_METHOD)
      (assoc-if-contains-int    dir :png/interlace-method       PngDirectory/TAG_INTERLACE_METHOD)
      (assoc-if-contains-int    dir :png/palette-size           PngDirectory/TAG_PALETTE_SIZE)
      (assoc-if-contains-int    dir :png/has-transparency       PngDirectory/TAG_PALETTE_HAS_TRANSPARENCY)
      (assoc-if-contains-int    dir :png/srgb-rendering-intent  PngDirectory/TAG_SRGB_RENDERING_INTENT)
      (assoc-if-contains-double dir :png/gamma                  PngDirectory/TAG_GAMMA)
      (assoc-if-contains-int    dir :png/icc-profile-name       PngDirectory/TAG_ICC_PROFILE_NAME)
      (assoc-if-contains-object dir :png/textual-data           PngDirectory/TAG_TEXTUAL_DATA)
      (assoc-if-contains-date   dir :png/last-modification-time PngDirectory/TAG_LAST_MODIFICATION_TIME)
      (assoc-if-contains-bytes  dir :png/background-color       PngDirectory/TAG_BACKGROUND_COLOR)
      (assoc-if-contains-int    dir :png/pixel-per-unit-x       PngDirectory/TAG_PIXELS_PER_UNIT_X)
      (assoc-if-contains-int    dir :png/pixel-per-unit-y       PngDirectory/TAG_PIXELS_PER_UNIT_Y)
      (assoc-if-contains-int    dir :png/unit-specifier         PngDirectory/TAG_UNIT_SPECIFIER)))
