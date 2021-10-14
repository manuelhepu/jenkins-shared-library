import cicd.config.ConfigParser
import cicd.config.ProjectConfiguration

/*
Esta función es el punto de arranque de la libreria.
*/

def call(Map pipelineConfig = [:]) {
   ProjectConfiguration pjc

   //INICIAMOS EL PRIMER STAGE, DONDE SE REALIZARA LA CARGA DE TODOS LOS ARCHIVOS DE CONFIGURACIÓN
   stage("prepare"){
      node('master') {
         //CARGA CONFIGURACIÓN
         
         pjc = ConfigParser.parse(steps, env, pipelineConfig)
      }
   }


   //RECORREMOS LOS STAGES POR EL TIPO DE TECNOLOGIA
   BuildStages(pjc)

   

}
