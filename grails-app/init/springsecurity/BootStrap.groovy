package springsecurity

class BootStrap {

    def init = { servletContext ->

        Role adminRole = save(Role.findOrCreateWhere(authority: 'ROLE_ADMIN'))
        Role userRole = save(Role.findOrCreateWhere(authority: 'ROLE_USER'))

        User user = save(new User(username: 'user', password: 'user'))
        User admin = save(new User(username: 'admin', password: 'admin'))
    }

    static save(domainModel) {
        domainModel.save(failOnError: true, flush: true)
    }
    def destroy = {
    }
}
