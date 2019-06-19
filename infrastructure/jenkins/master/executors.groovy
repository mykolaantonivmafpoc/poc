import hudson.security.SecurityRealm
import org.jenkinsci.plugins.GithubSecurityRealm
String githubWebUri = 'https://github.com'
String githubApiUri = 'https://api.github.com'
String clientID = 'bf828dadc2d4e6a19a9c'
String clientSecret = '54498a81ad4dd676c0ddca2b808e5b67afaad400'
String oauthScopes = 'read:org,user:email,repo'
SecurityRealm github_realm = new GithubSecurityRealm(githubWebUri, githubApiUri, clientID, clientSecret, oauthScopes)
//check for equality, no need to modify the runtime if no settings changed
if(!github_realm.equals(Jenkins.instance.getSecurityRealm())) {
    Jenkins.instance.setSecurityRealm(github_realm)
    Jenkins.instance.save()