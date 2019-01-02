package com.nasahapps.kson

import platform.Foundation.*

internal fun String.nsData() = (this as NSString).dataUsingEncoding(NSUTF8StringEncoding)
internal fun NSData?.string(): String? {
    this?.let {
        return NSString.create(it, NSUTF8StringEncoding) as String?
    }

    return null
}