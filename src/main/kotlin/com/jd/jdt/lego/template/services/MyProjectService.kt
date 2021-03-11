package com.jd.jdt.lego.template.services

import com.intellij.openapi.project.Project
import com.jd.jdt.lego.template.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }

}
