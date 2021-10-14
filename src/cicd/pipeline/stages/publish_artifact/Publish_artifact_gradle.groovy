package cicd.pipeline.stages.publish_artifact

import cicd.config.ProjectConfiguration


class Publish_artifact_gradle {
   static void main(ProjectConfiguration pjc) {
     
      
      pjc.steps.echo"----PUBLISH ARTIFACT GRADLE ----"
   }
   
   
}