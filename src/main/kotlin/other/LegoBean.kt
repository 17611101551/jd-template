package other

fun LegoBean(
        packageName:String,
        activityClass:String
)="""
package ${packageName}
import com.jd.jrapp.bm.common.templet.bean.TempletBaseBean
import com.jd.jrapp.bm.common.templet.bean.TempletTextBean
import com.jd.jrapp.bm.common.templet.bean.Verifyable

class ${activityClass}Bean : TempletBaseBean() {
    var imgUrl: String? = null
    var title1: TempletTextBean? = null

    override fun verify(): Verifyable.VerifyResult {
        return super.verify()
    }
}    
"""