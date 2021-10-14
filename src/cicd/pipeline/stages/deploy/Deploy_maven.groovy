package cicd.pipeline.stages.deploy

import cicd.config.ProjectConfiguration


class Deploy_maven {
   static void main(ProjectConfiguration pjc) {

      pjc.steps.echo"----DEPLOY MAVEN ----"

      //deploy(pjc)
   }



   
   
}