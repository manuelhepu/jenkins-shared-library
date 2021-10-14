package cicd.pipeline.stages.build

import cicd.config.ProjectConfiguration


class Build_gradle {
   static void main(ProjectConfiguration pjc) {

      pjc.steps.echo"----BUILD GRADLE ----"
      
      build(pjc)
       
   }

   def static build(ProjectConfiguration pjc){
     
      
      pjc.steps.withGradle{
         pjc.steps.sh "chmod +x ./gradlew"
         pjc.steps.sh "./gradlew assemble"

      }
   }
   



}