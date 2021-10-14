package cicd.pipeline.stages.build

import cicd.config.ProjectConfiguration


class Build_maven {
    
   static void main(ProjectConfiguration pjc) {

      pjc.steps.echo"----BUILD MAVEN ----"
      
      //build(pjc)
       
   }

   def static build(ProjectConfiguration pjc){
     
      

      pjc.steps.sh "mvn verify"


   }
   



}