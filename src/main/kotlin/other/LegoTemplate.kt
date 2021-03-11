package other

fun LegoTemplate(
        applicationPackage:String?,
        activityClass:String,
        layoutName:String,
        packageName:String
)="""
package ${packageName}
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.jd.jrapp.bm.common.exposureV2.helper.ExpDataTransformer
import com.jd.jrapp.bm.common.templet.category.AbsCommonTemplet
import com.jd.jrapp.library.imageloader.glide.GlideHelper
import com.jd.jrapp.library.keeplive.KeepaliveMessage
import ${applicationPackage}.R

class ${activityClass}Template(mContext: Context)  : AbsCommonTemplet(mContext) {
    private var templateData: ${activityClass}Bean? = null
    private lateinit var ivIcon: ImageView
    private lateinit var tvTitle: TextView
    
    override fun bindLayout(): Int {
        return R.layout.${layoutName}
    }
    
    override fun initView() {
        ivIcon = findViewById(R.id.iv_template_icon) as ImageView
        tvTitle = findViewById(R.id.tv_template_title) as TextView
    }
    
    override fun fillData(model: Any?, position: Int) {
        super.fillData(model, position)
        val templateBean: ${activityClass}Bean = getTempletBean(model, ${activityClass}Bean::class.java)
        if (templateBean == null) {
            return
        }
        templateData = templateBean
        //设置文字
        setCommonText(templateBean.title1, tvTitle, "#333333")
        //加载图片
        GlideHelper.load(mContext, templateBean.imgUrl, ivIcon)

        //如果要屏蔽根布局跳转打开这里注释
        //bindJumpTrackData(null,null,null)
       
        bindJumpTrackData(templateBean.forward, templateBean.track, mLayoutView)
    }
    
    //外层容器使用RecycleExpReporter时复写可实现曝光
    override fun getDataByV1(): MutableList<KeepaliveMessage> {
        val list = mutableListOf<KeepaliveMessage>();
        templateData?.track?.let {
            list.addAll(ExpDataTransformer.trackBean2KeepAliveMsg(mContext, it))
        }
        return list
    }
}
"""