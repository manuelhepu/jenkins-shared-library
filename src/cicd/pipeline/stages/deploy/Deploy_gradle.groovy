package cicd.pipeline.stages.deploy

import cicd.config.ProjectConfiguration


class Deploy_gradle {
   static void main(ProjectConfiguration pjc) {

      pjc.steps.echo"----DEPLOY GRADLE ----"

      //deploy(pjc)
   }


   def static deploy(ProjectConfiguration pjc){
     
      
      pjc.steps.withGradle{
         pjc.steps.sh "chmod +x ./gradlew"
         pjc.steps.sh "./gradlew bootRun"

      }
   }
   
   
}