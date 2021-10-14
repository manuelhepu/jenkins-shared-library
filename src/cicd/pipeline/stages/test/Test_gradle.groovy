package cicd.pipeline.stages.test

import cicd.config.ProjectConfiguration


/* groovylint-disable-next-line ClassJavadoc */
class Test_gradle {
   
   static void main(ProjectConfiguration pjc) {
      
        pjc.steps.echo"----TEST GRADLE ----"

        test(pjc)


      


   }


   def static test(ProjectConfiguration pjc){
      
      pjc.steps.withGradle{
         pjc.steps.sh "./gradlew test"
      }
   }
   
   
}