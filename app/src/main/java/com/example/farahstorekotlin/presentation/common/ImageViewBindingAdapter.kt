package com.example.farahstorekotlin.presentation.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.example.farahstorekotlin.R

@BindingAdapter(
    "app:setGlideRequestManager",
    "app:setUrl",
    "app:setImageVersion", // Not required
    "app:setPlaceHolder", // Not required
    "app:setErrorDrawable", // Not required
    "app:setImageSize",
    requireAll = false
)
fun AppCompatImageView.setImageUrl(requestManager: RequestManager?,
                                   imageUrl: String?,
                                   imageVersion: Long = 0L,
                                   placeholder: Int = R.drawable.ic_placeholder_square,
                                   errorDrawable: Int = R.drawable.ic_placeholder_square,
                                   imageSize: ImageSize? = ImageSize.Medium) {

    if (requestManager == null) {
        return
    }

    if (imageUrl.isNullOrEmpty()) return

    var requestOptions = RequestOptions().placeholder(placeholder).error(errorDrawable)

    when (imageSize) {
        ImageSize.Small -> {
            requestOptions = requestOptions.override(width, height)
        }

        ImageSize.Mediocre -> {
            requestOptions = requestOptions.override(width, height)
        }

        ImageSize.Medium -> {
            requestOptions = requestOptions.override(width, height)
        }
        ImageSize.load_Extra_Medium -> {
            requestOptions = requestOptions.override(width, height)
        }
        ImageSize.Full_Image_Extra_Large -> {
            requestOptions = requestOptions.override(width, height)
        }
        ImageSize.Full_Image_Extra_x_Large -> {
            requestOptions = requestOptions.override(width, height)
        }

    }

    requestManager.apply {

        this?.applyDefaultRequestOptions(requestOptions)
    }?.load(imageUrl)?.signature(ObjectKey(imageVersion))?.into(this)


}

enum class ImageSize(val width: Int, val height: Int) {
    Small(50, 50),
    Mediocre(250, 250),
    Medium(512, 512),
    load_Extra_Medium(1080, 1080),
    Full_Image_Extra_Large(1440, 1440),
    Full_Image_Extra_x_Large(2880, 2880)

}