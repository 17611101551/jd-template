package other

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val JDLegoFeedTemplate
    get() = template{
        revision = 1
        name = "乐高模版"
        description = "用于创建乐高模版使用"
        minApi = MIN_API
        minBuildApi = MIN_API

        category = Category.UiComponent
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        lateinit var layoutName: StringParameter

        val activityClass = stringParameter {
            name = "template Name"
            default = "Feed101"
            help = "只输入名字，不要包含Template"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "lego_template"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(activityClass.value.toLowerCase())}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
                TextFieldWidget(activityClass),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            LegoRecipe(
                    data as ModuleTemplateData,
                    activityClass.value,
                    layoutName.value,
                    packageName.value)
        }
    }


//val defaultParameter
//    get() = stringParameter {
//        name = "Package name"
//        visible = { !isNewModule }
//        default = "com.jd.jdt"
//        constraints = listOf(Constraint.PACKAGE)
//        suggest = { packageName }
//    }