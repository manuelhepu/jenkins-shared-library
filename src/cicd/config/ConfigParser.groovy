package cicd.config

import cicd.config.ProjectConfiguration

import org.yaml.snakeyaml.Yaml


class ConfigParser implements Serializable {


    static ProjectConfiguration parse(def steps, def env, def pipelineConfig) {

        //CREACIÓN NUEVO OBJETO PROJECTCONFIGURATION
        ProjectConfiguration pjc = new ProjectConfiguration()
        
        pjc.steps = steps
        pjc.env = env
        pjc.buildNumber = env.BUILD_ID

        //CREACION DE LA RUTA
        String dir_lib = env.JENKINS_HOME + '/workspace/' +  env.JOB_NAME.split('/')[0]  + '_' +  env.BRANCH_NAME.replaceAll('/','_') + "@script"
        //CARGA CONFIGURACIÓN GENERAL
        pjc.configGeneral = loadConfigFile("${dir_lib}/pipelines/env.cicd.yml")                 

        //CARGAMOS  EL ARCHIVO proyect-config.yml de la aplicación en memoria
        pjc.tipoRepo = configFile(env,dir_lib)
        
        //CARGA CONFIGURACIÓN ESPECIFICA TIPOLOGIA PROYECTO
        pjc.configEspe = loadConfigFile(dir_lib + '/pipelines/cicd-config.'+ pjc.tipoRepo.config.repo_type + '.yml')
        pjc.config = pjc.tipoRepo.config
         
        pjc.list_stages = parseStages(pjc)


        return pjc
    }




    //CARGA LOS STAGES A EJECUTAR, DEPENDIENDO DEL FICJERO DE CONFIGURACIÓN
    static def parseStages(ProjectConfiguration pjc) {

        def stg=[]
        def yamlPipeline = pjc.configEspe
        
        yamlPipeline.stages.each{ st ->
               stg.add(st)
        }

        
        return stg;
    }


    static def configFile(def env, def dir_lib) {
        static Map env_config
        def fileProject = new File(env.WORKSPACE + "/project-config.yml")
        println("entradaArchivo")
        if (!fileProject.exists()){
            env_config = loadConfigFile("${dir_lib}/pipelines/project-config"+env.JOB_NAME.split('/')[0]+".yml") 
        }else{
            env_config = loadConfigFile(env.WORKSPACE + "/project-config.yml")
        }

        return env_config
    }


  
    //FUNCION PARA LA CARGA DE ARCHIVOS .yml
    static def loadConfigFile(def fileName) {
        static Map env_config
        try {
                
            File configFile = fileName as File        
            env_config = new Yaml().load(configFile.text)
            

        } catch (e) {
            println("Error en el fichero:" + fileName)
        }
        return env_config
    }
}
