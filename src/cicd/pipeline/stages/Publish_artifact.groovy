package cicd.pipeline.stages

import cicd.config.ProjectConfiguration

class Publish_artifact {

    static void main(ProjectConfiguration pjc) {
        def stageClass = Class.forName("cicd.pipeline.stages.publish_artifact.Publish_artifact_" + pjc.config.repo_type, 
                                        true, 
                                        Thread.currentThread().contextClassLoader)
        stageClass.main(pjc)
    }
}