import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

version = "2024.03"

project {

    val N = 1000 //number of VCS roots

    for (i in 1..N) {

        vcsRoot(GitVcsRoot({
            id("GitRoot_$i") 
            name = "Git Root #$i"
            url = "https://github.com/ChubatovaTiger/manyBranches"
            branch = "refs/heads/br-demo$i"   
            authMethod = password {
                userName = "ChubatovaTiger"
                password = "credentialsJSON:e6f46e03-5155-46f5-b9ce-8b510ab63ae1"
            }
           })
        )
    }

   buildType({
    id("Build1")
    name = "Build1"
    for (i in 1..N) {
        vcs {
            root(RelativeId("GitRoot_$i"))
        }
    }
    })
}



