package springsecurity

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.userdetails.GrailsUser

class HomeController {

    SpringSecurityService springSecurityService

    @Secured('ROLE_USER')
    def index() {
        // respond handles content negotation
        render "<output>Hello '${loggedUsername()}'!</output>"
        // Following needs "home/index.gson" and "compile 'org.grails.plugins:views-json'"
        // [name: loggedUsername()]
    }

    String loggedUsername() {
        if (springSecurityService.principal == null) {
            return null
        }
        if (springSecurityService.principal instanceof String) {
            return springSecurityService.principal
        }
        if (springSecurityService.principal instanceof GrailsUser) {
            return ((GrailsUser) springSecurityService.principal).username
        }
        null
    }

}
