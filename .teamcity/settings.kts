import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

version = "2025.11"

project {

    val N = 1000 //number of VCS roots

    for (i in 1..N) {

        vcsRoot(GitVcsRoot({
            id("GitRoot_$i") 
            name = "Git Root #$i"
            url = "https://github.com/ChubatovaTiger/manyBranches"
            branch = "refs/heads/br-demo$i"   
            authMethod = uploadedKey {
                name = "faulty_crocodile"
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



