import cicd.config.ProjectConfiguration
//Recorremos los stage de la tecnologia
def call(ProjectConfiguration pjc) {
    if (pjc.list_stages)
    {
        stages_build = pjc.list_stages
        node(pjc.configEspe.NODE_PREFERENCE){

            stages_build.each { stage_build ->
                def stage_buildClass = stage_build.capitalize()

                stage(stage_build) {
                    def stageClass = Class.forName("cicd.pipeline.stages." + stage_buildClass,true,Thread.currentThread().contextClassLoader)
                    stageClass.main(pjc)


                }
            }
        }
    }
}
