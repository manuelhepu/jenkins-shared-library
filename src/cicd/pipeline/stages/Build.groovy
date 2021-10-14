package cicd.pipeline.stages

import cicd.config.ProjectConfiguration

class Build {

    static void main(ProjectConfiguration pjc) {
        def stageClass = Class.forName("cicd.pipeline.stages.build.Build_" + pjc.config.repo_type, 
                                        true, 
                                        Thread.currentThread().contextClassLoader)
        stageClass.main(pjc)
    }
}
