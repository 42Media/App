import ftcore.security.Role
import ftcore.security.User
import ftcore.security.UserRole

class BootStrap {

    def init = { servletContext ->


        def adminRole   = new Role(authority: 'ROLE_ADMIN').save()
        def userRole    = new Role(authority: 'ROLE_USER').save()

        def testUser    = new User(username: 'admin', password: 'password').save()

        UserRole.create testUser, adminRole

    }
    def destroy = {
    }
}
