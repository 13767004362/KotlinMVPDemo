package com.xingen.example.utlis.glide

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.*
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader
import java.io.InputStream
import java.util.regex.Pattern

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */

internal class CustomBaseGlideUrlLoader(concreteLoader: ModelLoader<GlideUrl, InputStream>, modelCache: ModelCache<String, GlideUrl>): BaseGlideUrlLoader<String>(concreteLoader,modelCache){
    /**
     * Url的匹配规则
     */
     val patern= Pattern.compile("__w-((?:-?\\d+)+)__")
    /**
     * 控制需要加载图片的尺寸大小
     */
    override fun getUrl(model: String, width: Int, height: Int, options: Options?): String {
      var  m=patern.matcher(model)
        var bestBucket=0
        if (m.find()){
           var  found=m.group(1).split("-")
            for (item in found){
                bestBucket=item.toInt()
                if (bestBucket>=width) break
            }
        }
        return model
    }
    override fun handles(model: String?)=true
    companion object{
        val urlCache= ModelCache<String, GlideUrl>(150)
        /**
         * 默认是私有的，通过@JvmField注解暴露给Java调用
         */
        @JvmField
        val factory=object: ModelLoaderFactory<String, InputStream> {
            override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<String, InputStream> {
                     return CustomBaseGlideUrlLoader(multiFactory.build(GlideUrl::class.java, InputStream::class.java), urlCache)
            }
            override fun teardown() {
            }
        }
    }
}
