import org.jenkinsci.plugins.GithubAuthorizationStrategy
import hudson.security.AuthorizationStrategy
 
//permissions are ordered similar to web UI
//Admin User Names
String adminUserNames = 'mykolaantoniv'
//Participant in Organization
String organizationNames = 'mykolaantonivmafpoc'
//Use Github repository permissions
boolean useRepositoryPermissions = true
//Grant READ permissions to all Authenticated Users
boolean authenticatedUserReadPermission = false
//Grant CREATE Job permissions to all Authenticated Users
boolean authenticatedUserCreateJobPermission = false
//Grant READ permissions for /github-webhook
boolean allowGithubWebHookPermission = false
//Grant READ permissions for /cc.xml
boolean allowCcTrayPermission = false
//Grant READ permissions for Anonymous Users
boolean allowAnonymousReadPermission = false
//Grant ViewStatus permissions for Anonymous Users
boolean allowAnonymousJobStatusPermission = false
 
AuthorizationStrategy github_authorization = new GithubAuthorizationStrategy(adminUserNames,
    authenticatedUserReadPermission,
    useRepositoryPermissions,
    authenticatedUserCreateJobPermission,
    organizationNames,
    allowGithubWebHookPermission,
    allowCcTrayPermission,
    allowAnonymousReadPermission,
    allowAnonymousJobStatusPermission)
 
//check for equality, no need to modify the runtime if no settings changed
if(!github_authorization.equals(Jenkins.instance.getAuthorizationStrategy())) {
    Jenkins.instance.setAuthorizationStrategy(github_authorization)
    Jenkins.instance.save()
}