(ns com.gabrielgio.me.bmp
  (:require [com.gabrielgio.me.directory :refer :all])
  (:import (com.drew.metadata.bmp BmpHeaderDirectory)))

(defn get-bmp-directory [^BmpHeaderDirectory dir]
  (-> {}
      (assoc-dir-int dir :bmp/tag-bitmap-type BmpHeaderDirectory/TAG_BITMAP_TYPE)
      (assoc-dir-int dir :bmp/tag-header-size BmpHeaderDirectory/TAG_HEADER_SIZE)
      (assoc-dir-int dir :bmp/tag-image-height BmpHeaderDirectory/TAG_IMAGE_HEIGHT)
      (assoc-dir-int dir :bmp/tag-image-width BmpHeaderDirectory/TAG_IMAGE_WIDTH)
      (assoc-dir-int dir :bmp/tag-colour-planes BmpHeaderDirectory/TAG_COLOUR_PLANES)
      (assoc-dir-int dir :bmp/tag-bits-per-pixel BmpHeaderDirectory/TAG_BITS_PER_PIXEL)
      (assoc-dir-descriptor dir :bmp/tag-compression BmpHeaderDirectory/TAG_COMPRESSION)
      (assoc-dir-int dir :bmp/tag-x-pixel-per-meter BmpHeaderDirectory/TAG_X_PIXELS_PER_METER)
      (assoc-dir-int dir :bmp/tag-y-pixel-per-meter BmpHeaderDirectory/TAG_Y_PIXELS_PER_METER)
      (assoc-dir-int dir :bmp/tag-palette-colour-count BmpHeaderDirectory/TAG_PALETTE_COLOUR_COUNT)
      (assoc-dir-int dir :bmp/tag-important-colour-count BmpHeaderDirectory/TAG_IMPORTANT_COLOUR_COUNT)
      (assoc-dir-int dir :bmp/tag-rendering BmpHeaderDirectory/TAG_RENDERING)
      (assoc-dir-int dir :bmp/tag-colour-rendering BmpHeaderDirectory/TAG_COLOR_ENCODING)
      (assoc-dir-int dir :bmp/tag-red-mask BmpHeaderDirectory/TAG_RED_MASK)
      (assoc-dir-int dir :bmp/tag-green-mask BmpHeaderDirectory/TAG_GREEN_MASK)
      (assoc-dir-int dir :bmp/tag-blue-mask BmpHeaderDirectory/TAG_BLUE_MASK)
      (assoc-dir-int dir :bmp/tag-alpha-mask BmpHeaderDirectory/TAG_ALPHA_MASK)
      (assoc-dir-int dir :bmp/tag-colour-space-type BmpHeaderDirectory/TAG_COLOR_SPACE_TYPE)
      (assoc-dir-int dir :bmp/tag-gamma-red BmpHeaderDirectory/TAG_GAMMA_RED)
      (assoc-dir-int dir :bmp/tag-gamma-green BmpHeaderDirectory/TAG_GAMMA_GREEN)
      (assoc-dir-int dir :bmp/tag-gamma-blue BmpHeaderDirectory/TAG_GAMMA_BLUE)
      (assoc-dir-int dir :bmp/tag-intent BmpHeaderDirectory/TAG_INTENT)
      (assoc-dir-int dir :bmp/tag-linked-profile BmpHeaderDirectory/TAG_LINKED_PROFILE)))