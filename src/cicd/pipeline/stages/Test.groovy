package cicd.pipeline.stages

import cicd.config.ProjectConfiguration

class Test {

    static void main(ProjectConfiguration pjc) {
        def stageClass = Class.forName("cicd.pipeline.stages.test.Test_" + pjc.config.repo_type, 
                                        true, 
                                        Thread.currentThread().contextClassLoader)
        stageClass.main(pjc)
    }
}
