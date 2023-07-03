package com.sogya.projects.screens.mapscreen

import android.graphics.Bitmap
import android.graphics.Canvas
import com.bumptech.glide.load.EncodeStrategy
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceEncoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder
import com.bumptech.glide.load.resource.bitmap.BitmapResource
import com.caverock.androidsvg.SVG
import java.io.File

class SvgEncoder(arrayPool: ArrayPool, private val bitmapPool: BitmapPool) : ResourceEncoder<SVG> {

    private val bitmapEncoder: BitmapEncoder = BitmapEncoder(arrayPool)

    override fun encode(data: Resource<SVG>, file: File, options: Options): Boolean {
        val svg = data.get()
        val picture = svg.renderToPicture()
        val width = picture.width
        val height = picture.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        picture.draw(canvas)

        return bitmapEncoder.encode(
            BitmapResource.obtain(bitmap, bitmapPool) ?: return false,
            file,
            options
        )
    }

    override fun getEncodeStrategy(options: Options): EncodeStrategy {
        return bitmapEncoder.getEncodeStrategy(options)
    }
}