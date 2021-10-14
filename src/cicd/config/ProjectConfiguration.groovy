package cicd.config

import java.util.Set

class ProjectConfiguration {
    def environment
    def buildNumber
    static def steps
    static def version
    def env
    static def configGeneral = [:]
    static def tipoRepo = [:]
    static def configEspe = [:]
    static def config = [:]
    static def cicd = [:]
    def stages_project
    def list_stages
    def pipeline
    static def status_build = 'INITIAL'

}
