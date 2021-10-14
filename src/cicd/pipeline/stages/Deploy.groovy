package cicd.pipeline.stages

import cicd.config.ProjectConfiguration

class Deploy {

    static void main(ProjectConfiguration pjc) {
        def stageClass = Class.forName("cicd.pipeline.stages.deploy.Deploy_" + pjc.config.repo_type, 
                                        true, 
                                        Thread.currentThread().contextClassLoader)
        stageClass.main(pjc)
    }
}
