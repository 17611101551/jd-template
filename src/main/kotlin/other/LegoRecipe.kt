package other

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.LegoRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        layoutName: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension


    val template = LegoTemplate(projectData.applicationPackage, activityClass, layoutName, packageName)
    // 保存Lego模版
    save(template, srcOut.resolve("${activityClass}Template.${ktOrJavaExt}"))
    // 保存xml
    save(LegoXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
    // 保存legobean
    save(LegoBean(packageName, activityClass), srcOut.resolve("${activityClass}Bean.${ktOrJavaExt}"))

}